package com.wq.personalitycolortest;

import com.example.personalitycolortest.R;
import com.wq.AD.AdHelper;
import com.wq.Utils.SysApplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

//色彩说明
public class ColorDescriptionActivity extends Activity {

	AdHelper adHelper = new AdHelper();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 不要标题
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_color_description);
		SysApplication.getInstance().addActivity(this);

		TextView txtxshuoming = (TextView) findViewById(R.id.txtxshuoming);
		TextView txtRed = (TextView) findViewById(R.id.txtRed);
		TextView txtBlue = (TextView) findViewById(R.id.txtBlue);
		TextView txtYellow = (TextView) findViewById(R.id.txtYellow);
		TextView txtGreen = (TextView) findViewById(R.id.txtGreen);

		txtxshuoming
				.setText("红、蓝、黄、绿是一种性格的代表.\n红色代表活泼、蓝色代表完美、黄色代表进取，而绿色代表平和.\n\n");

		// txtRed.setText("【红色】\n你精力充沛，感情丰富,活泼热情, 乐观积极,信任他人，表达力强，是带来快乐的人.有些粗心大意，不受规则束缚，喜欢表现自己，非常乐于接受变革，甚至作为变革的支持和鼓吹者.你的情绪变化直接与别人的认同有关.\n\n代表人物： 老顽童周伯通，猪八戒\n\n");
		// txtBlue.setText("【蓝色】\n你是个人主义者，追求精确严谨，遇事细斟慢酌，但隐而不发，深藏若虚.避免和反感与那些缺乏理性、反复无常或过于直率的人相处.反复思考衡量避免失败，有时会显得忧虑重重.\n\n代表人物： 诸葛亮，林黛玉\n\n ");
		// txtYellow
		// .setText("【黄色】\n你有很强烈的意愿成为人中之杰，不知疲倦地去追求自己的梦想和利益是你的快乐之源，一旦如愿以偿，又会很快瞄准新的目标，能够快速发现问题所在并采取行动，不喜欢等待.你喜欢迎接新的挑战，想当征服者.\n\n代表人物： 哪吒，张三丰 \n\n");
		// txtGreen.setText("【绿色】\n你很容易接近，喜欢与人们友好相处，性情温和，谦逊识体，最担心由于意外的变革或个人纷争而破坏安安稳稳的生活.你更多的时候是按规矩办事，不求变化，不喜欢压力，在压力之下会变得柔弱退缩.\n\n代表人物： 郭靖，阿甘\n\n\n\n");

		txtRed.setText("红色： 行动者 \n红色性格的人是快节奏的人，会自发地行动和做出决策.他不关心事实和细节，并尽可能地逃避一些繁琐的工作.这种不遵循事实的特性经常会让他夸大其词.红色性格的人与分析研究相对比更喜欢随意猜测.他对组织活动充满兴趣，能够快速并热情地与人相处.红色性格的人一直追逐梦想，他有着不可思议的能力能够让别人和他一起实现梦想，他有非常强的说服能力.他一直寻求别人对他的成就给予赞扬.红色性格的人是很有创意的人，思维敏捷.\n\n红色的劣势:\n会被人认为是主观的、鲁莽的、易冲动的.\n\n");
		txtBlue.setText("蓝色： 思想者 \n蓝色性格的人注重思考过程，能够全面、系统性的解决问题.他非常关心事物的安全性，任何事情都追求正确无误.所以这种人热衷于收集数据，询问很多有关于细节的问题.他的行动和决策都是非常谨慎的.蓝色性格的人做事缓慢，要求准确，喜欢有组织、有构架的，知识性的工作环境.这种性格的人比较容易多疑，且喜欢将事情记录下来.蓝色虽然是一个很好的问题解决者，但同时又是一个并不果断的决策者.当需要作决策时，他往往为了收集数据耽误了时间，经常性被他们引以为豪的口头禅是：“你不可能只掌握一半的数据就做出一项重要的决定吧.”\n\n蓝色的劣势:\n会被认为是有距离的、挑剔的，和严肃的.\n\n ");
		txtYellow
				.setText("黄色： 领导者 \n黄色性格的人是非常直接的，同时也很严谨.黄色性格的人善于控制他人和环境，果断行动和决策.这种性格的人行动非常迅速，对拖延非常没有耐心.当别人不能跟上他们的节奏，他会认为他们没有能力.黄色性格的人的座右铭是“我要做得又快又好”.黄色性格的人是典型的执行者，他们有很强的自我管理能力，他们自觉完成工作并给予自己新的任务.黄色性格的人喜欢同时做很多事情.他可以同时做三件事，并尽可能做第四件事.他会持续给自己加压一直到自己无法承受的最高点，之后稍事放松.然而很快他又会重新开始整个进程.\n\n黄色的劣势:\n和别人交往时，常常表现冷漠，以产出和目标为导向，更关心最后的结果，会被认为是固执、缺乏耐心、强硬和专横. \n\n");
		txtGreen.setText("绿色： 和平者\n绿色性格的人追求安全感和归属感，和蓝色一样做事和决策慢，不同的是这种拖延是因为绿色性格的人不愿冒风险.在他行动或作决策之前，他希望能够先了解别人的感受.绿色性格的人是四种性格中最以人际为导向的人.对这种性格最适合的形容词是亲近的、友好的.绿色性格的人不喜欢与人发生冲突，所以有时他会说别人想听的话而不是他心里想的话.绿色性格的人有很强的劝说能力，非常愿意支持其他人.他也是一个积极的聆听者.作为他的伙伴你会感觉很舒服.因为绿色性格的人很愿意听别人说，因此轮到他说的时候，别人也愿意听他说，因此他有很强的能力获得别人的支持.\n\n绿色的劣势:\n会被人认为过于温和，心肠太软，老好人.\n\n\n\n");

		// ////////////////////广告//////////////////////////

		adHelper.InitAD(this);
		// 互动广告调用方式
		LinearLayout layout = (LinearLayout) this
				.findViewById(R.id.AdLinearLayout_Color);
		adHelper.ShowBannerAd1(this, layout);

		// /////////////////////广告//////////////////////////
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.color_description, menu);
	// return true;
	// }
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	//
	// menu.add(Menu.NONE, Menu.FIRST + 1, 1, "关于").setIcon(
	// android.R.drawable.ic_menu_info_details);
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
	//
	// case Menu.FIRST + 1:
	// Intent aboutIntent = new Intent();
	// aboutIntent.setClass(this, AboutActivity.class);
	// startActivity(aboutIntent);
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
