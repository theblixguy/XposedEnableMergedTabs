package com.suyashsrijan.xposedenablemergedtabs;

import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class EnableMergedTabs implements IXposedHookLoadPackage{
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.chrome.beta")) {
            XposedBridge.log("EnableMergedTabs: Chrome Beta found!");
            try {
                findAndHookMethod("org.chromium.chrome.browser.util.FeatureUtilities", lpparam.classLoader, "isDocumentMode", Context.class, XC_MethodReplacement.returnConstant(true));
                findAndHookMethod("org.chromium.chrome.browser.tabmodel.DocumentModeAssassin", lpparam.classLoader, "isMigrationNecessary", XC_MethodReplacement.returnConstant(false));
                XposedBridge.log("EnableMergedTabs: Hooked!");
            } catch (Throwable t) {
                XposedBridge.log(t);
            }
        } else if (lpparam.packageName.equals("com.chrome.dev")) {
            XposedBridge.log("EnableMergedTabs: Chrome Dev found!");
            try {
                findAndHookMethod("org.chromium.chrome.browser.util.FeatureUtilities", lpparam.classLoader, "isDocumentMode", Context.class, XC_MethodReplacement.returnConstant(true));
                findAndHookMethod("org.chromium.chrome.browser.tabmodel.DocumentModeAssassin", lpparam.classLoader, "isMigrationNecessary", XC_MethodReplacement.returnConstant(false));
                XposedBridge.log("EnableMergedTabs: Hooked!");
            } catch (Throwable t) {
                XposedBridge.log(t);
            }
        } else if (lpparam.packageName.equals("com.android.chrome")) {
            XposedBridge.log("EnableMergedTabs: Chrome Stable found!");
            try {
                findAndHookMethod("org.chromium.chrome.browser.util.FeatureUtilities", lpparam.classLoader, "isDocumentMode", Context.class, XC_MethodReplacement.returnConstant(true));
                findAndHookMethod("org.chromium.chrome.browser.tabmodel.DocumentModeAssassin", lpparam.classLoader, "isMigrationNecessary", XC_MethodReplacement.returnConstant(false));
                XposedBridge.log("EnableMergedTabs: Hooked!");
            } catch (Throwable t) {
                XposedBridge.log(t);
            }
        }
    }
}