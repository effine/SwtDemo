package com.verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class StyledTextDemo {

	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		// -------------------code start ----------------

		shell.setLayout(new FillLayout());

		StyledText text = new StyledText(shell, SWT.WRAP | SWT.BORDER);

		text.setText("你好，这里是Eclipse!");

		// -------------------code end ----------------
		shell.layout();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}
}
