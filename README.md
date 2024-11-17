# Competitive

- Env (Tools) for Competitive Programing in Kotlin
    - AtCoder
    - Codeforces (*preparing*)
- This also has training module for ad-hoc practices

# Usage

In this repo, we use Makefile to run code.

## For competition

### Prepare

- You need to make `secret-<PLATFORM>.conf` to login when get problem examples during competitions.
    - e.g.) if you attend AtCoder competition, create `secret-atcoder.conf`
    - format is following
      ```
      export USER=<LOGIN_USER_ID>
      export PASSWORD=<LOGIN_PASSWORD>
      ```
    - NOTE: `secret-*.conf` is ignored my git, so it won't be commited/pushed.

### Init

```bash
make init <PLATFORM> <CONTEST_ID>
---
$ make init atcoder abc123
$ make init codeforces 123
```

Initialize for the contest.  

### Run

```bash
make run <TASK_FILENAME> [PLATFORM=<*> CONTEST_BRANCH=<*>]
---
$ make run A
# you can add suffix like "x" with "_" as a mark
# it can used to indicate that you didn't solve this in the competition
$ make run D_x
# you can specify tasks of other platforms/contests
$ make run E PLATFORM=atcoder CONTEST_BRANCH=abc123
$ make run E PLATFORM=codeforces CONTEST_BRANCH=123
```

### Format

```bash
make format <TASK_FILENAME> [PLATFORM=<*> CONTEST_BRANCH=<*>]
---
$ make format A
$ make format D_x
$ make format E PLATFORM=atcoder CONTEST_BRANCH=abc123
$ make format E PLATFORM=codeforces CONTEST_BRANCH=123
```

### Finish

```bash
make finish
```

Finish contest.  
This commit uncommited files and merge to `main` branch, and then push `main` and tags.

## For Practice

### Training

```bash
make training
```

### Format

```bash
make training-format
```