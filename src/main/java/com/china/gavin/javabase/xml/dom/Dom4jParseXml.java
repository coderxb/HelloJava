package com.china.gavin.javabase.xml.dom;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jParseXml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建文件对象
		// File file = new File("filePath/fileName");
		// 创建一个读取XML文件的对象
		SAXReader reader = new SAXReader();
		// 创建一个文档对象
		// Document document = reader.read(file);
		try {
			Document document = reader.read(Dom4jParseXml.class.getResource(
					"/resource/test.xml").getFile());

			// 获取文件的根节点
			Element element = document.getRootElement();
			for (Iterator i = element.elementIterator("disk"); i.hasNext();) {
				// 获取节点元素
				element = (Element) i.next();
				String name = element.attributeValue("name");
				String capacity = element.elementText("capacity");// 取disk子元素capacity的内容
				String directories = element.elementText("directories");
				String files = element.elementText("files");
				System.out.println("磁盘信息:");
				System.out.println("分区盘符:" + name);
				System.out.println("分区容量:" + capacity);
				System.out.println("目录数:" + directories);
				System.out.println("文件数:" + files);
				System.out.println("-----------------------------------");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
