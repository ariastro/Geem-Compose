import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    kotlin("kapt")
    id("kotlin-parcelize")
}

val properties = gradleLocalProperties(rootDir)

android {
    namespace = "io.astronout.core"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            buildConfigField("String", "BASE_URL", "\"https://api.rawg.io/api/\"")
            buildConfigField("String", "API_KEY", properties.getProperty("API_KEY"))
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.rawg.io/api/\"")
            buildConfigField("String", "API_KEY", properties.getProperty("API_KEY"))
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    buildFeatures {
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    kotlin {
        sourceSets {
            debug {
                kotlin.srcDir("build/generated/ksp/debug/kotlin")
            }
            release {
                kotlin.srcDir("build/generated/ksp/release/kotlin")
            }
        }
    }
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {
    api(platform(libs.compose.bom))
    api(libs.compose.activity)
    api(libs.compose.ui)
    api(libs.compose.material)
    api(libs.compose.ui.graphics)
    api(libs.compose.ui.preview)
    api(libs.compose.destination)
    ksp(libs.compose.destination.ksp)
    api(libs.compose.navigation)
    api(libs.compose.icons.extended)
    api(libs.compose.lifecycle.viewmodel)
    api(libs.compose.lifecycle.runtime)

    api(libs.core.ktx)
    api(libs.bundles.networking)

    api(libs.bundles.lifecycle)

    api(libs.bundles.moshi)
    ksp(libs.moshi.codegen)

    api(libs.dagger.hilt)
    api(libs.dagger.hilt.compose.navigation)
    kapt(libs.dagger.hilt.android.compiler)
    kapt(libs.dagger.hilt.compiler)

    api(libs.bundles.room)
    ksp(libs.room.compiler)

    api(libs.coil)

    api(libs.bundles.media3)

    api(libs.accompanist)

    api(libs.appcompat)
    api(libs.material)

    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    debugApi(libs.compose.ui.tooling)
    debugApi(libs.compose.ui.manifest)
}