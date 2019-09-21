# Tektron pipelines 

![Tektron pipelines](https://tekton.dev/img/logos/tekton-horizontal-color.png)

## install

```bash
kubectl apply --filename https://storage.googleapis.com/tekton-releases/latest/release.yaml
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
