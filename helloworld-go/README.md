# Serving helloworld-go

`kubectl apply --filename helloworld-go.yaml`

## Created CRDS

- service: runtime parameter, domain name , latest and ready revisions, traffic percent of usage of revision
- revision: runtime parameter for the pod, imageDigest, logUrl
- image
- route: traffic configuration, domain name

## Created K8s resources

- service type external name
- service type ClusterIP, selector to revision
- endpoint to the service
- deployment with containers

  - user-container: revision image
  - queue-proxy:

- service knative-ingress-gateway type Loadbalancer

## Find the endpoint

`curl -H "Host: <domain name>" http://<externalIP from knative-ingress-gateway`

Example: `curl -H "Host: helloworld-go.default.example.com" http://35.195.246.230`
