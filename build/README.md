# Build and Deploy a springapp

## Use the kaniko build template

`kubectl apply --filename kaniko.yaml`

## secret for image registry [dockerhub](https://id.docker.com/login)

`kubectl apply --filename dockerhub_secret.yaml`

## service account for build refers to dockerhub secret

`kubectl apply --filename build_serviceaccount.yaml`

## create service "springapp" from this repo

`kubectl apply --filename springapp_service.yaml`

## call the service

Find the external ip in service `knative-ingressgateway`
`curl -H "Host: springapp.default.example.com" http://localhost/springapp/form`

### trigger a new build

???
