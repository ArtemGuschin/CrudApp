plugins {
    id("java")
}

group = "net.artem.crudapp"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.11.0")


}
dependencies {
    compileOnly ("org.projectlombok:lombok:1.18.34")
    annotationProcessor ("org.projectlombok:lombok:1.18.34")


}

tasks.test {
    useJUnitPlatform()
}

