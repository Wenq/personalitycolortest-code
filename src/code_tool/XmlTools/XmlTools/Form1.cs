using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace XmlTools
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void btnSelect_Click(object sender, EventArgs e)
        {
            //选择要转为xml文件的txt文本
            using (OpenFileDialog openDialog = new OpenFileDialog())
            {
                openDialog.Filter = "*.txt|*.txt";
                openDialog.Title = "Select File";
                openDialog.Multiselect = false;

                openDialog.ShowDialog(this);
                if (openDialog.FileNames.Length > 0)
                {
                    txtFilePath.Text = openDialog.FileName;
                }
            }
        }

        private void btnGenerate_Click(object sender, EventArgs e)
        {
            //根据txt文本内容及一定格式处理方式
            //将txt转换为xml文件
            string filePath = txtFilePath.Text.Trim();
            if (!string.IsNullOrEmpty(filePath) && File.Exists(filePath))
            {
                IXmlGenerate xml = new XmlGenerate1();
                string temp = xml.GenerateXml(filePath, "PersonalityColorTestItems");
                Utils.Open(temp);

                this.Close();
            }
        }
    }
}
