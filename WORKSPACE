load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# This isn't used, but for some reason the build fails if this isn't loaded

http_archive(
    name = "rules_python",
    sha256 = "934c9ceb552e84577b0faf1e5a2f0450314985b4d8712b2b70717dc679fdc01b",
    url = "https://github.com/bazelbuild/rules_python/releases/download/0.3.0/rules_python-0.3.0.tar.gz",
)

# Maven deps

RULES_JVM_EXTERNAL_TAG = "4.0"

RULES_JVM_EXTERNAL_SHA = "31701ad93dbfe544d597dbe62c9a1fdd76d81d8a9150c2bf1ecf928ecdf97169"

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
            version = "0.27.0",
        ),
        maven.artifact(
            group = "com.google.cloud",
            artifact = "google-cloud-datastore",
            version = "1.107.1",
        ),
        maven.artifact(
            group = "com.google.flogger",
            artifact = "flogger",
            version = "0.6",
        ),
        maven.artifact(
            group = "com.google.flogger",
            artifact = "flogger-system-backend",
            version = "0.6",
        ),
        maven.artifact(
            group = "com.google.guava",
            artifact = "guava",
            version = "30.1.1-jre",
        ),
        maven.artifact(
            group = "com.google.protobuf",
            artifact = "protobuf-java",
            version = "3.17.3",
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
            version = "3.11.2",
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
