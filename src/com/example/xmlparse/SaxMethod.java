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
��Ȩ���У���Ȩ����(C)2013���������
�ļ����ƣ�com.example.xmlparse.SaxMethod.java
ϵͳ��ţ�
ϵͳ���ƣ�xmlparse
ģ���ţ�
ģ�����ƣ�
����ĵ���
�������ڣ�2013-12-3 ����8:51:18
�� �ߣ�½����
����ժҪ��
���еĴ�������������Σ���������������������෽������
�ļ�����:
 */
public class SaxMethod extends DefaultHandler{
	private List<Student> students=null;
	private Student student=null;
	private String preTag = null; // ��¼�����ϸ��ڵ��ֵ
	
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
		System.out.println("��ȡ"+preTag+"�ڵ����");
		preTag = null;
	}

	/**
	 * ��SAX����������xml�� <?.. ��ʼ�˷���
	 */
	@Override
	public void startDocument() throws SAXException {
		students = new ArrayList<Student>();
		System.out.println("��ʼ����");
	}

	/**
	 * �����ڵ�ʱ ��ʼ�˷���
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("Student".equals(preTag)){
			student = new Student();
		}
		preTag = qName;
		System.out.println("��ʼ��ȡ"+preTag+"�ڵ�");
	}
	public List<Student> getStudents() {
		return students;
	}
}


