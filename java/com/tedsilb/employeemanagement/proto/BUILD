load("@rules_java//java:defs.bzl", "java_proto_library")
load("@rules_proto//proto:defs.bzl", "proto_library")

proto_library(
    name = "employee_proto",
    srcs = ["employee.proto"],
)

java_proto_library(
    name = "employee_java_proto",
    visibility = ["//:__subpackages__"],
    deps = [":employee_proto"],
)
