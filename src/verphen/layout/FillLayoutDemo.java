/**
 * @author  arno
 * @version	 2013-6-26  上午09:32:59
 */

package verphen.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import verphen.util.SwtWindowAlignCenter;

/*
 * 充满式布局管理器
 */
public class FillLayoutDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(300, 400);

		FillLayout layout = new FillLayout(SWT.VERTICAL);
		// layout.type =SWT.VERTICAL; 和上面new FillLayout(SWT.VERTICAL)作用一样
		layout.marginHeight = 10;
		layout.marginWidth = 30;
		layout.spacing = 20;

		shell.setLayout(layout);
		SwtWindowAlignCenter.setCenter(shell);
		new Button(shell, SWT.NONE).setText("确定");
		new Button(shell, SWT.NONE).setText("取消");
		new Button(shell, SWT.NONE).setText("帮助");

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
