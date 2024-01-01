import java.util.Properties

plugins {
    id("app-android-convention")
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.zhigaras.gemini"
    
    defaultConfig {
        applicationId = "com.zhigaras.gemini"
        versionCode = 1
        versionName = "1.0"
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        
        val keystoreFile = project.rootProject.file("keys.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())
        
        val geminiKey = properties.getProperty("GEMINI_KEY") ?: ""
        
        buildConfigField("String", "GEMINI_KEY", geminiKey)
    }
    
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.graphics)
    implementation(libs.androidx.compose.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.google.ai.generativeai)
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.test.compose.ui)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.test.manifest)
}