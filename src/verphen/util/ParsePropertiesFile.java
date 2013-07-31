/**
 * @author Verphen
 * @date 2013年7月31日  下午5:02:35
 */

package verphen.util;

import org.eclipse.osgi.util.NLS;

public class ParsePropertiesFile extends NLS {

	public static String FILENAME;
	public static String USERNAME;

	static {
		NLS.initializeMessages(ParsePropertiesFile.class.getName(),
				ParsePropertiesFile.class);
	}

	public static void main(String[] args) {
		System.out.println(FILENAME + "     " + USERNAME);
	}

}
