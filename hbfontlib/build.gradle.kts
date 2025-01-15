plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.devomer.hbfontlib"
    compileSdk = 35

    defaultConfig{
        minSdk = 25
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            consumerProguardFiles("consumer-rules.pro")
        }
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java", "src/main/kotlin")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation (libs.kotlin.stdlib)
    implementation(libs.androidx.core.ktx)
}

tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(android.sourceSets["main"].java.srcDirs)
}

/*tasks.register<Jar>("classesJar") {
    archiveClassifier.set("classes")
    from(android.sourceSets["main"].java.srcDirs)
}*/


publishing {
    publications {
        create<MavenPublication>("release") {
            from(components.findByName("release"))
            artifact("$buildDir/outputs/aar/hbfontlib-release.aar") // AAR dosyasını manuel ekle
            artifact(tasks.named("sourcesJar").get())
            groupId = "com.devomer"
            artifactId = "hbfontlib"
            version = "1.1.8"
        }
    }
}

tasks.named("publishReleasePublicationToMavenLocal") {
    dependsOn("bundleReleaseAar") // AAR dosyasının oluşturulmasını garanti eder
}