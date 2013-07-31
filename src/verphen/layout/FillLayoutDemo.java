/**
 * @author  arno
 * @version	 2013-6-26  ����09:32:59
 */

package verphen.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import verphen.util.SwtWindowAlignCenter;

/*
 * ����ʽ���ֹ�����
 */
public class FillLayoutDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(300, 400);

		FillLayout layout = new FillLayout(SWT.VERTICAL);
		// layout.type =SWT.VERTICAL; ������new FillLayout(SWT.VERTICAL)����һ��
		layout.marginHeight = 10;
		layout.marginWidth = 30;
		layout.spacing = 20;

		shell.setLayout(layout);
		SwtWindowAlignCenter.setCenter(shell);
		new Button(shell, SWT.NONE).setText("ȷ��");
		new Button(shell, SWT.NONE).setText("ȡ��");
		new Button(shell, SWT.NONE).setText("����");

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
