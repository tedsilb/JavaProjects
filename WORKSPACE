load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# Maven deps

RULES_JVM_EXTERNAL_TAG = "4.5"

RULES_JVM_EXTERNAL_SHA = "b17d7388feb9bfa7f2fa09031b32707df529f26c91ab9e5d909eb1676badd9a6"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/refs/tags/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

maven_install(
    artifacts = [
        maven.artifact(
            artifact = "google-auth-library-oauth2-http",
            group = "com.google.auth",
            version = "1.14.0",
        ),
        maven.artifact(
            artifact = "google-cloud-datastore",
            group = "com.google.cloud",
            version = "2.13.0",
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
            version = "3.21.12",
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
            version = "4.10.0",
        ),
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
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
