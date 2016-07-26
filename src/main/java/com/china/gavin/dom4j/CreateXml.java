package com.china.gavin.dom4j;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class CreateXml {

	/*
	 * @param filename NewXml
	 * 
	 * @param 创建XML文件
	 * 
	 * @return 返回操作结果, 0表失败, 1表成功
	 */

	public int createXMLFile(String filename) {
		/** 返回操作结果, 0表失败, 1表成功 */
		int returnValue = 0;
		/** 建立document对象 */
		Document document = DocumentHelper.createDocument();
		/** 建立XML文档的根books */
		Element booksElement = document.addElement("books");
		/** 加入一行注释 */
		booksElement.addComment("This is a test for dom4j, holen,2004.9.11");
		/** 加入第一个book节点 */
		Element bookElement = booksElement.addElement("book");
		/** 加入show属性内容 */
		bookElement.addAttribute("show", "yes");
		/** 加入title节点 */
		Element titleElement = bookElement.addElement("title");
		/** 为title设置内容 */
		titleElement.setText("Dom4j Tutorials");
		/** 类似的完成后两个book */
		bookElement = booksElement.addElement("book");
		bookElement.addAttribute("show", "yes");
		titleElement = bookElement.addElement("title");
		titleElement.setText("Lucene Studing");
		bookElement = booksElement.addElement("book");
		bookElement.addAttribute("show", "no");
		titleElement = bookElement.addElement("title");
		titleElement.setText("Lucene in Action");
		/** 加入owner节点 */
		Element ownerElement = booksElement.addElement("owner");
		ownerElement.setText("O'Reilly");

		try {
			/** 设置xml文件创建时的格式化方式 */
			OutputFormat format = OutputFormat.createPrettyPrint();
			/** 设置xml文件的编码方式 */
			format.setEncoding("UTF-8");
			/** 将document中的内容写入文件中 */
			XMLWriter writer = new XMLWriter(
					new FileWriter(new File(filename)), format);
			writer.write(document);
			writer.close();
			/** 执行成功,需返回1 */
			returnValue = 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}

	public static void main(String[] args) {
		CreateXml create = new CreateXml();
		create.createXMLFile("newXml.xml");
		System.out.println("成功生成xml文件");
	}
}
