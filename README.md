# AWS-Deploy

## AWS CLI - Conecatar remoto em uma instancia EC2 na AWS. 

## DockeFile

```js
FROM ubuntu:22.04

RUN apt-get update \
  && apt-get install -y curl unzip

RUN curl https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip -o awscliv2.zip \
  && unzip awscliv2.zip \
  && ./aws/install \
  && rm -rf aws awscliv2.zip

RUN apt-get install -y iputils-ping \
  && apt-get install -y vim \
  && apt-get install -y openssh-server

VOLUME :/home/user/pasta1//AWS/volumes

CMD ["bash"]
```

## DockerCompose 

```js
version: '3.9'

services:
  custom_ubuntu:
    build: .
    volumes:
      - /home/user/pasta1/AWS/volumes:/home/user/pasta1//AWS/volumes
    stdin_open: true
    tty: true
    restart: unless-stopped
```

## CI/CD com AWS e Github Actions. 

### Serviços AWS
- IAM - usuários e permissões
- EC2 - Maquinas
- Elastic BeanStalk - camada de abstração sobre o EC2
- RDS - Banco de Dados
- S3 - Storage.

Pipeline ou esteira de deploy
Sequência automatizada de passos de implantação. pode implementar integração continua, entrega continua e deploy continuo. 

O que é CI/CD ? 
https://www.redhat.com/pt-br/topics/devops/what-is-ci-cd


