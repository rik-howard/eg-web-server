


# [EG Web Server](../README.md): Kluster


## How
```bash
clear
source etc/module
source etc/config
```
```bash
helm install wsk src --set=serverPort=9090
```
```bash
loader-load-test 9090 hostname
```
```bash
loader-check-log
```
```bash
helm uninstall wsk
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
```mermaid
graph TD
    User --- WSNPort --- WSRPort --- WSCPort --- WSAPort;
    subgraph Cluster [Cluster: WSK]
        subgraph Service [Service: WSS]
            WSNPort[Node Port: 30080]
            WSRPort[Rear Port: 8080]
        end
        subgraph Pod [Pod: WSP]
            subgraph Container [Container: WSC]
                WSCPort[Container Port: 8080]
                subgraph Application[Application: WSA]
                    WSAPort[Application Port: 8080]
                end
            end
        end
    end
```

### Note
* `service.wss.spec.ports[0].targetPort` ~ Container Port
* `service.wss.spec.ports[0].port` ~ Rear Port
* `service.wss.spec.ports[0].nodePort` ~ Node Port (specifiable)
* `kubectl get service/wss --output=yaml | yq '.metadata.annotations."meta.helm.sh/release-name"'` = `wsk`
* `kubectl get pod/wsp --output=yaml | yq '.metadata.annotations."meta.helm.sh/release-name"'` = `wsk`

*2023-12-03*
