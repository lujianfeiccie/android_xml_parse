package com.example.xmlparse;

/*
��Ȩ���У���Ȩ����(C)2013���������
�ļ����ƣ�com.example.xmlparse.Student.java
ϵͳ��ţ�
ϵͳ���ƣ�xmlparse
ģ���ţ�
ģ�����ƣ�
����ĵ���
�������ڣ�2013-12-3 ����8:51:47
�� �ߣ�½����
����ժҪ��
���еĴ�������������Σ���������������������෽������
�ļ�����:
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
