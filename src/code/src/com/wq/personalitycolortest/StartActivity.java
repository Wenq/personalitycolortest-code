package com.wq.personalitycolortest;

import java.util.Timer;
import java.util.TimerTask;

import com.example.personalitycolortest.R;
import com.wq.AD.AdHelper;
import com.wq.Utils.SysApplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends Activity {

	AdHelper adHelper = new AdHelper();
	// 抽屉广告布局
	private View slidingDrawerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 不要标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 全屏
		// this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		SysApplication.getInstance().addActivity(this);

		TextView txtUp = (TextView) findViewById(R.id.txtUp);
		TextView txtDown = (TextView) findViewById(R.id.txtDown);
		Button btnAbout = (Button) findViewById(R.id.btnAbout); // 关于按钮
		Button btnStartTest = (Button) findViewById(R.id.btnStartTest); // 开始测试按钮

		// 注意一下文本格式
		txtUp.setText("        用\"红,蓝,黄,绿\"四色代替人的性格类型,借助一幅幅美妙的图画来解析多变的哦人生;通过对\"性格色彩密码\"的解读,帮助你学会以\"有'色'眼睛\"洞察人性,增强对人生的洞察力,并修炼个性,从而掌握自己的命运.");
		txtDown.setText("选择答案时,请注意以下事项:\n    *选择最能符合你的选项.\n    *请选择让你\"最自然的\" \"最舒服的\"反应.");

		btnAbout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent aboutIntent = new Intent();
				aboutIntent.setClass(StartActivity.this, AboutActivity.class);
				startActivity(aboutIntent);
			}
		});
		btnStartTest.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent aboutIntent = new Intent();
				aboutIntent.setClass(StartActivity.this, TestActivity.class);
				startActivity(aboutIntent);
			}
		});

		// ////////////////////广告//////////////////////////

		// adHelper.InitADSetting("76a7e072a833ca8818c7ae28e74d5b0b",
		// "appChina",
		// false);

		adHelper.InitADSetting("", "", true);
		adHelper.InitAD(this);

		// 卸载广告
		adHelper.initUninstallAd(this);

		// 获取抽屉样式的自定义广告
		slidingDrawerView = com.wq.AD.Extend.SlideWall.getInstance().getView(
				this); // SlideWall.getInstance().getView(this);
		if (slidingDrawerView != null) {
			this.addContentView(slidingDrawerView, new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		}

		// 互动广告调用方式
		LinearLayout layout = (LinearLayout) this
				.findViewById(R.id.AdLinearLayout);
		adHelper.ShowBannerAd1(this, layout);

		// /////////////////////广告//////////////////////////
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		 * add()方法的四个参数，依次是： 1、组别，如果不分组的话就写Menu.NONE,
		 * 2、Id，这个很重要，Android根据这个Id来确定不同的菜单 3、顺序，哪个菜单现在在前面由这个参数的大小决定
		 * 4、文本，菜单的显示文本
		 */

		// menu.add(Menu.NONE, Menu.FIRST + 1, 2, "删除").setIcon(
		// android.R.drawable.ic_menu_delete);
		// setIcon()方法为菜单设置图标，这里使用的是系统自带的图标，以
		// android.R开头的资源是系统提供的，我们自己提供的资源是以R开头的
		// menu.add(Menu.NONE, Menu.FIRST + 2, 3, "保存").setIcon(
		// android.R.drawable.ic_menu_edit);
		// menu.add(Menu.NONE, Menu.FIRST + 3, 4, "帮助").setIcon(
		// android.R.drawable.ic_menu_help);
		// menu.add(Menu.NONE, Menu.FIRST + 4, 1, "添加").setIcon(
		// android.R.drawable.ic_menu_add);

		menu.add(Menu.NONE, Menu.FIRST + 1, 1, "色彩介绍").setIcon(
				android.R.drawable.ic_menu_help);

		menu.add(Menu.NONE, Menu.FIRST + 2, 2, "关于").setIcon(
				android.R.drawable.ic_menu_info_details);

		menu.add(Menu.NONE, Menu.FIRST + 3, 3, "退出").setIcon(
				android.R.drawable.ic_menu_close_clear_cancel);

		// 返回true则显示，返回false则不显示
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case Menu.FIRST + 1:
			Intent aboutIntent2 = new Intent();
			aboutIntent2.setClass(this, ColorDescriptionActivity.class);
			startActivity(aboutIntent2);
			break;

		case Menu.FIRST + 2:
			Intent aboutIntent = new Intent();
			aboutIntent.setClass(this, AboutActivity.class);
			startActivity(aboutIntent);
			break;

		case Menu.FIRST + 3:
			SysApplication.getInstance().exit();
			break;
		}
		// 返回false则正常显示，返回true则被消费掉
		return false;

	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// Toast.makeText(this, "选项菜单关闭了", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// Toast.makeText(this,
		// "选项菜单显示之前onPrepareOptionsMenu方法会被调用，你可以用此方法来根据打当时的情况调整菜单",
		// Toast.LENGTH_LONG).show();

		// 如果返回false，此方法就把用户点击menu的动作给消费了，onCreateOptionsMenu方法将不会被调用
		return true;

	}

	/**
	 * 菜单、返回键响应
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			// exitBy2Click(); // 调用双击退出函数

			// 退出对话框广告
			if (com.wq.AD.Extend.SlideWall.getInstance().slideWallDrawer != null
					&& com.wq.AD.Extend.SlideWall.getInstance().slideWallDrawer
							.isOpened()) {
				// 如果抽屉式应用墙展示中，则关闭抽屉
				com.wq.AD.Extend.SlideWall.getInstance().closeSlidingDrawer();
			} else {
				// 调用退屏广告
				com.wq.AD.Extend.QuitPopAd.getInstance().show(this);
			}
		}
		return true;
	}

	private static Boolean isExit = false;

	/**
	 * 双击退出函数
	 */
	private void exitBy2Click() {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true; // 准备退出
			Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false; // 取消退出
				}
			}, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

		} else {
			// finish();
			// System.exit(0);
			SysApplication.getInstance().exit();
		}
	}

	// 退出时，关闭广告
	@Override
	protected void onDestroy() {
		// 释放资源，原finalize()方法名修改为close()
		adHelper.CloseAD(this);
		super.onDestroy();
	}
}
