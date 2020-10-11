plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  compileSdkVersion(ProjectConfig.compileSdkVersion)

  defaultConfig {
    minSdkVersion(ProjectConfig.minSdkVersion)
    targetSdkVersion(ProjectConfig.targetSdkVersion)

    consumerProguardFiles("proguard-rules.pro")
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  buildFeatures {
    buildConfig = false
  }

  testOptions.unitTests {
    isReturnDefaultValues = true
  }
}

dependencies {
  implementation(Deps.kotlinStdLib)

  api(project(":cast-ktx"))
  api(Deps.castFrameworkSdk)

  testImplementation(Deps.androidxTestCore)
  testImplementation(Deps.androidxJUnit)
  testImplementation(Deps.junit)
  testImplementation(Deps.truth)
}