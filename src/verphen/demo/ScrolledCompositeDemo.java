/**
 * @author  arno
 * @version	 2013-6-25  ÏÂÎç01:40:43
 */

package verphen.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;

public class ScrolledCompositeDemo {
	private static Text text;
	private static Text text_1;
	private static Text text_2;
	private static Text text_3;
	private static Text text_4;
	private static Text text_5;
	private static Text text_6;
	private static Text text_7;
	private static Text text_8;
	private static Text text_9;

	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(499, 469);
		shell.setText("hello world !");

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(10, 0, 473, 431);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Composite composite = new Composite(scrolledComposite, SWT.NONE);

		text = new Text(composite, SWT.BORDER);
		text.setBounds(126, 130, 73, 23);

		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(126, 79, 73, 23);

		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(126, 346, 73, 23);

		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBounds(126, 183, 73, 23);

		text_4 = new Text(composite, SWT.BORDER);
		text_4.setBounds(126, 234, 73, 23);

		text_5 = new Text(composite, SWT.BORDER);
		text_5.setBounds(126, 296, 73, 23);

		text_6 = new Text(composite, SWT.BORDER);
		text_6.setBounds(126, 325, 73, 23);

		text_7 = new Text(composite, SWT.BORDER);
		text_7.setBounds(126, 376, 73, 23);

		text_8 = new Text(composite, SWT.BORDER);
		text_8.setBounds(126, 438, 73, 23);

		text_9 = new Text(composite, SWT.BORDER);
		text_9.setBounds(126, 488, 73, 23);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));

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
