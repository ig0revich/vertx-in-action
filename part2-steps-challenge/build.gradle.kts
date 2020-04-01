plugins {
  id("com.github.ben-manes.versions") version "0.28.0"
  id("com.github.johnrengelman.shadow") version "5.2.0" apply false
  id("com.adarshr.test-logger") version "2.0.0" apply false
}

subprojects {

  repositories {
//    mavenLocal {
//      content {
//        includeGroup("io.vertx")
//      }
//    }
    mavenCentral()
    maven {
      url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
  }

  project.project.extra["vertxVersion"] = "4.0.0-SNAPSHOT"
  project.project.extra["junit5Version"] = "5.6.1"
  project.project.extra["restAssuredVersion"] = "4.3.0"
  project.project.extra["logbackClassicVersion"] = "1.2.3"
  project.project.extra["assertjVersion"] = "3.15.0"
  project.project.extra["testContainersVersion"] = "1.13.0"

  apply(plugin = "java")
  apply(plugin = "application")
  apply(plugin = "com.github.johnrengelman.shadow")
  apply(plugin = "com.adarshr.test-logger")

  tasks.withType<JavaCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
  }
}

tasks.wrapper {
  distributionType = Wrapper.DistributionType.ALL
  gradleVersion = "6.3"
}
