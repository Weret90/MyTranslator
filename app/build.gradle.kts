plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    compileSdk = 31
    buildToolsVersion = "31.0.0"

    defaultConfig {
        applicationId = "com.umbrella.mytranslator"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.CORE_KTX_DEP)
    implementation(Dependencies.APP_COMPAT_DEP)
    implementation(Dependencies.MATERIAL_DEP)
    implementation(Dependencies.CONSTRAINT_LAYOUT_DEP)
    implementation(Dependencies.LEGACY_SUPPORT_DEP)
    testImplementation(Dependencies.J_UNIT_DEP)
    androidTestImplementation(Dependencies.TEST_EXT_J_UNIT_DEP)
    androidTestImplementation(Dependencies.ESPRESSO_CORE_DEP)

    implementation(project(":data"))
    implementation(project(":domain"))

    //picasso
    implementation(Dependencies.PICASSO_DEP)

    //koin
    implementation(Dependencies.KOIN_CORE_DEP)
    implementation(Dependencies.KOIN_ANDROID_DEP)

    //coroutines
    implementation(Dependencies.LIFECYCLE_VIEWMODEL_KTX_DEP)

    //retrofit
    implementation(Dependencies.RETROFIT_DEP)
    implementation(Dependencies.RETROFIT_CONVERTER_GSON_DEP)

    //Room
    implementation(Dependencies.ROOM_RUNTIME_DEP)
    kapt(Dependencies.ROOM_COMPILER_DEP)
    implementation(Dependencies.ROOM_KTX_DEP)

    //splash screen
    implementation(Dependencies.SPLASH_SCREEN_DEP)
}