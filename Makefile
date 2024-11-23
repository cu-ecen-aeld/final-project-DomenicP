.DEFAULT_GOAL := help
SHELL := bash

MACHINE ?= jetson-nano-devkit
DISTRO ?= tegrademo-mender
IMAGE ?= demo-image-base

define USAGE
Usage: make [TARGET]

Targets:

  build      Build the default image ($I(IMAGE))
  configure  Create the initial build directory
             Default options:
               MACHINE=$(MACHINE)
               DISTRO=$(DISTRO)
  help       (Default) Print usage information and exit
endef
export USAGE

.PHONY: build
build:
	. setup-env && bitbake $(IMAGE)

.PHONY: configure
configure:
	. setup-env --machine $(MACHINE) --distro $(DISTRO)


.PHONY: help
help:
	@echo "$$USAGE"
