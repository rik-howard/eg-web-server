


# [EG Web Server](../README.md): Container


## How
```bash
source etc/config
```

### Copy Jar
```bash
cp -pr ../application/target/web-server-application-*.jar src/tmp
```

### Build Image
```bash
APPLICATION_VERSION=$(basename $(ls src/tmp/web-server-application-*.jar) | cut -d- -f4 | cut -d. -f1-3)
docker build src --tag=rik911/web-server-container:0.2.1 --build-arg=VERSION=$APPLICATION_VERSION
```

### Run Container (Start Serving)
```bash
xt docker run --tty --name=wsc --publish=80:8080 rik911/web-server-container:0.2.1
```

### Load-Test End-Point
```Bash
loader-load-test 80 hostname
```

### Check Logging
```Bash
loader-check-log
```

### Stop Server
```bash
psef xterm.+web.server.container --kill
```

### Pushing
```Bash
#docker login --user=rik911
#docker push rik911/web-server-container:0.2.1
```

### Removing
```bash
docker container remove wsc --force
```
```bash
# docker image remove rik911/web-server-container:0.2.1  # just fyi
```


## What
```mermaid
graph TD
    User --- EP --- CP --- AP;
    subgraph E[Engine: Docker]
        EP[Engine Port: 80]
        subgraph C[Container: WSC]
            CP[Container Port: 8080]
            subgraph A[Application: WSA]
                AP[Application Port: 8080]
            end
        end
    end
```

*2023-12-02*
