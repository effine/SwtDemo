package verphen.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import verphen.util.SwtWindowAlignCenter;

public class GridLayoutDemo {

	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		GridLayout layout = new GridLayout(4, true);

		/*
		 * �Թ��췽���е�����������������
		 */
		layout.numColumns = 3;
		layout.makeColumnsEqualWidth = false;

		layout.horizontalSpacing = 30;
		layout.verticalSpacing = 20;

		shell.setLayout(layout);

		SwtWindowAlignCenter.setCenter(shell);
		new Button(shell, SWT.NONE).setText("ȷ��");
		new Button(shell, SWT.NONE).setText("ȡ     ��");
		new Button(shell, SWT.NONE).setText("����");
		new Button(shell, SWT.NONE).setText("��  ��");
		new Button(shell, SWT.NONE).setText("����");
		new Button(shell, SWT.NONE).setText("��              ��");

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
