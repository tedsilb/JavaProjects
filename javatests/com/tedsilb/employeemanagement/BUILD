load("@rules_java//java:defs.bzl", "java_library", "java_test")

java_library(
    name = "MainTest",
    srcs = ["MainTest.java"],
    deps = [
        "//java/com/tedsilb/employeemanagement:Main",
        "//third_party/mockito",
        "//third_party/junit_jupiter",
    ],
)

java_test(
    name = "AllTests",
    size = "small",
    runtime_deps = [
        ":MainTest",
    ],
)
