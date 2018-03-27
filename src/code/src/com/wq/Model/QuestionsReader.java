package com.wq.Model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.Activity;

//读取问题存储xml文件
public class QuestionsReader {

	public QuestionsReader(String fileName) {
		this.fileName = fileName;
	}

	private String fileName;

	// 读取所有测试题内容
	public List<PCTItem> GetPCTItemList(Activity parentcontext) {

		ArrayList<PCTItem> items = new ArrayList<PCTItem>();

		// TODO:读取xml文件中所有问题
		try {
			PCTItem pctItemTmp = new PCTItem();

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			// Document doc = db.parse(new File(
			// "/Personalitycolortest/PersonalityColorTestItems.xml"));
			// Document doc = db.parse(new File(fileName));

			// InputStream inputStream = Resources.getSystem().getAssets()
			// .open(fileName);

			// 加载xml
			// InputStream inputStream = getClass().getClassLoader()
			// .getResourceAsStream(fileName);
			
			// 从Assets目录加载xml
			InputStream inputStream = parentcontext.getResources().getAssets()
					.open(fileName);
			Document doc = db.parse(inputStream);

			// Element root = doc.getElementById("PersonalityColorTestItems");
			// // 根节点
			NodeList lst = doc
					.getElementsByTagName("PersonalityColorTestItems");

			// NodeList itemLst = root.getChildNodes();
			NodeList itemLst = lst.item(0).getChildNodes();
			NodeList attrLst;
			Node itemNode;
			Node attrNode;

			// 选项题节点
			for (int i = 0; i < itemLst.getLength(); i++) {
				itemNode = itemLst.item(i);
				if (itemNode.getNodeType() == Node.ELEMENT_NODE
						&& itemNode.getNodeName().equals(
								"PersonalityColorTestItem")) {
					attrLst = itemNode.getChildNodes();

					// 选择题内容
					int turn = 0; // Title+OpionA...+OptionD 共5个信息
					for (int t = 0; t < attrLst.getLength(); t++) {
						attrNode = attrLst.item(t);
						if (attrNode.getNodeType() == Node.ELEMENT_NODE) {
							String nodeName = attrNode.getNodeName();
							if (nodeName.equalsIgnoreCase("Title")) {
								pctItemTmp.setTitle(attrNode.getTextContent());
							} else if (nodeName.equalsIgnoreCase("OptionA")) {
								pctItemTmp
										.setOptionA(attrNode.getTextContent());
							} else if (nodeName.equalsIgnoreCase("OptionB")) {
								pctItemTmp
										.setOptionB(attrNode.getTextContent());
							} else if (nodeName.equalsIgnoreCase("OptionC")) {
								pctItemTmp
										.setOptionC(attrNode.getTextContent());
							} else if (nodeName.equalsIgnoreCase("OptionD")) {
								pctItemTmp
										.setOptionD(attrNode.getTextContent());
							}
							turn += 1;
						}
						if (turn == 5) {
							items.add(pctItemTmp);
							pctItemTmp = new PCTItem();
							turn = 0;
						}
					}
				}
			}
			inputStream.close();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}
}
