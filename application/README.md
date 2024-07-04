


# [EG Web Server](../README.md): Application


## How

### Set Up
```Bash
source etc/config
```
```Bash
mvn clean verify
```
```Bash
xt java -jar target/web-server-application-0.2.0.jar --colour=magenta
```

### Verify
```Bash
http GET localhost:8080
http GET localhost:8080/hostname Request-Id:4711
```
```Bash
loader-get-local 8080 hostname 3435
```
```Bash
loader-load-test 8080 hostname
```
```Bash
loader-check-log
```

### Tear Down
```Bash
psef java..jar.target.web.server.application.0.2.0.jar --kill
```

## What
```mermaid
graph TD
    User --- AP
    subgraph Application [Application: WSA]
        AP[Application Port: 8080]
    end
```

### End Points
| Protocol | Method | End Point | Req Head    | Req Body | Res Head | Res Body           |
|----------|--------|-----------|-------------|----------|----------|--------------------|
| HTTP     | GET    | /         | -           | -        | -        | `EndPointList`     |
| HTTP     | GET    | /hostname | `RequestId` | -        | -        | `HostNameResponse` |

### Types

    RequestId = String;
    EndPointList = [String];
    HostNameResponse = {colour: String, hostname: String, requestId: String}.

*2023-12-02*
