load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# This isn't used, but for some reason the build fails if this isn't loaded

http_archive(
    name = "rules_python",
    sha256 = "a30abdfc7126d497a7698c29c46ea9901c6392d6ed315171a6df5ce433aa4502",
    strip_prefix = "rules_python-0.6.0",
    url = "https://github.com/bazelbuild/rules_python/archive/0.6.0.tar.gz",
)

# Maven deps

RULES_JVM_EXTERNAL_TAG = "4.2"

RULES_JVM_EXTERNAL_SHA = "cd1a77b7b02e8e008439ca76fd34f5b07aecb8c752961f9640dea15e9e5ba1ca"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

maven_install(
    artifacts = [
        maven.artifact(
            group = "com.google.auth",
            artifact = "google-auth-library-oauth2-http",
            version = "1.5.3",
        ),
        maven.artifact(
            group = "com.google.cloud",
            artifact = "google-cloud-datastore",
            version = "2.2.4",
        ),
        maven.artifact(
            group = "com.google.flogger",
            artifact = "flogger",
            version = "0.7.4",
        ),
        maven.artifact(
            group = "com.google.flogger",
            artifact = "flogger-system-backend",
            version = "0.7.4",
        ),
        maven.artifact(
            group = "com.google.guava",
            artifact = "guava",
            version = "31.0.1-jre",
        ),
        maven.artifact(
            group = "com.google.protobuf",
            artifact = "protobuf-java",
            version = "3.19.4",
        ),
        maven.artifact(
            group = "com.google.truth",
            artifact = "truth",
            version = "1.1.3",
        ),
        maven.artifact(
            group = "junit",
            artifact = "junit",
            version = "4.13.2",
        ),
        maven.artifact(
            group = "org.mockito",
            artifact = "mockito-core",
            version = "4.3.1",
        ),
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
        "https://jcenter.bintray.com/",
    ],
)

# Protobuf rules

http_archive(
    name = "rules_proto",
    sha256 = "66bfdf8782796239d3875d37e7de19b1d94301e8972b3cbd2446b332429b4df1",
    strip_prefix = "rules_proto-4.0.0",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_proto/archive/refs/tags/4.0.0.tar.gz",
        "https://github.com/bazelbuild/rules_proto/archive/refs/tags/4.0.0.tar.gz",
    ],
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()
