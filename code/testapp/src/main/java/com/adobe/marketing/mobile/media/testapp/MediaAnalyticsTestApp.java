/*
  Copyright 2021 Adobe. All rights reserved.
  This file is licensed to you under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software distributed under
  the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
  OF ANY KIND, either express or implied. See the License for the specific language
  governing permissions and limitations under the License.
*/

package com.adobe.marketing.mobile.media.testapp;

import android.app.Application;
import com.adobe.marketing.mobile.AdobeCallback;
import com.adobe.marketing.mobile.Analytics;
import com.adobe.marketing.mobile.Assurance;
import com.adobe.marketing.mobile.Identity;
import com.adobe.marketing.mobile.LoggingMode;
import com.adobe.marketing.mobile.Media;
import com.adobe.marketing.mobile.MobileCore;
import java.util.Arrays;

public class MediaAnalyticsTestApp extends Application {

	//Insert Launch App id
	private static final String LAUNCH_ENVIRONMENT_FILE_ID = "";

	@Override
	public void onCreate() {
		super.onCreate();
		MobileCore.setApplication(this);
		MobileCore.setLogLevel(LoggingMode.VERBOSE);

		MobileCore.registerExtensions(
			Arrays.asList(Assurance.EXTENSION, Identity.EXTENSION, Analytics.EXTENSION, Media.EXTENSION),
			(AdobeCallback) o -> MobileCore.configureWithAppID(LAUNCH_ENVIRONMENT_FILE_ID)
		);
	}
}
