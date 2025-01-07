plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "com.omerd.hbfonts"
    compileSdk = 35

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components.findByName("release")) // "release" bileşenini kullanır
            groupId = "com.devomer" // GitHub kullanıcı adınızı ekleyin
            artifactId = "hbfontlib" // Projenizin adı
            version = "1.0.0" // Yayınladığınız versiyon
        }
    }
}
