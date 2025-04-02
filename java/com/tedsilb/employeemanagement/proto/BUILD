load("@com_google_protobuf//bazel:proto_library.bzl", "proto_library")
load("@com_google_protobuf//bazel:java_proto_library.bzl", "java_proto_library")

proto_library(
    name = "employee_proto",
    srcs = ["employee.proto"],
)

java_proto_library(
    name = "employee_java_proto",
    visibility = ["//java/com/tedsilb/employeemanagement:employee_management_package"],
    deps = [":employee_proto"],
)
