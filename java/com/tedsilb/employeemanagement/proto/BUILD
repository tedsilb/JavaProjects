load("@rules_java//java:defs.bzl", "java_proto_library")
load("@rules_proto//proto:defs.bzl", "proto_library")

proto_library(
    name = "employee_proto",
    srcs = ["employee.proto"],
)

java_proto_library(
    name = "employee_java_proto",
    visibility = ["//java/com/tedsilb/employeemanagement:employee_management_package"],
    deps = [":employee_proto"],
)
