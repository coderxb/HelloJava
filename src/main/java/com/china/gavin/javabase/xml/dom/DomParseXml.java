package com.china.gavin.javabase.xml.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParseXml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 得到DOM解析器的工厂实例
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// 从DOM工厂中获得DOM解析器
		DocumentBuilder dbBuilder;
		try {
			dbBuilder = dbFactory.newDocumentBuilder();
			// 声明为File为了识别中文名
			Document doc = null;
			// doc = dbBuilder
			// .parse("D:/workspace/HelloJava/src/main/java/resource/test.xml");
			// doc = dbBuilder.parse(DomParseXml.class.getClassLoader()
			// .getResourceAsStream("resource/test.xml"));
			doc = dbBuilder.parse(DomParseXml.class
					.getResourceAsStream("/resource/test.xml"));
			// 得到文档名称为Student的元素的节点列表
			NodeList list = doc.getElementsByTagName("disk");
			// 遍历该集合，显示结合中的元素及其子元素的名字
			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				String name = element.getAttribute("name");
				String capacity = element.getElementsByTagName("capacity")
						.item(0).getFirstChild().getNodeValue();
				String directories = element
						.getElementsByTagName("directories").item(0)
						.getFirstChild().getNodeValue();
				String files = element.getElementsByTagName("files").item(0)
						.getFirstChild().getNodeValue();
				System.out.println("磁盘信息:");
				System.out.println("分区盘符:" + name);
				System.out.println("分区容量:" + capacity);
				System.out.println("目录数:" + directories);
				System.out.println("文件数:" + files);
				System.out.println("-----------------------------------");
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
