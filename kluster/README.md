


# [EG Web Server](../README.md): Kluster


## How

### Set-Up
```bash
source etc/config
```
```bash
xt + show_docker
```
```bash
xt + show_kubernetes
```
```bash
start_docker
```
```bash
start_minikube
```
```bash
start_tunnel
```

### First Service: Blue
Blue
```bash
helm install blue src/deployment --values=src/values.yaml --values=src/blue.yaml
```
```bash
helm install wss src/service --values=src/values.yaml --values=src/blue.yaml
```
```bash
loader-load-test 7070 hostname 100
```
```bash
loader-check-log
```

### Second Service: Green
Cyan
```bash
helm install green src/deployment --values=src/values.yaml --values=src/green.yaml
```
```bash
helm upgrade wss src/service --values=src/values.yaml --values=src/cyan.yaml
```
```bash
loader-load-test 7070 hostname 100
```
```bash
loader-check-log
```
Green
```bash
helm upgrade wss src/service --values=src/values.yaml --values=src/green.yaml
```
```bash
loader-load-test 7070 hostname 100
```
```bash
loader-check-log
```

### Third Service: Blue
Cyan
```bash
helm upgrade blue src/deployment --values=src/values.yaml --values=src/blue.yaml
```
```bash
helm upgrade wss src/service --values=src/values.yaml --values=src/cyan.yaml
```
```bash
loader-load-test 7070 hostname 100
```
```bash
loader-check-log
```
Blue
```bash
helm upgrade wss src/service --values=src/values.yaml --values=src/blue.yaml
```
```bash
loader-load-test 7070 hostname 100
```
```bash
loader-check-log
```

### Summary

    helm install deployment blue   #
    helm install service blue      # v0
    helm install deployment green  #
    helm upgrade service cyan      # v0 and v1
    helm upgrade service green     # v1
    helm upgrade deployment blue   #
    helm upgrade service cyan      # v1 and v2
    helm upgrade service blue      # v2
    helm upgrade deployment green  #
    ...

Try this later
```bash
xt + 'loader-load-test 7070 hostname 500; sleep 30; loader-check-log'
```
```bash
helm upgrade wss src/service --values=src/values.yaml --values=src/cyan.yaml
```

### Tear-Down
```bash
helm uninstall wss
helm uninstall blue
helm uninstall green
```
```bash
stop_tunnel
```
```bash
stop_minikube
```
```bash
stop_docker
```


## What

### Initial Service
```mermaid
graph TD
    User --- Service;
    Service --- Pod0;
    Service --- Pod1;
    subgraph Cluster [WSK]
        Service[WSS]
        subgraph Deployment [Blue]
            Pod0[Blue0]
            Pod1[BlueN]
        end
    end
```

### Blue Service
```mermaid
graph TD
    User
    User --- WSS
    subgraph WSK
        WSS
        WSS --- Blue0
        WSS --- BlueN
        WSS -.- Green0
        WSS -.- GreenN
        subgraph Blue
            Blue0
            BlueN
        end
        subgraph Green
            Green0
            GreenN
        end
    end
```

### Cyan Service
```mermaid
graph TD
    User
    User --- WSS
    subgraph WSK
        WSS
        WSS --- Blue0
        WSS --- BlueN
        WSS --- Green0
        WSS --- GreenN
        subgraph Blue
            Blue0
            BlueN
        end
        subgraph Green
            Green0
            GreenN
        end
    end
```

### Green Service
```mermaid
graph TD
    User
    User --- WSS
    subgraph WSK
        WSS
        WSS -.- Blue0
        WSS -.- BlueN
        WSS --- Green0
        WSS --- GreenN
        subgraph Blue
            Blue0
            BlueN
        end
        subgraph Green
            Green0
            GreenN
        end
    end
```

*2023-12-03*
