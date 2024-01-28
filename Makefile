#Commands
SHELL = /bin/sh
DOCKER = docker
DOCKER_COMPOSE = docker-compose
DOCKER_RMI = docker rmi
DOCKER_RM = docker rm
CLEAN = clean
GRADLE = gradle
BUILD = BUILD

#Files used
DOCKER_COMPOSE_FILE = compose.yml

.PHONY: build

build:	
	make clean
	$(DOCKER_COMPOSE) -f ${DOCKER_COMPOSE_FILE} up -d --build
	@echo "Container build Setup Complete. You may now execute 'docker ps' to see if things are up"
	$(DOCKER) ps
up:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) unpause
	$(DOCKER) ps

down:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) pause

clean:
	@echo "Remove orphan containers"
	-$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) down --remove-orphans