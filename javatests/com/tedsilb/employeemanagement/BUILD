load("@rules_java//java:defs.bzl", "java_test")

java_test(
    name = "MainTest",
    size = "small",
    srcs = ["MainTest.java"],
    main_class = "com.tedsilb.employeemanagement.Main",
    runtime_deps = ["//third_party:flogger_runtime"],
    deps = [
        "//java/com/tedsilb/employeemanagement",
        "//java/com/tedsilb/employeemanagement:DatastoreUtil",
        "//java/com/tedsilb/employeemanagement:IOUtil",
        "//java/com/tedsilb/employeemanagement/proto:employee_java_proto",
        "//third_party:flogger",
        "//third_party:google_auth",
        "//third_party:google_cloud_datastore",
        "//third_party:junit",
        "//third_party:protobuf",
        "//third_party:truth",
    ],
)
