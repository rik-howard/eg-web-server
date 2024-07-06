


# [EG Web Server](../README.md): Script


## `bin`
Provides some unrelated scripts as some presentation aids.
```bash
clear
export PATH=.:bin:/usr/local/bin:/usr/bin:/bin
```

### `how`
Displays the block comment of the given script or of itself, if no script is given.  The block comment is assumed to indicate how the script is to be used.
```bash
clear
how
how how
```

### `map`
Applies a function to a stream.
```bash
clear
how map
echo -e '..\n.' | map readlink -f
echo -e '..\n.' | map ls -a -l
```

### `psef`
Returns the process table entries of the processes whose entries match the given regex or of all entries, if no regex is given.  The pids or commands can be accessed or the processes can be killed.
```bash
clear
how psef
psef chrome.crashpad.handler...no
psef chrome.crashpad.handler --pid
```

### `wiv`
Returns the version of the given program, if the program can be found, or a not-found message, otherwise.
```bash
clear
how wiv
wiv unknown
wiv docker
wiv xterm
```

### `xt`
Spawns a new XTerm session in which to run the given command.
```bash
clear
how xt
xt bash
```
```bash
psef xterm.+bash
```
```bash
psef xterm.+bash --kill
```
Optionally, the command can be preceded by a +-sign, which runs the command in a while-loop, advancing as the user presses the enter key, optionally entering a regular expression for high lighting.
```bash
export i=11
xt + 'hot $i; i=$((i+1))'
```
```bash
psef xterm --cmd | egrep -o export.+
```
```bash
psef xterm --kill
```


## `etc/engine`
Provides start, stop and status commands for Docker and Minikube.
```bash
clear
export PATH=.:bin:/usr/local/bin:/usr/bin:/bin
export H=32 W=142
source etc/engine
```

### Showing
```bash
xt + 'show_docker | heat'
xt + 'show_kubernetes | heat'
```

### Setting Up
```bash
start_docker
```
```bash
start_minikube
```
```bash
H=8 W=142
start_tunnel
```

### Tearing Down
Tunnel
```bash
stop_tunnel
```
Minikube
```bash
helm uninstall wss
```
```bash
helm uninstall blue
```
```bash
helm uninstall green
```
```bash
docker container stop wsc
```
```bash
stop_minikube  # docker container stop minikube
```
Docker
```bash
docker container remove wsc
```
```bash
docker container remove minikube
```
```bash
docker network remove minikube
```
```bash
docker volume remove minikube
```
```bash
docker image list | egrep web.server.container | xargs | cut -d' ' -f1-2 | tr ' ' ':' | map docker image remove
```
```bash
docker image list | egrep minikube | xargs | cut -d' ' -f1-2 | tr ' ' ':' | map docker image remove
```
```bash
docker image prune --force
```
```bash
docker system prune --force
```
```bash
stop_docker
```

*2024-07-01*
