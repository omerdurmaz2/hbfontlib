plugins {
    alias(libs.plugins.android.library)
    id("com.vanniktech.maven.publish") version "0.28.0" apply false
    id("com.gradleup.nmcp") version "0.0.7" apply false
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
