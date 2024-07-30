/*plugins {
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


    implementation  (libs.coil)

    //OkHttp
    implementation (libs.okhttp)
    implementation (libs.logging.interceptor)

    //ViewModel
   // val lifecycle_version = "2.6.1"
   // implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
   // val livedata_version = "2.6.0"
    //implementation ("androidx.lifecycle:lifecycle-livedata:$livedata_version")//
    //val runtime_version = "2.6.0"
    //implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$runtime_version")

    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    //Picasso
    implementation (libs.picasso)

    //Room
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.room.compiler)


    //Fragment
    implementation (libs.androidx.fragment)

}
*/

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
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

    // Coil
    implementation(libs.coil)

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Picasso
    implementation(libs.picasso)

    // Room
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler) // Usar kapt para el compilador de Room

    // Fragment
    implementation(libs.androidx.fragment)
}
