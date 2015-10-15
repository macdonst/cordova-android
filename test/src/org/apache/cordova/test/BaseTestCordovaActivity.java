/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package org.apache.cordova.test;

import android.os.Bundle;

import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaWebInterface;

import java.util.concurrent.ArrayBlockingQueue;

public class BaseTestCordovaActivity extends CordovaActivity {
    public final ArrayBlockingQueue<String> onPageFinishedUrl = new ArrayBlockingQueue<String>(500);

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Object onMessage(String id, Object data) {
        if ("onPageFinished".equals(id)) {
            onPageFinishedUrl.add((String) data);
        }
        return super.onMessage(id, data);
    }

    public CordovaWebInterface getCordovaWebView() {
        return appView;
    }

}
