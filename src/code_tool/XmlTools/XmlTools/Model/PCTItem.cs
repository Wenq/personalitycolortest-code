using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace XmlTools.Model
{
    /// <summary>
    /// 表示一个测试题选项
    /// </summary>
    public class PCTItem
    {
        /*
        1 选项题目：
        A xxxxx
        B xxxxx
        C xxxxx
        D xxxxx
         */

        /// <summary>
        /// 标题
        /// </summary>
        public string Title
        {
            get;
            set;
        }

        /// <summary>
        /// 选项A
        /// </summary>
        public string OptionA
        {
            get;
            set;
        }

        /// <summary>
        /// 选项B
        /// </summary>
        public string OptionB
        {
            get;
            set;
        }

        /// <summary>
        /// 选项C
        /// </summary>
        public string OptionC
        {
            get;
            set;
        }

        /// <summary>
        /// 选项D
        /// </summary>
        public string OptionD
        {
            get;
            set;
        }
    }
}
