plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.ecommerce"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ecommerce"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //agregar dependencias


    implementation  ("io.coil-kt:coil:2.6.0")

    //OkHttp
    implementation ("com.squareup.okhttp3:okhttp:4.11.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.11.0")

    //ViewModel
    val lifecycle_version = "2.6.1"
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    val livedata_version = "2.6.0"
    implementation ("androidx.lifecycle:lifecycle-livedata:$livedata_version")
    val runtime_version = "2.6.0"
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$runtime_version")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Picasso
    implementation ("com.squareup.picasso:picasso:2.71828")

    //Room
    implementation ("androidx.room:room-runtime:2.5.1")
    implementation ("androidx.room:room-compiler:2.5.1")

    //Activity
    implementation ("androidx.activity:activity:1.9.1")

    //Fragment
    implementation ("androidx.fragment:fragment:1.8.2")

}