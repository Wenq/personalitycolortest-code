using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace XmlTools
{
    /// <summary>
    /// 生成xml的接口文件
    /// </summary>
    public interface IXmlGenerate
    {
        /// <summary>
        /// 
        /// </summary>
        /// <param name="txtPath">txt文本文件路径</param>
        /// <param name="xmlFileName">要生成的xml文件名称(不含路径)</param>
        /// <returns>生成的xml文件绝对路径</returns>
        string GenerateXml(string txtPath, string xmlFileName);
    }
}
