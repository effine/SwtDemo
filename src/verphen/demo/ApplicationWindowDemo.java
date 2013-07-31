/**
 * @author  arno
 * @version	 2013-6-25  下午03:05:37
 */

package verphen.demo;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ApplicationWindowDemo extends ApplicationWindow {

	public ApplicationWindowDemo(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.ON_TOP);
	}

	public static void main(String[] args) {

		new ApplicationWindowDemo(null).run();

	}

	public void run() {
		setBlockOnOpen(true); // true 指在程序执行open方法时，程序暂停往下执行
		open();
		Display.getCurrent().dispose();
	}

	// 覆盖来自父类的方法，在其中创建窗口中的组件
	protected Control createContents(Composite parent) {

		getShell().setText("ApplicationWindow窗口");
		parent.setSize(200, 100);
		Label label = new Label(parent, SWT.CENTER);
		label.setText("hello ,大家好");
		return parent;
	}
}
