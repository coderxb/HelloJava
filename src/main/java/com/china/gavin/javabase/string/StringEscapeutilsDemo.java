package com.china.gavin.javabase.string;

import org.apache.commons.lang.StringEscapeUtils;

public class StringEscapeutilsDemo {

	public static void main(String[] args) {
		// escapeSql 提供sql转移功能，防止sql注入攻击，例如典型的万能密码攻击' ' or 1=1 ' '
		String keyWord = "ssdfdsf";
		StringBuffer sql = new StringBuffer(
				"select key_sn,remark,create_date from tb_selogon_key where 1=1 ");
		if (keyWord != null) {
			sql.append(" and like '%" + StringEscapeUtils.escapeSql(keyWord)
					+ "%'");
		}

		// escapeHtml /unescapeHtml 转义/反转义html脚本
		System.out.println(StringEscapeUtils.escapeHtml("<a>dddd</a>"));
		System.out.println(StringEscapeUtils
				.unescapeHtml("&lt;a&gt;dddd&lt;/a&gt;"));

		// escapeJavascript/unescapeJavascript 转义/反转义js脚本
		System.out.println(StringEscapeUtils
				.escapeJavaScript("<script>alert('1111')</script>"));

		// escapeJava/unescapeJava 把字符串转为unicode编码
		System.out.println(StringEscapeUtils.escapeJava("中国"));

	}
}
