package com.verphen.module;

import org.eclipse.osgi.util.NLS;

public class Demo {

	public static String username;
	public static String passwd;

	static {
		NLS.initializeMessages(Demo.class.getName(), Demo.class);
	}

	public static void main(String[] args) {

		System.out.println(username + "  " + passwd);
	}
}
