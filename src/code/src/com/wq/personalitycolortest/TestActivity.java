package com.wq.personalitycolortest;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.example.personalitycolortest.R;
import com.wq.AD.AdHelper;
import com.wq.Model.PCTItem;
import com.wq.Model.QuestionsReader;
import com.wq.Utils.Constant;
import com.wq.Utils.SysApplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TextView;

//做题
public class TestActivity extends Activity {

	AdHelper adHelper = new AdHelper();

	List<PCTItem> itemList; // 题目列表
	int Sum; // 题目总数
	int currentPosition; // 当前测试题目索引号,从0开始

	int optionA;
	int optionB;
	int optionC;
	int optionD;

	TextView txtTitle; // 界面标题
	TextView txtTestTitle; // 测试题标题
	RadioButton radioButton1; // 选项A
	RadioButton radioButton2; // 选项B
	RadioButton radioButton3; // 选项C
	RadioButton radioButton4; // 选项D

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 不要标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_test);
		SysApplication.getInstance().addActivity(this);

		// 初始数据
		QuestionsReader qr = new QuestionsReader(Constant.xmlFileName);
		itemList = qr.GetPCTItemList(this);
		Sum = itemList.size();
		currentPosition = 0;

		optionA = 0;
		optionB = 0;
		optionC = 0;
		optionD = 0;

		Button btnAbout = (Button) findViewById(R.id.btnAbout); // 关于按钮
		txtTitle = (TextView) findViewById(R.id.txtTitle); // 界面标题
		txtTestTitle = (TextView) findViewById(R.id.txtTestTitle); // 测试题标题
		radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
		radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
		radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
		radioButton4 = (RadioButton) findViewById(R.id.radioButton4);

		btnAbout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent aboutIntent = new Intent();
				aboutIntent.setClass(TestActivity.this, AboutActivity.class);
				startActivity(aboutIntent);
			}
		});

		OnCheckedChangeListener radionButtonListenner = new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				switch (buttonView.getId()) {
				case R.id.radioButton1:
					optionA += 1;
					SetContent(currentPosition += 1);
					break;
				case R.id.radioButton2:
					optionB += 1;
					SetContent(currentPosition += 1);
					break;
				case R.id.radioButton3:
					optionC += 1;
					SetContent(currentPosition += 1);
					break;
				case R.id.radioButton4:
					optionD += 1;
					SetContent(currentPosition += 1);
					break;
				}
			}
		};

		radioButton1.setOnCheckedChangeListener(radionButtonListenner);
		radioButton2.setOnCheckedChangeListener(radionButtonListenner);
		radioButton3.setOnCheckedChangeListener(radionButtonListenner);
		radioButton4.setOnCheckedChangeListener(radionButtonListenner);

		SetContent(currentPosition);

		// ////////////////////广告//////////////////////////

		adHelper.InitAD(this);

		// 互动广告调用方式
		LinearLayout layout = (LinearLayout) this
				.findViewById(R.id.AdLinearLayout_test);
		adHelper.ShowBannerAd1(this, layout);

		// /////////////////////广告//////////////////////////
	}

	// 设置UI显示内容
	private void SetContent(int position) {

		if (position >= 0 && position < Sum) {
			PCTItem item = itemList.get(position);
			// 界面题目
			txtTitle.setText("第" + (position + 1) + "/" + Sum + "题");
			// 测试题题目
			txtTestTitle.setText(item.getTitle());
			// 选项内容
			radioButton1.setText(item.getOptionA());
			radioButton2.setText(item.getOptionB());
			radioButton3.setText(item.getOptionC());
			radioButton4.setText(item.getOptionD());
			// 选项状态
			radioButton1.setChecked(false);
			radioButton2.setChecked(false);
			radioButton3.setChecked(false);
			radioButton4.setChecked(false);
		}

		// 跳转到结果统计界面
		if (position >= Sum) {
			Intent intent = new Intent();
			intent.putExtra("red", optionA);
			intent.putExtra("blue", optionB);
			intent.putExtra("yellow", optionC);
			intent.putExtra("green", optionD);
			intent.setClass(this, ResultStatisticActivity.class);
			this.startActivity(intent);
		}
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.test, menu);
	// return true;
	// }@Override
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

	// 屏蔽后退按键
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
