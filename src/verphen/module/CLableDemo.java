/**
 * @author Verphen
 * @date 2013年7月25日  下午5:50:12
 */

package verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CLableDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		final Shell shell = new Shell(display);

		// -----------code start --------------------

		shell.setLayout(new FillLayout());
		CLabel clabel = new CLabel(shell, SWT.NONE);
		clabel.setText("Eclipse从入门到精通");
		clabel.setImage(new Image(display, "icons/simple.gif"));

		Color[] colors = { display.getSystemColor(SWT.COLOR_GREEN),
				display.getSystemColor(SWT.COLOR_RED),
				display.getSystemColor(SWT.COLOR_BLUE) };

		int[] percents = { 30, 100 };
		clabel.setBackground(colors, percents);

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
