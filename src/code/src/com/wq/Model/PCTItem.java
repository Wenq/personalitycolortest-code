package com.wq.Model;

//表示一个测试题选项
public class PCTItem {

	// 1 选项题目：
	// A xxxxx
	// B xxxxx
	// C xxxxx
	// D xxxxx

	// 标题
	private String title;

	// 选项A
	private String optionA;

	// 选项B
	private String optionB;

	// 选项C
	private String optionC;

	// 选项D
	private String optionD;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
}
