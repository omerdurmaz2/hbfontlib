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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFiles("consumer-rules.pro")
        }
    }
}

dependencies {
    implementation (libs.kotlin.stdlib)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components.findByName("release")) // "release" bileşenini kullanır
            groupId = "com.devomer" // GitHub kullanıcı adınızı ekleyin
            artifactId = "hbfontlib" // Projenizin adı
            version = "1.1.4" // Yayınladığınız versiyon
        }
    }
}
