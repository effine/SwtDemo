/**
 * @author  arno
 * @version	 2013-7-2  下午03:35:22
 */

package verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BrowerDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		// ------------------code start ------------------------

		shell.setLayout(new FillLayout());

		Browser browser = new Browser(shell, SWT.None);

		browser.setText("访问网址：<a href='http://www.baidu.com'>百度</a>");
		// browser.setUrl("http://www.baidu.com");

		// ------------------code end ------------------------
		shell.layout();
		shell.open();
		while (!shell.isDisposed()) {
			while (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
	}
}
