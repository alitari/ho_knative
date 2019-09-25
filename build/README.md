# Tektron pipelines 

![Tektron pipelines](https://tekton.dev/img/logos/tekton-horizontal-color.png)

## install

```bash
kubectl apply --filename https://storage.googleapis.com/tekton-releases/latest/release.yaml
```

### install dashboard

Note: the ingress works omly if an [ingress controller](https://github.com/helm/charts/tree/master/stable/nginx-ingress) is already installed. The dashboard is then accessible on `http://127.0.0.1.nip.io`

```bash
kubectl apply --filename https://github.com/tektoncd/dashboard/releases/download/v0.1.1/release.yaml
kubectl apply -f dashboard-ingress.yaml
```

## run hello world task

```bash
# create task
kubectl apply --filename helloworld-task.yaml
# run task
kubectl apply --filename helloworld-taskrun.yaml
# inspect task run
kubectl get taskrun echo-hello-world-task-run
```

## create and run a task to build a java spring app

| source | task | destination |
| ------------| -------- | ----------- |
|`java-spring-github-piperes`| `git-docker-build-task` | `java-spring-image-piperes` |

### docker registry credentials

As we push in a registry we need to create a secret for the registry credentials:

```bash
./create_registry_auth.sh
```

Link the created secret `registry-auth` to the default service account:

```bash
kubectl edit sa default
```

### build the spring app

```bash
# create java spring app resources
kubectl apply --filename java-spring-github-piperes.yaml
kubectl apply --filename java-spring-image-piperes.yaml
# create task
kubectl apply --filename git-docker-build-task.yaml
# run task
kubectl apply --filename java-spring-taskrun.yaml
# see whats going on
kubectl get tekton-pipelines
# see the logs
kubectl -n tekton-pipelines logs $(kubectl get pod --selector="tekton.dev/taskRun=java-spring-taskrun" -o=name) -c step-build-and-push | less
```

See the build result here `https://hub.docker.com/r/alitari/helloworld-java-spring` and/or run the image:

```bash
`docker run -it -p 8085:8080 -e PORT=8080 -e TARGET="Tekton" alitari/helloworld-java-spring`
```

## create and run a pipeline to build and deploy a java spring app

| in          | task     | out |
| ------------| -------- | -------- |
|`java-spring-github-piperes` | `git-docker-build-task`| `helloworld-java-spring-image` |
|`helloworld-java-spring-image` | `deploy-kubectl-task`| |

### create task and pipeline

```bash
kubectl apply -f deploy-kubectl-task.yaml
kubectl apply -f java-spring-pipeline.yaml
```

