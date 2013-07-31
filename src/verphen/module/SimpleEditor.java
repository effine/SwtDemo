/**
 * @author  arno
 * @version	 2013-6-28  ����09:59:40
 */

package verphen.module;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

/*
 * �򵥵ı༭��
 * 
 */
public class SimpleEditor {

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		// -------------------���Ĵ��� begin ----------------------------

		shell.setLayout(new FillLayout());

		// viewForm ��Ϊ�ײ�����������FillLayout �����Ͳ���
		ViewForm viewForm = new ViewForm(shell, SWT.NONE);
		viewForm.setLayout(new FillLayout());

		// viewFotm �����д���ToolBar �� Text �ı���
		final Text text = new Text(viewForm, SWT.BORDER | SWT.WRAP
				| SWT.V_SCROLL);
		viewForm.setContent(text); // �����ı���Ϊ viewForm �������

		// �� viewForm �д���ToolBar
		ToolBar toolBar = new ToolBar(viewForm, SWT.NONE);
		ToolItem getItem = new ToolItem(toolBar, SWT.PUSH);
		getItem.setText("ȡ��");

		// ��"ȡ��" �˵���ť���ü���
		getItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String str = text.getText();
				MessageDialog.openInformation(null, null, str);
			}
		});

		ToolItem clearItem = new ToolItem(toolBar, SWT.DROP_DOWN);
		clearItem.setText("���");
		clearItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
			}
		});

		viewForm.setTopLeft(toolBar);
		// -------------------���Ĵ��� end ----------------------------

		shell.layout();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
