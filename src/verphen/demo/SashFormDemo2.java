/**
 * @author  arno
 * @version	 2013-6-25  обнГ01:28:45
 */

package verphen.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SashFormDemo2 {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(327, 354);
		shell.setText("hello world !");

		SashForm sashForm = new SashForm(shell, SWT.NONE);

		Text t1 = new Text(sashForm, SWT.BORDER);
		t1.setText("вС");

		SashForm rightSashForm = new SashForm(sashForm, SWT.VERTICAL);
		new Text(rightSashForm, SWT.BORDER).setText("срио");
		new Text(rightSashForm, SWT.BORDER).setText("сроб");

		sashForm.setWeights(new int[] { 1, 3 });
		rightSashForm.setWeights(new int[] { 5, 2 });
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
