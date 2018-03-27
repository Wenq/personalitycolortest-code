package com.wq.AD;

import cn.waps.AppConnect;
import android.app.Activity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

//移动广告封装类
public class AdHelper {

	// 是否广告相关ID存放程序AndroidManifest文件中
	private static boolean IsIdInManifestConfig;

	// 广告平台APP的ID(唯一)
	private static String APP_ID;

	// 分发平台配套app的ID(标识)
	private static String APP_PID;

	// 设置程序相关ID: APP_ID,APP_PID,ID信息是否写在AndroidManifest.xml文件中（初始化，程序启动触发一次就ok）
	public void InitADSetting(String app_ID, String app_PID,
			boolean isIdInManifestConfig) {
		APP_ID = app_ID;
		APP_PID = app_PID;
		IsIdInManifestConfig = isIdInManifestConfig;
	}

	// 1数据统计接口：初始化ID接口(每个activity都需要调用)
	public void InitAD(Activity context) {
		try {
			if (IsIdInManifestConfig) {
				AppConnect.getInstance(context);
			} else {
				AppConnect.getInstance(APP_ID, APP_PID, context);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2虚拟货币接口

	// 3积分墙接口

	// 4互动广告接口，广告条高度50dp（先调用初始化接口）
	public void ShowBannerAd1(Activity context, LinearLayout layout) {
		try {
			AppConnect.getInstance(context).showBannerAd(context, layout);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 互动广告接口，广告条高度50dp（先调用初始化接口）
	public void ShowBannerAd2(Activity context) {
		try {
			LinearLayout adlayout = new LinearLayout(context);
			adlayout.setGravity(Gravity.CENTER_HORIZONTAL);
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
					ViewGroup.LayoutParams.FILL_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
			AppConnect.getInstance(context).showBannerAd(context, adlayout);
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);// 此代码可设置顶端或低端
			context.addContentView(adlayout, layoutParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 5插屏广告接口(全屏显示，不占用固定)

	// 6功能广告接口

	// 7自定义广告接口

	// 8迷你广告接口(高度24dp)

	// 9卸载广告接初始化(用户卸载app后显示)
	public void initUninstallAd(Activity context) {
		try {
			AppConnect.getInstance(context).initUninstallAd(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 10工具组件接口

	// 10.1 用户反馈接口
	public void showFeedback(Activity context) {
		try {
			AppConnect.getInstance(context).showFeedback(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 10.2 禁用错误报告
	public void CloseCrashReport(Activity context) {
		try {
			AppConnect.getInstance(context).setCrashReport(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 退出广告显示
	public void CloseAD(Activity context) {
		try {
			AppConnect.getInstance(context).close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 标识写配置文件 <meta-data android:name="APP_ID"android:value="应用标识"/>
	 * <meta-dataandroid:name="APP_PID"android:value="分发渠道标识"/>
	 */

	/*
	 * 权限要求 <uses-permissionandroid:name="android.permission.INTERNET"/>
	 * <uses-permissionandroid:name="android.permission.ACCESS_NETWORK_STATE"/>
	 * <uses-permissionandroid:name="android.permission.ACCESS_WIFI_STATE"/>
	 * <uses-permissionandroid:name="android.permission.READ_PHONE_STATE"/>
	 * <uses
	 * -permissionandroid:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
	 * <uses-permissionandroid:name="android.permission.GET_TASKS"/>
	 */

}
