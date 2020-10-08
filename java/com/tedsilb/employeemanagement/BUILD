load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "DatastoreUtil",
    srcs = ["DatastoreUtil.java"],
    deps = [
        ":StringUtil",
        "//java/com/tedsilb/employeemanagement/proto:employee_java_proto",
        "//third_party:google_auth",
        "//third_party:google_cloud_datastore",
        "//third_party:guava",
        "//third_party:protobuf",
    ],
)

java_library(
    name = "IOUtil",
    srcs = ["IOUtil.java"],
    deps = [
        "//third_party:google_auth",
    ],
)

java_binary(
    name = "Main",
    srcs = ["Main.java"],
    main_class = "com.tedsilb.employeemanagement.Main",
    runtime_deps = ["//third_party:flogger_runtime"],
    deps = [
        ":DatastoreUtil",
        ":IOUtil",
        "//java/com/tedsilb/employeemanagement/proto:employee_java_proto",
        "//third_party:flogger",
        "//third_party:google_auth",
        "//third_party:google_cloud_datastore",
        "//third_party:protobuf",
    ],
)

java_library(
    name = "StringUtil",
    srcs = ["StringUtil.java"],
)
