plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "com.devomer.hbfontlib"
    resourcePrefix ="hbfont_"
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

/*    sourceSets {
        main {
            resources.srcDirs += "src/main/res"
        }
    }*/
}

/*afterEvaluate {
    android.libraryVariants.forEach { variant ->
        publishing.publications.create(variant.name, MavenPublication::class.java){
            from(components.findByName(variant.name))

            groupId = "com.devomer" // GitHub kullanıcı adınızı ekleyin
            artifactId = "hbfontlib" // Projenizin adı
            version = "1.0.3" // Yayınladığınız versiyon

            artifact("$buildDir/outputs/aar/${variant.name}.aar") {
                builtBy(variant.assemble)
            }
        }
    }
}*/

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components.findByName("release")) // "release" bileşenini kullanır
            groupId = "com.devomer" // GitHub kullanıcı adınızı ekleyin
            artifactId = "hbfontlib" // Projenizin adı
            version = "1.0.2" // Yayınladığınız versiyon
        }
    }
}
