# [minishift](https://github.com/redhat-developer-demos/knative-minishift)

- start

`minishift start --hyperv-virtual-switch Primary`

- login: `oc login -u admin -p admin`

- find out the ip adress
  IP_ADRESS is the `externalIP` of service `knative-ingress` in the `istio-system` namespace
- add a route to the minishift cluster with the `IP_ADRESS`: `route ADD ${IP_ADDRESS} MASK 255.255.255.255 $(minishift ip)`
- request the service: `curl -H "Host: helloworld-go.myproject.example.com" http://$IP_ADDRESS`
