# Java Projects

[![CI](https://github.com/tedsilb/JavaProjects/actions/workflows/main.yml/badge.svg)](https://github.com/tedsilb/JavaProjects/actions/workflows/main.yml)

[![CodeFactor](https://www.codefactor.io/repository/github/tedsilb/javaprojects/badge)](https://www.codefactor.io/repository/github/tedsilb/javaprojects)

Various Java projects that I work on from time to time.

## Building

Projects are built using [Bazel](https://bazel.build).

- To build all projects:
  - `bazel build java/...`
- To run a specific project:
  - `bazel run java/com/tedsilb/{project} {args}`
- For example:
  - `bazel run java/com/tedsilb/employeemanagement`
