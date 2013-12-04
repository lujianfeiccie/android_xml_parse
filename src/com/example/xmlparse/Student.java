package com.example.xmlparse;

/*
版权所有：版权所有(C)2013，固派软件
文件名称：com.example.xmlparse.Student.java
系统编号：
系统名称：xmlparse
模块编号：
模块名称：
设计文档：
创建日期：2013-12-3 下午8:51:47
作 者：陆键霏
内容摘要：
类中的代码包括三个区段：类变量区、类属性区、类方法区。
文件调用:
 */
public class Student {
	private String num;
	private String name;
	private String classes;
	private String address;
	private String tel;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return this.name+":"+this.num+":"+this.classes+":"+this.address+":"+this.tel;
	}
}
