


# [EG Web Server](../README.md): Kluster


## How

### Set-Up
```bash
clear
source etc/module
source etc/config
```

### First: Blue Service
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

### Second: Cyan Service
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

### Third: Green Service
```bash
helm upgrade wss src/service --values=src/values.yaml --values=src/green.yaml
```
```bash
loader-load-test 7070 hostname 100
```
```bash
loader-check-log
```

### Fourth: Cyan Service
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

### Fifth: Blue Service
```bash
helm upgrade wss src/service --values=src/values.yaml --values=src/blue.yaml
```
```bash
loader-load-test 7070 hostname 100
```
```bash
loader-check-log
```

### Tear-Down
```bash
helm uninstall wss
helm uninstall blue
helm uninstall green
```
```bash
monitor_stop
tunnel_stop
```
```bash
minikube_stop
docker_stop
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
            Pod1[Blue1]
        end
    end
```

### Blue Service
```mermaid
graph TD
    Loader
    Loader --- WSS
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
    Loader
    Loader --- WSS
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
    Loader
    Loader --- WSS
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
