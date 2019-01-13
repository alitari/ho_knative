# Routing

## create configurations

- blue: `kubectl apply -f blue_configuration.yaml`
- green: `kubectl apply -f green_configuration.yaml`

## create routes

- 100% on rev1: `kubectl apply -f hundertOn1_route.yaml`

## check

`curl -H "Host: blue-green-demo.default.example.com" http://35.233.38.14`
