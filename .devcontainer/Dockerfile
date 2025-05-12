# Use uma imagem base com Java 17
FROM mcr.microsoft.com/devcontainers/java:17

# Instale o Docker
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    docker.io && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Configure o usuário padrão
USER vscode