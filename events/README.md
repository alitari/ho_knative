# events

## install eventing

`kubectl apply --filename eventing.yaml`
`kubectl apply --filename in-memory-channel.yaml`
`kubectl apply --filename eventing-sources.yaml`

## create channel

`kubectl -n default apply -f channel.yaml`

## create rbac

`kubectl -n default apply -f sa-roles.yaml`

## create k8s event source

`kubectl -n default apply -f k8s-event-source.yaml`

## create subscriber

`kubectl -n default apply -f subscriber.yaml`

## produce k8s events
