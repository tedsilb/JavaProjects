load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# This isn't used, but for some reason the build fails if this isn't loaded

http_archive(
    name = "rules_python",
    sha256 = "a3a6e99f497be089f81ec082882e40246bfd435f52f4e82f37e89449b04573f6",
    strip_prefix = "rules_python-0.10.2",
    url = "https://github.com/bazelbuild/rules_python/archive/refs/tags/0.10.2.tar.gz",
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
            artifact = "google-auth-library-oauth2-http",
            group = "com.google.auth",
            version = "1.8.1",
        ),
        maven.artifact(
            artifact = "google-cloud-datastore",
            group = "com.google.cloud",
            version = "2.10.1",
        ),
        maven.artifact(
            artifact = "flogger",
            group = "com.google.flogger",
            version = "0.7.4",
        ),
        maven.artifact(
            artifact = "flogger-system-backend",
            group = "com.google.flogger",
            version = "0.7.4",
        ),
        maven.artifact(
            artifact = "guava",
            group = "com.google.guava",
            version = "31.1-jre",
        ),
        maven.artifact(
            artifact = "protobuf-java",
            group = "com.google.protobuf",
            version = "3.21.4",
        ),
        maven.artifact(
            artifact = "truth",
            group = "com.google.truth",
            version = "1.1.3",
        ),
        maven.artifact(
            artifact = "junit",
            group = "junit",
            version = "4.13.2",
        ),
        maven.artifact(
            artifact = "mockito-core",
            group = "org.mockito",
            version = "4.6.1",
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
    sha256 = "e017528fd1c91c5a33f15493e3a398181a9e821a804eb7ff5acdd1d2d6c2b18d",
    strip_prefix = "rules_proto-4.0.0-3.20.0",
    urls = [
        "https://github.com/bazelbuild/rules_proto/archive/refs/tags/4.0.0-3.20.0.tar.gz",
    ],
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()
