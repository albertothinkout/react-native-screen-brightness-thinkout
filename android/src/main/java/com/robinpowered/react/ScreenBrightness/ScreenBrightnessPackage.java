package com.robinpowered.react.ScreenBrightness;

import android.app.Activity;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScreenBrightnessPackage implements ReactPackage {
  // Make sure that this doesn't clash with another reuqest code used in the app
  private static final int DEFAULT_WRITE_SETTINGS_REQUEST_CODE = 19999;

  private final int mWriteSettingsRequestCode;

  public ScreenBrightnessPackage(final int writeSettingsRequestCode) {
    mWriteSettingsRequestCode = writeSettingsRequestCode;
  }

  public ScreenBrightnessPackage() {
    this(DEFAULT_WRITE_SETTINGS_REQUEST_CODE);
  }

  @Override
  public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
    List<NativeModule> modules = new ArrayList<NativeModule>();
    modules.add(new ScreenBrightnessModule(
            reactApplicationContext,
            mWriteSettingsRequestCode
    ));
    return modules;
  }

  public List<Class<? extends JavaScriptModule>> createJSModules() {
    return Collections.emptyList();
  }

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
    return Arrays.<ViewManager>asList();
  }
}
