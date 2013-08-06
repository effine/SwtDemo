package com.verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CLabelDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		final Shell shell = new Shell(display);

		// -----------code start --------------------

		shell.setLayout(new FillLayout());
		CLabel clabel = new CLabel(shell, SWT.NONE);
		clabel.setText("Eclipse从入门到精通");
		clabel.setImage(new Image(display, "icons/simple.gif"));

		/*
		 * Color[] colors = { display.getSystemColor(SWT.COLOR_GREEN),
		 * display.getSystemColor(SWT.COLOR_RED),
		 * display.getSystemColor(SWT.COLOR_BLUE) };
		 * 
		 * int[] percents = { 25, 100 }; clabel.setBackground(colors, percents);
		 */

		clabel.setBackground(
				new Color[] { display.getSystemColor(SWT.COLOR_RED),
						display.getSystemColor(SWT.COLOR_GREEN),
						display.getSystemColor(SWT.COLOR_WHITE) }, new int[] {
						25, 50 });

		// -----------code end --------------------
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
