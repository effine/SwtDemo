/**
 * @author  arno
 * @version	 2013-6-25  ����03:05:37
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
		setBlockOnOpen(true); // true ָ�ڳ���ִ��open����ʱ��������ͣ����ִ��
		open();
		Display.getCurrent().dispose();
	}

	// �������Ը���ķ����������д��������е����
	protected Control createContents(Composite parent) {

		getShell().setText("ApplicationWindow����");
		parent.setSize(200, 100);
		Label label = new Label(parent, SWT.CENTER);
		label.setText("hello ,��Һ�");
		return parent;
	}
}
