plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
    alias(libs.plugins.kotlin.android)
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

tasks.register<Jar>("classesJar") {
    archiveClassifier.set("classes")
    from(android.sourceSets["main"].java.srcDirs)
}
publishing {
    publications {
        create<MavenPublication>("release") {
            from(components.findByName("release")) // "release" bileşenini kullanır
            artifact(tasks.named("sourcesJar").get()) // Kaynak kodlarını ekleyin
            artifact(tasks.named("classesJar").get()) // Sınıfları ekleyin
            groupId = "com.devomer" // GitHub kullanıcı adınızı ekleyin
            artifactId = "hbfontlib" // Projenizin adı
            version = "1.1.4" // Yayınladığınız versiyon
        }
    }
}