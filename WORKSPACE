load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# Maven deps

RULES_JVM_EXTERNAL_TAG = "3.3"

RULES_JVM_EXTERNAL_SHA = "d85951a92c0908c80bd8551002d66cb23c3434409c814179c0ff026b53544dab"

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
            version = "0.22.0",
        ),
        maven.artifact(
            group = "com.google.cloud",
            artifact = "google-cloud-datastore",
            version = "1.105.2",
        ),
        maven.artifact(
            group = "com.google.flogger",
            artifact = "flogger",
            version = "0.5.1",
        ),
        maven.artifact(
            group = "com.google.flogger",
            artifact = "flogger-system-backend",
            version = "0.5.1",
        ),
        maven.artifact(
            group = "com.google.guava",
            artifact = "guava",
            version = "30.0-jre",
        ),
        maven.artifact(
            group = "com.google.protobuf",
            artifact = "protobuf-java",
            version = "3.14.0",
        ),
        maven.artifact(
            group = "com.google.truth",
            artifact = "truth",
            version = "1.1",
        ),
        maven.artifact(
            group = "junit",
            artifact = "junit",
            version = "4.13.1",
        ),
        maven.artifact(
            group = "org.mockito",
            artifact = "mockito-core",
            version = "3.6.28",
        ),
    ],
    repositories = [
        "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)

# Protobuf rules

http_archive(
    name = "rules_proto",
    sha256 = "602e7161d9195e50246177e7c55b2f39950a9cf7366f74ed5f22fd45750cd208",
    strip_prefix = "rules_proto-97d8af4dc474595af3900dd85cb3a29ad28cc313",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
        "https://github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
    ],
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()
