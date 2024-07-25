# AWS-Deploy


## AWS CLI - Conecatar remoto em uma instancia EC2 na AWS. 

### DockeFile

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

### DockerCompose 

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
