SHELL := /bin/bash
TARGET := $(firstword $(MAKECMDGOALS))
RUN_ARGS := $(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))
# not to handle RUN_ARGS as "make" tasks
$(eval $(RUN_ARGS):;@:)
RUN_ARGS_LEN := $(words $(RUN_ARGS))

BRANCH=$(shell git branch --show-current)
PLATFORM=$(word 2, $(subst /, , $(BRANCH)))
CONTEST_BRANCH=$(word 3, $(subst /, , $(BRANCH)))
CONTEST=$(subst _na,, $(CONTEST_BRANCH))
TASK_FILENAME=$(word 1, $(RUN_ARGS))
TASK=$(subst _x,, $(TASK_FILENAME))

PLATFORMS := atcoder codeforces

# task for checking global vars
check-vars:
	@echo SHELL: $(SHELL)
	@echo TARGET: $(TARGET)
	@echo RUN_ARGS: $(RUN_ARGS)
	@echo RUN_ARGS_LEN $(RUN_ARGS_LEN)
	@echo "=========="
	@echo BRANCH: $(BRANCH)
	@echo PLATFORM: $(PLATFORM)
	@echo CONTEST_BRANCH: $(CONTEST_BRANCH)
	@echo CONTEST: $(CONTEST)
	@echo TASK_FILENAME: $(TASK_FILENAME)
	@echo TASK: $(TASK)
	@echo "=========="

init: clean
ifneq ($(RUN_ARGS_LEN), 2)
	$(error [USAGE] make init <PLATFORM:$(PLATFORMS)> <CONTEST NAME>)
endif
	$(eval PLATFORM := $(word 1, $(RUN_ARGS)))
	$(eval CONTEST_BRANCH := $(word 2, $(RUN_ARGS)))
	@echo $(PLATFORM)
	@echo $(CONTEST_BRANCH)
	@if [ "$(filter $(PLATFORM),$(PLATFORMS))" != "$(PLATFORM)" ]; then \
	    echo "[ERROR] $(PLATFORM) is unknown platform ($(PLATFORMS)))"; \
	elif [ $(BRANCH) = "contest/$(PLATFORM)/$(CONTEST_BRANCH)" ]; then \
	    echo "[INFO] Already in contest/$(PLATFORM)/$(CONTEST_BRANCH) branch"; \
	    if [ ! -d $(PLATFORM)/src/main/kotlin/com/github/ked4ma/competitive/$(PLATFORM)/$(CONTEST_BRANCH) ]; then \
	        mkdir -p $(PLATFORM)/src/main/kotlin/com/github/ked4ma/competitive/$(PLATFORM)/$(CONTEST_BRANCH); \
	    fi \
	elif [ -d $(PLATFORM)/src/main/kotlin/com/github/ked4ma/competitive/$(PLATFORM)/$(CONTEST_BRANCH) ]; then \
	    echo "[INFO] $(CONTEST_BRANCH) is already finished."; \
	else \
	    echo "[Info] preparing for the $(PLATFORM) contest ($(CONTEST))"; \
	    # git stash; \
	    git switch -c contest/$(PLATFORM)/$(CONTEST_BRANCH); \
	    mkdir -p $(PLATFORM)/src/main/kotlin/com/github/ked4ma/competitive/$(PLATFORM)/$(CONTEST_BRANCH); \
	fi

run:
	@source ./secret-$(PLATFORM).conf && \
	    ./gradlew -Pcontest=$(CONTEST_BRANCH) cleanTest \
	        $(PLATFORM):test --tests "com.github.ked4ma.competitive.$(PLATFORM).TestRunner" -Dtask=$(TASK_FILENAME) -Dbranch=$(BRANCH)

format:
	@echo "TODO"

finish:
	@echo "[Info] Finish $(PLATFORM) $(CONTEST_BRANCH)"
	git commit -a -m "$(PLATFORM) $(CONTEST_BRANCH)"
	git switch main
	git merge --no-ff $(BRANCH)
	git branch -d $(BRANCH)
	git tag $(PLATFORM)/$(CONTEST_BRANCH)
	git push origin main --tags

clean:
	./gradlew clean

test:
	./gradlew common:test

.PHONY: clean init run format finish check-vars problems problems-format test
