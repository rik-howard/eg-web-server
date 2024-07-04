


# [EG Web Server](../README.md): Script


## `bin`
Provides some unrelated scripts as some presentation aids.
```bash
clear
export PATH=.:bin:/bin
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
echo -e '..\n.' | map ls -l
```

### `psef`
Returns the process table descriptions of the processes whose descriptions match the given regex or all descriptions, if no regex is given.  The pid or commands can be accessed or the processes can be killed.
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
wiv xterm
wiv docker
wiv unknown
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
Optionally, the command can be preceded by a +-sign, which runs the command in a while-loop, advancing as the user presses the enter key.
```bash
export i=11
xt + 'echo $i; i=$((i+1))'
```
```bash
psef xterm.+echo..i..i....i.1.. --cmd
```
```bash
psef xterm.+echo..i..i....i.1.. --kill
```

*2024-07-01*


## `etc/engine`
Provides start, stop and status commands for Docker and Minikube.
```bash
clear
export PATH=.:bin:/usr/local/bin:/usr/bin:/bin
source etc/engine
```

### Showing
```bash
xt + show_docker
xt + show_kubernetes
```

### Starting
```bash
start_docker
```
```bash
start_minikube
```
```bash
start_tunnel
```

### Stopping
```bash
stop_tunnel
```
```bash
stop_minikube
```

### Tearing Down
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
