


# EG Web Server: Application


## How
```Bash
source etc/config
```

### Compile and Test
```Bash
mvn clean verify
```

### Maven Start Serving
```Bash
xt mvn spring-boot:run
```

### Browse
```Bash
http GET localhost:8080
```

### Maven Stop Serving
```Bash
psef xterm.+mvn.spring.boot.run --kill
```

### Java Start Serving
```Bash
xt java -jar target/eg-web-server-0.1.4.jar
```

### Browse
```Bash
http GET localhost:8080/hostname Request-Id:4711
```

### Java Stop Serving
```Bash
psef xterm.+java..jar.target.eg.web.server.0.1.4.jar --kill
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
