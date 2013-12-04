package com.example.xmlparse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	TextView txt_xmltext,txt_result;
	Button bt_sax_parse,bt_dom_parse,bt_pull_parse;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txt_xmltext = (TextView)findViewById(R.id.txt_xmltext);
		txt_result =  (TextView)findViewById(R.id.txt_result);
		bt_sax_parse = (Button)findViewById(R.id.bt_sax_parse);
		bt_dom_parse = (Button)findViewById(R.id.bt_dom_parse);
		bt_pull_parse = (Button)findViewById(R.id.bt_pull_parse);
		
		bt_sax_parse.setOnClickListener(this);
		bt_dom_parse.setOnClickListener(this);
		bt_pull_parse.setOnClickListener(this);
		
		txt_xmltext.setText(getString(getResources().openRawResource(R.raw.school)));
	}
	public static String getString(InputStream inputStream) {  
	    InputStreamReader inputStreamReader = null;  
	    try {  
	        inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
	    } catch (UnsupportedEncodingException e1) {  
	        e1.printStackTrace();  
	    }  
	    BufferedReader reader = new BufferedReader(inputStreamReader);  
	    StringBuffer sb = new StringBuffer("");  
	    String line;  
	    try {  
	        while ((line = reader.readLine()) != null) {  
	            sb.append(line);  
	            sb.append("\n");  
	        }  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    return sb.toString();  
	}  
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bt_sax_parse:
			try {
				readBySAX();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.bt_dom_parse:
			try {
				readByDOM();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.bt_pull_parse:
			try {
				readByPULL();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	public void readBySAX() throws Throwable {
		StringBuilder sb = new StringBuilder();
		try {
			SaxMethod s=new SaxMethod();
			InputStream in = getResources().openRawResource(R.raw.school); 
			List<Student> students = s.getStudents(in);
			for (Student student : students) {
				//System.out.println(student);
				sb.append(student+"\n");
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		txt_result.setText(sb.toString());
	}
	public void readByDOM() throws Throwable {
		StringBuilder sb = new StringBuilder();
		DomMethod s=new DomMethod();
		InputStream in = getResources().openRawResource(R.raw.school); 
		List<Student> students = s.getStudents(in);
		for (Student student : students) {
			//System.out.println(student);
			sb.append(student+"\n");
		}
		txt_result.setText(sb.toString());
	}
	public void readByPULL() throws Throwable {
		StringBuilder sb = new StringBuilder();
		PullMethod s=new PullMethod();
		InputStream in = getResources().openRawResource(R.raw.school); 
		List<Student> students = s.getStudents(in);
		for (Student student : students) {
			//System.out.println(student);
			sb.append(student+"\n");
		}
		txt_result.setText(sb.toString());
	}
}
