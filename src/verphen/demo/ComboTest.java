/**
 * @author  arno
 * @version	 2013-6-25  上午10:55:23
 */

package verphen.demo;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import verphen.util.SwtWindowAlignCenter;

public class ComboTest {

	public static void main(String[] args) {

		Display display = Display.getDefault();
		final Shell shell = new Shell(display);

		shell.setSize(327, 354);
		shell.setText("hello world !");
		new SwtWindowAlignCenter().setCenter(shell);

		// ----------------SWT 代码区 -------------------

		final Combo combo = new Combo(shell, SWT.None);
		combo.setBounds(16, 10, 100, 25);

		Button setButton = new Button(shell, SWT.NONE);
		setButton.setBounds(17, 65, 100, 25);
		setButton.setText("设值");
		setButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				combo.removeAll(); // 清空combo
				combo.add("数学");// 往combo中添加值
				combo.add("语文");
				combo.add("政治");
				combo.add("物理");

				combo.setData("数学", "sx");
				combo.setData("语文", "yw");
				combo.setData("政治", "zz");
				combo.setData("物理", "wl");

				combo.select(3); // 设置默认值
			}
		});

		Button getButton = new Button(shell, SWT.NONE);
		getButton.setBounds(136, 66, 100, 25);
		getButton.setText("获值");

		getButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				String str = combo.getText();
				String data = (String) combo.getData(str);

				MessageDialog.openInformation(null, null, str + "  " + data);

			}
		});

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
