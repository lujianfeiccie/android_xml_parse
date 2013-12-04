package com.example.xmlparse;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
版权所有：版权所有(C)2013，固派软件
文件名称：com.example.xmlparse.SaxMethod.java
系统编号：
系统名称：xmlparse
模块编号：
模块名称：
设计文档：
创建日期：2013-12-3 下午8:51:18
作 者：陆键霏
内容摘要：
类中的代码包括三个区段：类变量区、类属性区、类方法区。
文件调用:
 */
public class SaxMethod extends DefaultHandler{
	private List<Student> students=null;
	private Student student=null;
	private String preTag = null; // 记录解析上个节点的值
	
	public List<Student> getStudents(InputStream xmlStream) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SaxMethod handler = new SaxMethod();
		parser.parse(xmlStream, handler);
		return handler.getStudents();
	}
	public List<Student> getStudents(String xmlString) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SaxMethod handler = new SaxMethod();
		parser.parse(xmlString, handler);
		return handler.getStudents();
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (preTag != null) {
			String content = new String(ch, start, length);
			if ("Name".equals(preTag)) {
				student.setName(content);
			} else if ("Num".equals(preTag)) {
				student.setNum(content);
			} else if ("Classes".equals(preTag)) {
				student.setClasses(content);
			} else if ("Address".equals(preTag)) {
				student.setAddress(content);
			} else if ("Tel".equals(preTag)) {
				student.setTel(content);
			}
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("Student".equals(qName)) {
			students.add(student);
			student = null;
		}
		System.out.println("读取"+preTag+"节点结束");
		preTag = null;
	}

	/**
	 * 当SAX解析器读到xml的 <?.. 开始此方法
	 */
	@Override
	public void startDocument() throws SAXException {
		students = new ArrayList<Student>();
		System.out.println("开始解析");
	}

	/**
	 * 读到节点时 开始此方法
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("Student".equals(preTag)){
			student = new Student();
		}
		preTag = qName;
		System.out.println("开始读取"+preTag+"节点");
	}
	public List<Student> getStudents() {
		return students;
	}
}


