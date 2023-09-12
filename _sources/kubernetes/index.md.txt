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
