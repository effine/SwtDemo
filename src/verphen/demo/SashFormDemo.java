/**
 * @author  arno
 * @version	 2013-6-25  ÏÂÎç12:56:16
 */

package verphen.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SashFormDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(327, 354);
		shell.setText("hello world !");

		SashForm sashForm = new SashForm(shell, SWT.NONE);

		Text t1 = new Text(sashForm, SWT.BORDER);
		t1.setText("×ó");

		new Text(sashForm, SWT.BORDER).setText("t2");
		new Text(sashForm, SWT.BORDER).setText("t3");

		sashForm.setWeights(new int[] { 3, 1, 2 });
		sashForm.setBounds(10, 10, 500, 500);

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
