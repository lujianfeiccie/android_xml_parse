package com.example.xmlparse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

/*
版权所有：版权所有(C)2013，固派软件
文件名称：com.example.xmlparse.PullMethod.java
系统编号：
系统名称：xmlparse
模块编号：
模块名称：
设计文档：
创建日期：2013-12-3 下午11:38:33
作 者：陆键霏
内容摘要：
类中的代码包括三个区段：类变量区、类属性区、类方法区。
文件调用:
 */
public class PullMethod {
	private List<Student> students=null;
	private Student student=null;
	public List<Student> getStudents(InputStream inputStream) throws Exception {
		  XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();  
          XmlPullParser xmlPullParser = pullFactory.newPullParser();  
//        //方式二:使用Android提供的实用工具类android.util.Xml  
//        XmlPullParser xmlPullParser = Xml.newPullParser();  
          xmlPullParser.setInput(inputStream, "UTF-8");  
		return parse(xmlPullParser);
	}
	/** 
     *  
     * @param element 将要进行遍历的节点 
	 * @throws XmlPullParserException 
	 * @throws IOException 
     */  
    private List<Student> parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {  
        int eventType = xmlPullParser.getEventType();  
        boolean isDone = false;//可以控制中断,这样就可以不需要读取完也能出来了 
        String TagName = null;  
        String TagValue = null; 
    	//具体解析xml  
        while ((eventType != XmlPullParser.END_DOCUMENT)&&(isDone != true)) {  
            
            switch (eventType) {  
                case XmlPullParser.START_DOCUMENT:  
                {  
                	students = new ArrayList<Student>();  
                }  
                    break;  
                case XmlPullParser.START_TAG:  
                {  
                	TagName = xmlPullParser.getName();
                    if (TagName.equals("Student")) { 
                    	student = new Student();  
                    }else if(TagName.equals("School")){
                    	
                    }else{
                    	TagValue = xmlPullParser.nextText();
	                    if(TagName.equals("Name")){
	                    	student.setName(TagValue);
	                    }
	                    else if(TagName.equals("Num")){
	                    	student.setNum(TagValue);
	                    }
	                    else if(TagName.equals("Classes")){
	                    	student.setClasses(TagValue);
	                    }
	                    else if(TagName.equals("Address")){
	                    	student.setAddress(TagValue);
	                    }
	                    else if(TagName.equals("Tel")){
	                    	student.setTel(TagValue);
	                    }
                    }
                    log("START_TAG="+TagName+" TagValue="+TagValue);
                }  
                    break;  
                case XmlPullParser.END_TAG:  
                {  
                	TagName = xmlPullParser.getName();  
                    if((TagName.equals("Student")))  
                    {  
                    	students.add(student);  
                    }
                    log("END_TAG="+TagName);
                }  
                    break;  
                default:  
                    break;  
                }  
            eventType = xmlPullParser.next();  
        }
        return students;
	}
    void log(String msg){
    	Log.d(getClass().getSimpleName(), msg);
    }
}


