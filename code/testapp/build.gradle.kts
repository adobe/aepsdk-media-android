/*
 * Copyright 2024 Adobe. All rights reserved.
 * This file is licensed to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 * OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
import com.adobe.marketing.mobile.gradle.BuildConstants
plugins {
    id("com.android.application")
    id("com.diffplug.spotless")
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    java {
        toggleOffOn("format:off", "format:on")
        target("src/*/java/**/*.java")
        importOrder()
        removeUnusedImports()
        googleJavaFormat(BuildConstants.Versions.GOOGLE_JAVA_FORMAT).aosp().reflowLongStrings()
        endWithNewline()
        formatAnnotations()
        licenseHeader(BuildConstants.ADOBE_LICENSE_HEADER)
    }
}

android {
    namespace = "com.adobe.marketing.mobile.media.testapp"

    defaultConfig {
        minSdk = BuildConstants.Versions.MIN_SDK_VERSION
        compileSdk = BuildConstants.Versions.COMPILE_SDK_VERSION
        targetSdk = BuildConstants.Versions.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName(BuildConstants.BuildTypes.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = BuildConstants.Versions.JAVA_SOURCE_COMPATIBILITY
        targetCompatibility = BuildConstants.Versions.JAVA_TARGET_COMPATIBILITY
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.5.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation(project(":media"))
    implementation("com.adobe.marketing.mobile:core:3.0.0-SNAPSHOT")
    implementation("com.adobe.marketing.mobile:analytics:3.0.0-SNAPSHOT") {
        exclude(group = "com.adobe.marketing.mobile", module = "core")
    }
    implementation("com.adobe.marketing.mobile:identity:3.0.0-SNAPSHOT") {
        exclude(group = "com.adobe.marketing.mobile", module = "core")
    }
    implementation("com.adobe.marketing.mobile:assurance:3.0.0-SNAPSHOT") {
        exclude(group = "com.adobe.marketing.mobile", module = "core")
    }
}