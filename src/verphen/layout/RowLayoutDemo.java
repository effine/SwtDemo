/**
 * @author  arno
 * @version	 2013-6-26  ����09:51:36
 */

package verphen.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import verphen.util.SwtWindowAlignCenter;

/*
 *	����ʽ���ֹ����� 
 */

public class RowLayoutDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		// shell.setSize(300, 400);

		RowLayout layout = new RowLayout();
		// layout.type =SWT.VERTICAL; ������new FillLayout(SWT.VERTICAL)����һ��
		// layout.marginHeight = 10;
		// layout.marginWidth = 30;
		// layout.spacing = 20;

		/*
		 * layout.wrap = false; �����Զ����У�Ĭ��Ϊtrue���Զ����У�
		 * 
		 * layout.pack = false;pack��������Ĵ�С��false��ʾ�����С��ͬ��Ĭ��Ϊtrue
		 * 
		 * layout.justify = true;	justify ��������������ռ����� ��true��ʾ�����죬Ĭ��Ϊfalse
		 */

		

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
