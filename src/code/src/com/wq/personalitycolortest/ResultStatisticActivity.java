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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//结果统计
public class ResultStatisticActivity extends Activity {

	AdHelper adHelper = new AdHelper();

	int optionA; // 选项次数
	int optionB;
	int optionC;
	int optionD;

	int red; // 统计结果
	int blue;
	int yellow;
	int green;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 不要标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_result_statistic);
		SysApplication.getInstance().addActivity(this);

		optionA = getIntent().getExtras().getInt("red");
		optionB = getIntent().getExtras().getInt("blue");
		optionC = getIntent().getExtras().getInt("yellow");
		optionD = getIntent().getExtras().getInt("green");

		/*
		 * 计算规则： // 红色：前A+后D的总数 // 蓝色：前B+后C的总数 // 黄色：前C+后B的总数 // 绿色：前D+后A的总数
		 */
		red = optionA + optionD;
		blue = optionB + optionC;
		yellow = optionC + optionB;
		green = optionD + optionA;

		TextView txtRed = (TextView) findViewById(R.id.txtRed);
		TextView txtBlue = (TextView) findViewById(R.id.txtBlue);
		TextView txtYellow = (TextView) findViewById(R.id.txtYellow);
		TextView txtGreen = (TextView) findViewById(R.id.txtGreen);
		TextView txtTips = (TextView) findViewById(R.id.txtTips);

		txtRed.setText("红色：  " + red + " 分");
		txtBlue.setText("蓝色：  " + blue + " 分");
		txtYellow.setText("黄色：  " + yellow + " 分");
		txtGreen.setText("绿色：  " + green + " 分");
		txtTips.setText("结果查看方法：\n\n总分中数目最大的字母，是你的核心性格.其他字母代表你整个性格中的比例.\n\n如果某种颜色大于15，说明你是典型的此类性格，如果有两种或三种数目非常接近，说明你是较复杂的组合性格.\n\n本测试题目旨在测试你的“性格”而非你的“个性”，测试你的“先天”而非你的“后天”.但仍会有一部分读者很难判断哪种色彩是先天哪种色彩是后天，这类读者需要加强对自身“真实内心”的认识，\n如果你在做题过程中，严格符合测试说明，你将了解自己性格本源的力量.\n\n\n\n");

		// ////////////////////广告//////////////////////////

		adHelper.InitAD(this);

		// 互动广告调用方式
		LinearLayout layout = (LinearLayout) this
				.findViewById(R.id.AdLinearLayout_result);
		adHelper.ShowBannerAd1(this, layout);

		// /////////////////////广告//////////////////////////
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.result_statistic, menu);
	// return true;
	// }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

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

	// // 屏蔽后退按键
	// @Override
	// public void onBackPressed() {
	// // 这里处理逻辑代码，大家注意：该方法仅适用于2.0或更新版的sdk
	// return;
	// }

	/**
	 * 菜单、返回键响应
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			exitBy2Click(); // 调用双击退出函数
		}
		return false;
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
