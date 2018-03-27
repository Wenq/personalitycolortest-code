package com.wq.Utils;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.Application;

//管理程序Activity [不确定是否释放了全部资源wq-20140718]
public class SysApplication extends Application {
	private List<Activity> mList;

	private static SysApplication instance;

	private SysApplication() {
		if (mList == null) {
			mList = new ArrayList<Activity>();
		}
	}

	public synchronized static SysApplication getInstance() {
		if (null == instance) {
			instance = new SysApplication();
		}
		return instance;
	}

	// add Activity
	public void addActivity(Activity activity) {
		mList.add(activity);
	}

	// exit close all Activity
	public void exit() {
		try {
			for (Activity activity : mList) {
				if (activity != null) {
					activity.finish();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	public void onLowMemory() {
		super.onLowMemory();
		System.gc();
	}
}
