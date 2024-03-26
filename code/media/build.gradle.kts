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
plugins {
    id("aep-library")
}

val mavenCoreVersion: String by project

aepLibrary {
    namespace = "com.adobe.marketing.mobile.media"
    enableSpotless = true
    enableCheckStyle = true
    // A bug in the AEP Gradle plugin prevents proper javadoc generation for projects with internal subpackages. Dokka doc is used as a workaround.
    enableDokkaDoc = true
    publishing {
        gitRepoName = "aepsdk-media-android"
        addCoreDependency(mavenCoreVersion)
    }
}

dependencies {
    // Stop using SNAPSHOT after Core release.
    implementation("com.adobe.marketing.mobile:core:$mavenCoreVersion-SNAPSHOT")
}