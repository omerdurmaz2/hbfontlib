plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "com.devomer.hbfontlib"
    compileSdk = 35

    defaultConfig{
        minSdk = 26
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
}

dependencies {
    implementation (libs.kotlin.stdlib)
}

tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(android.sourceSets["main"].java.srcDirs)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components.findByName("release")) // "release" bileşenini kullanır
            artifact(tasks.named("sourcesJar").get()) // Kaynak kodlarını ekleyin
            groupId = "com.devomer" // GitHub kullanıcı adınızı ekleyin
            artifactId = "hbfontlib" // Projenizin adı
            version = "1.1.4" // Yayınladığınız versiyon
        }
    }
}