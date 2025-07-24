
# 🩺 Estudo de Liveness Probe com falha simulada – Cascão no Kubernetes

Este projeto simula um cenário onde a `livenessProbe` falha de propósito para observar o comportamento de auto-recuperação do Kubernetes. O personagem Cascão representa um container que escorrega (falha) repetidamente, sendo reiniciado automaticamente.

---

## 🎯 Objetivo

- Criar um Deployment com o container do Cascão (busybox)
- Simular falha de liveness probe usando um comando inválido
- Verificar reinicialização automática via `kubectl describe` e `kubectl logs`

---

## 📁 Arquivo: `cascao-liveness-falha.yaml`

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: cascao-falha
  labels:
    app: cascao-falha
spec:
  replicas: 1
  selector:
    matchLabels:
      app: cascao-falha
  template:
    metadata:
      labels:
        app: cascao-falha
    spec:
      containers:
        - name: cascao
          image: busybox
          args:
            - /bin/sh
            - -c
            - |
              echo "Cascão tentando não escorregar..."; while true; do echo "Tudo limpo"; sleep 10; done
          livenessProbe:
            exec:
              command:
                - cat
                - /arquivo/inexistente
            initialDelaySeconds: 5
            periodSeconds: 5
```

---

## 🧪 Aplicação

```bash
kubectl apply -f cascao-liveness-falha.yaml
```

---

## 🔎 Inspeção com `kubectl describe`

```bash
kubectl get pods
kubectl describe pod <nome-do-pod>
```

Você verá eventos como:

```
Warning  Unhealthy  Liveness probe failed: cat: can't open '/arquivo/inexistente': No such file or directory
Normal   Killing    Container cascao failed liveness probe, will be restarted
```

---

## 📊 O que foi aprendido

| Conceito           | Aprendizado                                       |
|--------------------|---------------------------------------------------|
| `livenessProbe`    | Permite ao Kubernetes verificar se o container está vivo |
| Reinício automático| O Kubernetes mata e reinicia containers doentes   |
| `kubectl describe` | Mostra status detalhado e eventos do ciclo de vida do Pod |

---

## ✅ Resultado esperado

- Container do Cascão reiniciando continuamente
- `Restart Count` > 0
- Logs indicando falhas de liveness

---

## ✨ Próximos passos sugeridos

- Testar `readinessProbe` com delay e falha temporária
- Usar `httpGet` ou `tcpSocket` como método de probe
- Criar um serviço e expor a aplicação do Cascão com Ingress