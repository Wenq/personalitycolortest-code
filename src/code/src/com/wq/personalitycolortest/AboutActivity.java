package com.wq.personalitycolortest;

import com.example.personalitycolortest.R;
import com.wq.AD.AdHelper;
import com.wq.Utils.Constant;
import com.wq.Utils.SysApplication;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutActivity extends Activity {

	AdHelper adHelper = new AdHelper();
	
	TextView mTextView = null;
	Button btnBack = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 不要标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_about);
		SysApplication.getInstance().addActivity(this);

		btnBack = (Button) findViewById(R.id.btnBack);
		mTextView = (TextView) findViewById(R.id.ClickMe);

		btnBack.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		// 设置超链接方法1:不要设置autoLink属性，否则链接显示不出来
		// String html = "有问题：\n";
		// html+="<a href='http://www.baidu.com'>百度一下</a>";
		// 注意这里必须加上协议号，即http://,否则，系统会以为该链接是activity，而实际这个activity不存在，程序就崩溃。
		String html = "<a href='" + Constant.personalityColorTestLink + "'>"
				+ getString(R.string.click_me) + "</a>";
		CharSequence charSequence = Html.fromHtml(html);
		mTextView.setText(charSequence);
		mTextView.setMovementMethod(LinkMovementMethod.getInstance());

		// // 设置超链接方法2：会直接将链接显示给用户
		// String html = "有问题：\n";
		// html += "www.baidu.com";// 这里即使不加协议好HTTP；也能自动被系统识别出来。
		// mTextView.setText(html);
		// mTextView.setAutoLinkMask(Linkify.ALL);
		// mTextView.setMovementMethod(LinkMovementMethod.getInstance());

		// ////////////////////广告//////////////////////////

		adHelper.InitAD(this);
		// 互动广告调用方式
		LinearLayout layout = (LinearLayout) this
				.findViewById(R.id.AdLinearLayout_About);
		adHelper.ShowBannerAd1(this, layout);

		// /////////////////////广告//////////////////////////
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.about, menu);
	// return true;
	// }
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	//
	// menu.add(Menu.NONE, Menu.FIRST + 1, 1, "色彩介绍").setIcon(
	// android.R.drawable.ic_menu_help);
	//
	// menu.add(Menu.NONE, Menu.FIRST + 2, 2, "退出").setIcon(
	// android.R.drawable.ic_menu_close_clear_cancel);
	// // 返回true则显示，返回false则不显示
	// return true;
	// }
	//
	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// switch (item.getItemId()) {
	// case Menu.FIRST + 1:
	// Intent aboutIntent2 = new Intent();
	// aboutIntent2.setClass(this, ColorDescriptionActivity.class);
	// startActivity(aboutIntent2);
	// break;
	//
	// case Menu.FIRST + 2:
	// SysApplication.getInstance().exit();
	// break;
	// }
	// // 返回false则正常显示，返回true则被消费掉
	// return false;
	// }

	// 退出时，关闭广告
	@Override
	protected void onDestroy() {
		// 释放资源，原finalize()方法名修改为close()
		adHelper.CloseAD(this);
		super.onDestroy();
	}
}
