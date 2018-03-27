using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using XmlTools.Model;
using System.Windows.Forms;
using XmlTools.Tools;
using System.Xml;

namespace XmlTools
{
    /// <summary>
    /// 按照txt文本文件格式，生成xml文件（实现1）.
    /// </summary>
    public class XmlGenerate1 : IXmlGenerate
    {
        public string GenerateXml(string txtPath, string xmlFileName)
        {
            string xmlFilePath = string.Empty;
            string xmlDir = Utils.GetExeStartPath() + Constant.XmlSavePath;
            string xmlFilePathTmp = xmlDir + xmlFileName + ".xml";

            try
            {
                if (!Directory.Exists(xmlDir))
                    Directory.CreateDirectory(xmlDir);
                if (File.Exists(xmlFilePathTmp))
                    File.Delete(xmlFilePathTmp);

                //创建并初始化xml文件.
                StreamWriter sw = new StreamWriter(File.Create(xmlFilePathTmp));
                sw.WriteLine(@"<?xml version=""1.0"" encoding=""utf-8"" ?>");
                sw.WriteLine("<PersonalityColorTestItems>");
                sw.WriteLine("</PersonalityColorTestItems>");
                sw.Flush();
                sw.Close();

                //读取txt为特定格式
                List<PCTItem> items = ParserTxt(txtPath);

                //写入xml文件
                if (items.Count > 0)
                    WriteXML(xmlFilePathTmp, items);

                xmlFilePath = xmlFilePathTmp;
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }

            return xmlFilePath;
        }

        /// <summary>
        /// 解析txt文本为Item项集合
        /// </summary>
        /// <param name="txtPath"></param>
        /// <returns></returns>
        private List<PCTItem> ParserTxt(string txtPath)
        {
            List<PCTItem> items = new List<PCTItem>();

            /*
            //测试数据
            items.Add(new PCTItem() { Title = "1111", OptionA = "qqqq", OptionB = "eeee", OptionC = "rrr", OptionD = "ddd" });
            items.Add(new PCTItem() { Title = "1111", OptionA = "qqqq", OptionB = "eeee", OptionC = "rrr", OptionD = "ddd" });
            items.Add(new PCTItem() { Title = "1111", OptionA = "qqqq", OptionB = "eeee", OptionC = "rrr", OptionD = "ddd" });
             */

            int count = 0;
            PCTItem pctItemTmp = new PCTItem();
            string readStr = string.Empty;
            StreamReader sr = new StreamReader(File.Open(txtPath, FileMode.Open), Encoding.Default);

            //每一个选项读取5行txt内容，不包含空白行。内容顺序为：标题-选项A-选项B-选项C-选项D.
            while ((readStr = sr.ReadLine()) != null)
            {
                if (!string.IsNullOrEmpty(readStr)) //空白行读取内容为""，空的。
                {
                    count++;
                    switch (count)
                    {
                        case 1:
                            pctItemTmp.Title = readStr;
                            break;
                        case 2:
                            pctItemTmp.OptionA = readStr;
                            break;
                        case 3:
                            pctItemTmp.OptionB = readStr;
                            break;
                        case 4:
                            pctItemTmp.OptionC = readStr;
                            break;
                        case 5:
                            pctItemTmp.OptionD = readStr;
                            break;
                    }

                    if (count == 5) //完成一个5行内容读取。
                    {
                        count = 0;
                        items.Add(pctItemTmp);
                        pctItemTmp = new PCTItem();
                    }
                }
            }

            return items;
        }

        /// <summary>
        /// 写入XML文件内容
        /// </summary>
        /// <param name="xmlFilePath"></param>
        /// <param name="items"></param>
        private void WriteXML(string xmlFilePath, List<PCTItem> items)
        {
            XmlDocument xmlDoc = new XmlDocument();
            xmlDoc.Load(xmlFilePath);
            XmlNode root = xmlDoc.SelectSingleNode("PersonalityColorTestItems");//查找<PersonalityColorTestItems>

            foreach (PCTItem item in items)
            {
                //选项Node
                XmlElement childNode = xmlDoc.CreateElement("PersonalityColorTestItem");//创建一个<PersonalityColorTestItem>节点
                //选项标题
                XmlElement Title = xmlDoc.CreateElement("Title");
                Title.InnerText = item.Title;
                //4个选项
                XmlElement OptionA = xmlDoc.CreateElement("OptionA");//添加一个名字为OptionA的子节点
                OptionA.InnerText = item.OptionA;//设置文本
                XmlElement OptionB = xmlDoc.CreateElement("OptionB");
                OptionB.InnerText = item.OptionB;
                XmlElement OptionC = xmlDoc.CreateElement("OptionC");
                OptionC.InnerText = item.OptionC;
                XmlElement OptionD = xmlDoc.CreateElement("OptionD");
                OptionD.InnerText = item.OptionD;

                childNode.AppendChild(Title);
                childNode.AppendChild(OptionA);//把OptionA添加到<PersonalityColorTestItem>节点中
                childNode.AppendChild(OptionB);
                childNode.AppendChild(OptionC);
                childNode.AppendChild(OptionD);

                root.AppendChild(childNode);
            }

            xmlDoc.Save(xmlFilePath);
        }
    }
}
