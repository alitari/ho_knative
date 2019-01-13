# Knative in Docker for desktop

## install istio

```bash
kubectl apply --filename istio-crds.yaml
kubectl apply --filename istio.yaml
```

## install knative

```bash
kubectl apply --filename serving.yaml
kubectl apply --filename release.yaml
```

## enable istio for namespace "default"

`kubectl label namespace default istio-injection=enabled`

## check

```bash
# install helloworld service
cd ../helloworld-go
kubectl apply --filename helloworld-go.yaml
curl -H "Host: helloworld-go.default.example.com" http://localhost
```
