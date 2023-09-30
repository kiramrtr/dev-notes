# Kubernetes

## TODO

- [ ] `StatefulSet`

## Kubernetes Architecture

Control Plane

- api
- sched
- etcd
- c-m Control Manager
- c-c-m Cloud Control Manager (optional)

Node

- kubectl
- kproxy

## Draft

```
kubectl [command] [type] [name] [flags]

kubectl get pod app -o yaml
```

Objects can be created imperatively or declaratively.

Imperative approach

```
kubectl run nginx --image=nginx --restart=Never --port=80
```

Declarative approach

`nginx-pod.yaml`

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: frontend
spec:
  containers:
    - name: frontend
      image: nginx
      ports:
        - containerPort: 80
  restartPolicy: Never
```

```
kubectl create -f nginx-pod.yaml
```

- `create` command instantiates a new object, if executed for existing object will result in an error.
- `apply` command meant to update an existing object fully or incrementally. If object doesn't exist it behaves same as `create`.

## Tips for CKAD

```
kubectl config set-context <context> --namespace=<namespace>
```

##

### Load docker images to kind nodes

kind doesn't use local docker images and will try to fetch from the container registry. Local images can be loaded using:

```shell
kind load docker-image nginx --name kind-cluster-name
```

### Using kind behind proxy

As kind doesn't use local docker images

```shell
export http_proxy=http://...
export https_proxy=http://...

kind create cluster --config ...
```

### Using Git Bash on Windows

This stops Git Bash from altering file system paths.

```shell
export MSYS_NO_PATHCONV=1
```

[Ref](https://books.google.com/books?id=hHc5DwAAQBAJ&pg=PA196&lpg=PA196&dq=environment+variable+windows+MSYS_NO_PATHCONV&source=bl&ots=9AW2uHiBQ7&sig=ACfU3U1kwtYXN9LqmM5Cy2P_2W5zc9-bLw&hl=en&sa=X&ved=2ahUKEwiN-vG-gsLpAhUQo54KHVCCCaAQ6AEwBHoECAoQAQ#v=onepage&q&f=false)


