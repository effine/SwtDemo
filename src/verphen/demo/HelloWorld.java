/**
 * @author  arno
 * @version	 2013-6-14  下午04:39:25
 */

package verphen.demo;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloWorld {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		final Shell shell = new Shell(display);

		shell.setSize(327, 354);
		shell.setText("hello world !");

		// ----------------SWT 代码区 -------------------

		Button button = new Button(shell, SWT.NONE);
		button.setText("按钮");
		button.setBounds(20, 100, 100, 25);

		final Button rideo1 = new Button(shell, SWT.RADIO);
		rideo1.setText("男");
		rideo1.setSelection(true);
		rideo1.setBounds(10, 10, 40, 25);

		final Button rideo2 = new Button(shell, SWT.RADIO);
		rideo2.setText("女");
		rideo2.setBounds(10, 30, 40, 25);

		final Button checkBox1 = new Button(shell, SWT.CHECK);
		checkBox1.setText("跑步");
		checkBox1.setBounds(70, 10, 40, 25);

		final Button checkBox2 = new Button(shell, SWT.CHECK);
		checkBox2.setText("旅游");
		checkBox2.setBounds(70, 30, 40, 25);

		button.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {

				Button b = (Button) event.getSource();

				String name = "小明， ";
				if (rideo1.getSelection()) {
					name += rideo1.getText();
				}

				if (rideo2.getSelection()) {
					name += rideo2.getText();
				}

				if (checkBox1.getSelection()) {
					name += ", " + checkBox1.getText();
				}

				if (checkBox2.getSelection()) {
					name += ", " + checkBox2.getText();
				}

				MessageDialog.openInformation(shell, "弹框", name);

			}

		});

		final Text text = new Text(shell, SWT.V_SCROLL | SWT.H_SCROLL
				| SWT.MULTI);
		// text.setText("测试");
		text.setBounds(30, 150, 150, 150);

		// text.setTextLimit(10);

		text.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				String str = e.text;

				text.setEchoChar('*');
				/*
				 * if (str.length() > 0) { e.doit = NumberUtils.isDigits(str); }
				 */
			}
		});

		/*
		 * 按钮的单击事件
		 * 
		 * button.addSelectionListener(new SelectionAdapter() { public void
		 * widgetSelected(SelectionEvent e) {
		 * MessageDialog.openInformation(shell, "弹出框Dialog", "弹出框信息，你好！"); } });
		 */

		/*
		 * 给按钮添加普通的 事件监听
		 * 
		 * Listener listener = new Listener() { public void handleEvent(Event e)
		 * { if (e.type == SWT.Selection) { System.out.println(" 单击"); } if
		 * (e.type == SWT.MouseEnter) { System.out.println("鼠标进入"); } } };
		 * button.addListener(SWT.Selection, listener);
		 * button.addListener(SWT.MouseEnter, listener);
		 */

		// ---------------SWT 代码结束 -------------------
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
