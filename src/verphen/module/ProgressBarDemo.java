/**
 * @author  arno
 * @version	 2013-7-1  ����10:51:52
 */

package verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/*
 *��������ʾ��ProgressBar
 *
 *���⻹��һ�ֶԻ���progressmonitorDialog,��ʾ����ִ�н��ȵĹ��ܣ���JFace����
 * 
 */
public class ProgressBarDemo {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		// ------------------code start ------------------------

		shell.setLayout(new RowLayout());

		// ����һ����������ʹ�õ���ƽ����ʽSWT.SMOOTH,Ĭ���Ƿ�����

		final ProgressBar progressBar = new ProgressBar(shell, SWT.SMOOTH);
		// final ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);

		// ����һ��go��ť
		Button button = new Button(shell, SWT.NONE);
		button.setText("GO");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				for (int i = 1; i < 11; i++) { // ÿ��ѭ��������ǰ��һ��ͬʱͣ��һ��
					progressBar.setSelection(i * 10);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		// ------------------code end ------------------------
		shell.layout();
		shell.open();
		while (!shell.isDisposed()) {
			while (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}
}
