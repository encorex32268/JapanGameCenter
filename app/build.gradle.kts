plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1"
}

android {
    compileSdk = ProjectConfig.compileSdk
    lint {
        isCheckDependencies = true
    }
    defaultConfig {
        applicationId =  ProjectConfig.applicationId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName  = ProjectConfig.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("**/attach_hotspot_windows.dll")
        exclude("META-INF/licenses/ASM")
    }
}

dependencies {

    implementation(AndroidX.core)
    implementation(Compose.compose_ui)
    implementation(Compose.compose_material)
    implementation(Compose.compose_tooling_preview)
    implementation(Compose.compose_lifecycle_runtime)
    implementation(Compose.compose_activity)


    testImplementation(Test.junit)
    androidTestImplementation(Test.ext_junit)
    androidTestImplementation(Test.espresso)
    androidTestImplementation(Compose.compose_ui_test)
    debugImplementation(Compose.compose_ui_tooling)
    debugImplementation(Compose.compose_ui_test_manifest)
    implementation(Compose.navigation)
    implementation(Compose.viewModelCompose)
    implementation(Compose.hiltNavigationCompose)
    implementation(Compose.snapper)


    kapt(Room.roomCompiler)
    implementation(Room.roomKtx)
    implementation(Room.roomRuntime)

    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)


    implementation(Google.location)
    implementation(Google.map)
    implementation(Google.map_compose)

    implementation(Gson.google_gson)


}