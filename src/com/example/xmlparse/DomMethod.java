package com.example.xmlparse;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.util.Log;

/*
��Ȩ���У���Ȩ����(C)2013���������
�ļ����ƣ�com.example.xmlparse.DomMethod.java
ϵͳ��ţ�
ϵͳ���ƣ�xmlparse
ģ���ţ�
ģ�����ƣ�
����ĵ���
�������ڣ�2013-12-3 ����9:19:39
�� �ߣ�½����
����ժҪ��
���еĴ�������������Σ���������������������෽������
�ļ�����:
 */
public class DomMethod {
	private List<Student> students=null;
	private Student student=null;
	public List<Student> getStudents(InputStream inputStream) throws Exception {
		students = new ArrayList<Student>();
		StringBuilder sb = new StringBuilder();
		   DocumentBuilderFactory factory = DocumentBuilderFactory  
                   .newInstance();  
           DocumentBuilder builder = factory.newDocumentBuilder();  
           Document document = builder.parse(inputStream);  
           // ��ȡ���ڵ�  
           Element root = document.getDocumentElement();
           //��ʼ����
           parse(root);  
		return students;
	}
	/** 
     *  
     * @param element ��Ҫ���б����Ľڵ� 
     */  
    private void parse(Element element) {  
        NodeList nodelist = element.getChildNodes();  
        int size = nodelist.getLength();
        //students.clear();
        for (int i = 0; i < size; i++) {  
            // ��ȡ�ض�λ�õ�node  
            Node element2 = (Node) nodelist.item(i);  
            /* getNodeName��ȡtagName������<book>thinking in android</book>���Element��getNodeName����book 
             * getNodeType���ص�ǰ�ڵ��ȷ�����ͣ���Element��Attr��Text�� 
             * getNodeValue ���ؽڵ����ݣ������ǰΪText�ڵ㣬�򷵻��ı����ݣ�����᷵��null 
             * getTextContent ���ص�ǰ�ڵ��Լ����Ӵ��ڵ���ı��ַ�������Щ�ַ�����ƴ��һ���ַ������û����ء����� 
             * ��<book><name>thinking in android</name><price>12.23</price></book>���ô˷�������᷵�ء�thinking in android12.23�� 
             */  
            String tagName = element2.getNodeName();  
            String tagValue = element2.getTextContent();
            if (tagName.equals("Student")  
                    && element2.getNodeType() == Document.ELEMENT_NODE) {  
            	student = new Student();  
                if (element2.getNodeType() == Document.ELEMENT_NODE) {  
                    parse((Element) element2);  
                }  
                students.add(student);  
            }  
  
            if (tagName.equals("Name")) {  
                student.setName(tagValue);  
            }  
            if (tagName.equals("Num")) {  
                student.setNum(tagValue);  
            }  
            if (tagName.equals("Classes")) {  
            	student.setClasses(tagValue);  
            }  
            if (tagName.equals("Address")) {  
            	student.setAddress(tagValue);  
            }  
            if (tagName.equals("Tel")) {  
            	student.setAddress(tagValue);  
            }  
      }  
    }  
}


