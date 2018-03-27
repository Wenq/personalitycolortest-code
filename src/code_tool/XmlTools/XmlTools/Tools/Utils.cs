using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace XmlTools
{
    public class Utils
    {
        /// <summary>
        /// 打开目录并选中文件
        /// </summary>
        /// <param name="file"></param>
        public static void Open(string file)
        {
            //打开选中的文件夹并指向选中的文件
            System.Diagnostics.Process.Start("explorer.exe", "/select," + file);


            //引用：using System.Diagnostics;
            //打开文件夹：
            //使用c#打开文件（夹）及选中文件 System.Diagnostics.Process.Start(FilePath);
            //打开文件夹中某个文件：
            //使用c#打开文件（夹）及选中文件 System.Diagnostics.Process.Start(FilePath+"/"+FileName);
            //打开文件夹并选中单个文件：
            //使用c#打开文件（夹）及选中文件 System.Diagnostics.Process.Start("Explorer", "/select,"+ FilePath+"//"+FileName);
            //使用c#打开文件（夹）及选中文件 System.Diagnostics.Process.Start("Explorer.exe", "/select,"+ FilePath+"//"+FileName);

            //用IE打开文件:
            //使用c#打开文件（夹）及选中文件 System.Diagnostics.Process.Start("Explorer",FilePath+"//"+FileName);
            //使用c#打开文件（夹）及选中文件 System.Diagnostics.Process.Start("Explorer.exe",FilePath+"//"+FileName);
            //注：（explorer,explorer.exe,select,不区分大小写,"/selecet,"其中"/,"都不能少,FilePath为文件路径不包含文件名)
            //注意：filepath中的路径格式应该用“//”，不能用“/”，不然会出现“the path does not exist or is not a directory”的错误。
            //例："D://dennis//Dennis//learning//asp.net//trainning//convertDell//text//sta//text.sta"正确
            //"D:/dennis/Dennis/learning/asp.net/trainning/convertDell/text/sta/text.sta" 错误
        }

        /// <summary>
        /// 获取程序启动目录
        /// </summary>
        /// <returns></returns>
        public static string GetExeStartPath()
        {
            return System.Windows.Forms.Application.StartupPath;
        }
    }
}
