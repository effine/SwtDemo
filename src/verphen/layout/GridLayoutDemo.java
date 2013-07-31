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
		 * 对构造方法中的两个参数进行设置
		 */
		layout.numColumns = 3;
		layout.makeColumnsEqualWidth = false;

		layout.horizontalSpacing = 30;
		layout.verticalSpacing = 20;

		shell.setLayout(layout);

		SwtWindowAlignCenter.setCenter(shell);
		new Button(shell, SWT.NONE).setText("确定");
		new Button(shell, SWT.NONE).setText("取     消");
		new Button(shell, SWT.NONE).setText("帮助");
		new Button(shell, SWT.NONE).setText("帮  助");
		new Button(shell, SWT.NONE).setText("帮助");
		new Button(shell, SWT.NONE).setText("帮              助");

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
