# Hands on Knative

## Serving helloworld-go

`kubectl apply --filename helloworld-go/helloworld-go.yaml`

### Created CRDS

- service: runtime parameter, domain name , latest and ready revisions, traffic percent of usage of revision
- revision: runtime parameter for the pod, imageDigest, logUrl
- image
- route: traffic configuration, domain name

### Created K8s resources

- service type external name
- service type ClusterIP, selector to revision
- endpoint to the service
- deployment with containers

  - user-container: revision image
  - queue-proxy:

- service knative-ingress-gateway type Loadbalancer

### Find the endpoint:

`curl -H "Host: <domain name>" http://<externalIP from knative-ingress-gateway`

curl -H "Host: helloworld-go.default.example.com" http://35.195.246.230

## Build and Deploy a springapp

### Use the kaniko build template

`kubectl apply --filename kaniko.yaml`

### secret for image registry [dockerhub](https://id.docker.com/login)

`kubectl apply --filename dockerhub_secret.yaml`

### service account for build refers to dockerhub secret

`kubectl apply --filename build_serviceaccount.yaml`

### create service "springapp" from this repo

`kubectl apply --filename springapp_service.yaml`

### call the service

Find the external ip in service `knative-ingressgateway`
example for `35.233.38.14`:
curl -H "Host: springapp.default.example.com" http://35.233.38.14/messageapp