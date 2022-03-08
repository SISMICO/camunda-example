import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "br.com.sismico"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

var camundaVersion = "7.16.0"
var camundaSpinVersion = "1.14.0"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.camunda.bpm:camunda-bom:$camundaVersion")
	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest:$camundaVersion")
	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:$camundaVersion")
	implementation("org.camunda.bpm:camunda-engine-plugin-spin:$camundaVersion")
	implementation("org.camunda.spin:camunda-spin-dataformat-all:$camundaSpinVersion")
	implementation("org.camunda.bpm:camunda-engine-rest:$camundaVersion")
	implementation("org.camunda.bpm:camunda-engine-rest:$camundaVersion")

	implementation("com.h2database:h2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
