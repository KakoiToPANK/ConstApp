plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.diplom"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.diplom"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        resources {
            excludes += setOf(
                "META-INF/DEPENDENCIES",
                "META-INF/LICENSE",
                "META-INF/*.md",
                "META-INF/NOTICE*",
                "META-INF/ASL2.0",
                "META-INF/INDEX.LIST",
                "META-INF/NOTICE.md",
                "META-INF/LICENSE.md"
            )
        }
    }
}

configurations.all {
    resolutionStrategy {
        // Принудительно используем конкретные версии библиотек
        force("org.apache.xmlbeans:xmlbeans:5.1.1")
        force("commons-io:commons-io:2.11.0")
        force("org.apache.commons:commons-collections4:4.4")

        // Убираем дубликаты
        preferProjectModules()
    }
}

dependencies {
    // Основные Android-зависимости
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // WebView и файловые операции
    implementation("androidx.webkit:webkit:1.7.0")

    // Для работы с HTML/WebView больше ничего не нужно

    // Убираем все POI и Tika зависимости, так как они не нужны для работы с HTML

    // Для обработки новых API на старых Android
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")

    // Тестирование
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}