load("@rules_java//java:defs.bzl", "java_binary", "java_library")

package(default_visibility = [":employee_management_package"])

package_group(
    name = "employee_management_package",
    packages = [
        "//java/com/tedsilb/employeemanagement/...",
        "//javatests/com/tedsilb/employeemanagement/...",
    ],
)

java_binary(
    name = "employeemanagement",
    srcs = ["Main.java"],
    main_class = "com.tedsilb.employeemanagement.Main",
    runtime_deps = ["//third_party:flogger_runtime"],
    deps = [
        ":DatastoreUtil",
        "//java/com/tedsilb/employeemanagement/proto:employee_java_proto",
        "//third_party:flogger",
        "//third_party:google_auth",
        "//third_party:google_cloud_datastore",
        "//third_party:guava",
        "//third_party:protobuf",
    ],
)

java_library(
    name = "DatastoreUtil",
    srcs = ["DatastoreUtil.java"],
    deps = [
        ":ResourceNameUtil",
        ":StringUtil",
        "//java/com/tedsilb/employeemanagement/proto:employee_java_proto",
        "//third_party:google_auth",
        "//third_party:google_cloud_datastore",
        "//third_party:guava",
        "//third_party:protobuf",
    ],
)

java_library(
    name = "ResourceNameUtil",
    srcs = ["ResourceNameUtil.java"],
)

java_library(
    name = "StringUtil",
    srcs = ["StringUtil.java"],
)
