/**
 * @author Verphen
 * @date 2013��8��7��  ����3:02:11
 */

package com.verphen.cdt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * ����exec������ȡ��win32��ϵͳ����� ������ calc
 */
public class ExecCommond {

	public static void main(String[] args) {
		new ExecCommond().execTest("calc");
	}

	public void execTest(String execStr) {

		Runtime runtime = Runtime.getRuntime(); // ȡ�õ�ǰ�����ڶ���

		try {
			Process proc = runtime.exec(execStr); // ������һ��������ִ������
			InputStream in = proc.getErrorStream(); // �õ����������Ϣ
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
