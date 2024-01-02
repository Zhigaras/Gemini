import java.util.Properties

plugins {
    id("lib-android-convention")
}

android {
    namespace = "com.zhigaras.ai"
    
    defaultConfig {
        
        val keystoreFile = project.rootProject.file("keys.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())
        val geminiKey = properties.getProperty("GEMINI_KEY") ?: ""
        buildConfigField("String", "GEMINI_KEY", geminiKey)
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    
    buildFeatures {
        buildConfig = true
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    
    implementation(libs.google.ai.generativeai)
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)
}