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
��Ȩ���У���Ȩ����(C)2013���������
�ļ����ƣ�com.example.xmlparse.PullMethod.java
ϵͳ��ţ�
ϵͳ���ƣ�xmlparse
ģ���ţ�
ģ�����ƣ�
����ĵ���
�������ڣ�2013-12-3 ����11:38:33
�� �ߣ�½����
����ժҪ��
���еĴ�������������Σ���������������������෽������
�ļ�����:
 */
public class PullMethod {
	private List<Student> students=null;
	private Student student=null;
	public List<Student> getStudents(InputStream inputStream) throws Exception {
		  XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();  
          XmlPullParser xmlPullParser = pullFactory.newPullParser();  
//        //��ʽ��:ʹ��Android�ṩ��ʵ�ù�����android.util.Xml  
//        XmlPullParser xmlPullParser = Xml.newPullParser();  
          xmlPullParser.setInput(inputStream, "UTF-8");  
		return parse(xmlPullParser);
	}
	/** 
     *  
     * @param element ��Ҫ���б����Ľڵ� 
	 * @throws XmlPullParserException 
	 * @throws IOException 
     */  
    private List<Student> parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {  
        int eventType = xmlPullParser.getEventType();  
        boolean isDone = false;//���Կ����ж�,�����Ϳ��Բ���Ҫ��ȡ��Ҳ�ܳ����� 
        String TagName = null;  
        String TagValue = null; 
    	//�������xml  
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


