.DEFAULT_GOAL := help
SHELL := bash

export MACHINE ?= jetson-nano-devkit
export DISTRO ?= tegrademo-mender
export IMAGE ?= demo-image-base
export SD_CARD_SIZE ?= 64G
export DATA_PART_SIZE_MB ?= 40960

TEGRAFLASH_ARGS := -m $(MACHINE) -i $(IMAGE)

define USAGE
Usage: make [TARGET] [ARG ...]

Targets:
    build               Build the default image ($(IMAGE))
    configure           Create the initial build directory with the (overridable)
                        options shown below:
                            MACHINE=$(MACHINE)
                            DISTRO=$(DISTRO)
                            SD_CARD_SIZE=$(SD_CARD_SIZE)
                            DATA_PART_SIZE_MB=$(DATA_PART_SIZE_MB)
    deploy              Deploy and install a Mender update to the target device
    help                (Default) Print usage information and exit
    tegraflash-extract  Extract the tegraflash archive from the latest build
    tegraflash-sdcard   Flash an SD card with the latest build
                        Args:
                            D=...   Path to the device to be flashed
endef
export USAGE

.PHONY: build
build:
	. setup-env && bitbake $(IMAGE)

.PHONY: configure
configure:
	bin/configure-build

.PHONY: deploy
deploy:
	bin/deploy

.PHONY: help
help:
	@echo "$$USAGE"

.PHONY: tegraflash-extract
tegraflash-extract:
	bin/tegraflash $(TEGRAFLASH_ARGS) extract

.PHONY: tegraflash-sdcard
tegraflash-sdcard:
	bin/tegraflash $(TEGRAFLASH_ARGS) -d $(D) sdcard
