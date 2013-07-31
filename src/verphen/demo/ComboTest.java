/**
 * @author  arno
 * @version	 2013-6-25  ����10:55:23
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

		// ----------------SWT ������ -------------------

		final Combo combo = new Combo(shell, SWT.None);
		combo.setBounds(16, 10, 100, 25);

		Button setButton = new Button(shell, SWT.NONE);
		setButton.setBounds(17, 65, 100, 25);
		setButton.setText("��ֵ");
		setButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				combo.removeAll(); // ���combo
				combo.add("��ѧ");// ��combo�����ֵ
				combo.add("����");
				combo.add("����");
				combo.add("����");

				combo.setData("��ѧ", "sx");
				combo.setData("����", "yw");
				combo.setData("����", "zz");
				combo.setData("����", "wl");

				combo.select(3); // ����Ĭ��ֵ
			}
		});

		Button getButton = new Button(shell, SWT.NONE);
		getButton.setBounds(136, 66, 100, 25);
		getButton.setText("��ֵ");

		getButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				String str = combo.getText();
				String data = (String) combo.getData(str);

				MessageDialog.openInformation(null, null, str + "  " + data);

			}
		});

		// ---------------SWT ������� -------------------
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
