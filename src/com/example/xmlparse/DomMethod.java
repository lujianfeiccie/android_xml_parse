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
版权所有：版权所有(C)2013，固派软件
文件名称：com.example.xmlparse.DomMethod.java
系统编号：
系统名称：xmlparse
模块编号：
模块名称：
设计文档：
创建日期：2013-12-3 下午9:19:39
作 者：陆键霏
内容摘要：
类中的代码包括三个区段：类变量区、类属性区、类方法区。
文件调用:
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
           // 获取根节点  
           Element root = document.getDocumentElement();
           //开始解析
           parse(root);  
		return students;
	}
	/** 
     *  
     * @param element 将要进行遍历的节点 
     */  
    private void parse(Element element) {  
        NodeList nodelist = element.getChildNodes();  
        int size = nodelist.getLength();
        //students.clear();
        for (int i = 0; i < size; i++) {  
            // 获取特定位置的node  
            Node element2 = (Node) nodelist.item(i);  
            /* getNodeName获取tagName，例如<book>thinking in android</book>这个Element的getNodeName返回book 
             * getNodeType返回当前节点的确切类型，如Element、Attr、Text等 
             * getNodeValue 返回节点内容，如果当前为Text节点，则返回文本内容；否则会返回null 
             * getTextContent 返回当前节点以及其子代节点的文本字符串，这些字符串会拼成一个字符串给用户返回。例如 
             * 对<book><name>thinking in android</name><price>12.23</price></book>调用此方法，则会返回“thinking in android12.23” 
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


