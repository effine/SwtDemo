/**
 * @author  arno
 * @version	 2013-7-1  上午10:51:52
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
 *进度条演示：ProgressBar
 *
 *另外还有一种对话框：progressmonitorDialog,表示任务执行进度的功能，在JFace包中
 * 
 */
public class ProgressBarDemo {
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		// ------------------code start ------------------------

		shell.setLayout(new RowLayout());

		// 创建一个滑动条，使用的是平滑样式SWT.SMOOTH,默认是方格型

		final ProgressBar progressBar = new ProgressBar(shell, SWT.SMOOTH);
		// final ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);

		// 创建一个go按钮
		Button button = new Button(shell, SWT.NONE);
		button.setText("GO");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				for (int i = 1; i < 11; i++) { // 每次循环进度条前进一格，同时停顿一秒
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
