import org.gradle.api.JavaVersion

object Config{
    val compileSdkVersion = 30
    val buildToolsVersion = "30.0.2"
    val minSdkVersion = 21
    val targetSdkVersion = 30
    val sourceCompatibilityVersion = JavaVersion.VERSION_1_8
    val targetCompatibilityVersion = JavaVersion.VERSION_1_8
    val versionCode = 1
    val versionName = "1.0.0"
}

object Versions {

    const val PLUGIN_GRADLE_VERSION="3.6.3"
    const val PLUGIN_GMS_VERSION="3.1.1"
    const val KOTLIN_VERSION = "1.3.60"
    const val PLUGIN_BINTRAY_VERSION="1.7.3"
    const val PLUGIN_MAVEN_VERISON="2.1"

    const val JUNIT_VERSION = "4.12"
    const val ANDROIDX_APP_COMPAT_VERSION = "1.2.0"
    const val ANDROIDX_ACTIVITY_VERSION="1.2.0-alpha06"
    const val ANDROIDX_FRAGMENT_VERSION="1.3.0-alpha06"
    const val ANDROIDX_LIFECYCLE_VERSION="2.2.0"
    const val ANDROIDX_LIFECYCLE_ARCH_VERSION="2.1.0"
    const val ANDROIDX_CORE_VERSION="1.3.2"
    const val ANDROIDX_CORE_KTX_VERSION="1.3.2"
    const val ANDROIDX_CONSTRAINTLAYOUT_VERSION = "2.0.4"
}

object BuildDependencies {

    val junit = "junit:junit:${Versions.JUNIT_VERSION}"
    val kotlinStdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN_VERSION}"
}

object AndroidX {
    val appCompat = "androidx.appcompat:appcompat:${Versions.ANDROIDX_APP_COMPAT_VERSION}"
    const val coreKtx="androidx.core:core-ktx:${Versions.ANDROIDX_CORE_KTX_VERSION}"
    val activity="androidx.activity:activity:${Versions.ANDROIDX_ACTIVITY_VERSION}"
    val activityKtx="androidx.activity:activity-ktx:${Versions.ANDROIDX_ACTIVITY_VERSION}"
    val fragment="androidx.fragment:fragment:${Versions.ANDROIDX_FRAGMENT_VERSION}"
    val fragmentKtx="androidx.fragment:fragment-ktx:${Versions.ANDROIDX_FRAGMENT_VERSION}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.ANDROIDX_CONSTRAINTLAYOUT_VERSION}"
}



