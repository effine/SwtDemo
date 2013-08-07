/**
 * @author Verphen
 * @date 2013年8月7日  下午3:02:11
 */

package com.verphen.cdt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * 调用exec方法，取得win32的系统命令，如 计算器 calc
 */
public class ExecCommond {

	public static void main(String[] args) {
		new ExecCommond().execTest("calc");
	}

	public void execTest(String execStr) {

		Runtime runtime = Runtime.getRuntime(); // 取得当前运行期对象

		try {
			Process proc = runtime.exec(execStr); // 启动另一个进程来执行命令
			InputStream in = proc.getErrorStream(); // 得到错误输出信息
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
