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

maven_install(
    artifacts = [
        #"com.google.cloud:libraries-bom:3.0.0",
        #"com.google.oauth-client:google-oauth-client:1.30.4",
        "com.google.cloud:google-cloud-datastore:1.105.0",
        "com.google.guava:guava:29.0-jre",
        "com.google.protobuf:protobuf-java:3.12.2",
        "org.junit.jupiter:junit-jupiter:5.6.0",
        "com.google.flogger:flogger:0.5.1",
        "com.google.flogger:flogger-system-backend:0.5.1",
        "org.mockito:mockito-core:3.3.0",
        "com.google.auth:google-auth-library-oauth2-http:0.21.1",
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
