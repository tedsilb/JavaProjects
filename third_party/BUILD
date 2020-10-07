load("@rules_java//java:defs.bzl", "java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "flogger",
    runtime_deps = [
        "@maven//:com_google_flogger_flogger",
        "@maven//:com_google_flogger_flogger_system_backend",
    ],
)

alias(
    name = "google_auth",
    actual = "@maven//:com_google_auth_google_auth_library_oauth2_http",
)

alias(
    name = "google_cloud_datastore",
    actual = "@maven//:com_google_cloud_google_cloud_datastore",
)

alias(
    name = "guava",
    actual = "@maven//:com_google_guava_guava",
)

alias(
    name = "junit_jupiter",
    actual = "@maven//:org_junit_jupiter_junit_jupiter",
)

alias(
    name = "mockito",
    actual = "@maven//:org_mockito_mockito_core",
)
