# Routing

## create configurations

Create a blue-green configuration and update this configuration, so that we have 2 revisions of `blue-green-demo`.

- blue: `kubectl apply -f blue_configuration.yaml`
- green: `kubectl apply -f green_configuration.yaml`

## create routes

check the routed app with: `curl -H "Host: blue-green-demo.default.example.com" http://localhost`

### 100% on rev1

- create route: `kubectl apply -f hundertOn1_route.yaml`
- check

### 100% on rev2

- create route: `kubectl apply -f hundertOn2_route.yaml`
- check

### 50-50% on both revisions

- create route: `kubectl apply -f fifty_fifty_route.yaml`
- check
