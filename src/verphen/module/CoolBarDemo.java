/**
 * @author  arno
 * @version	 2013-6-28  ����10:53:04
 */

package verphen.module;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class CoolBarDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		// -------------------���Ĵ��� begin ----------------------------
		shell.setLayout(new FillLayout());

		// viewForm ��Ϊ�ײ�����������FillLayout �����Ͳ���
		final ViewForm viewForm = new ViewForm(shell, SWT.NONE);
		viewForm.setLayout(new FillLayout());

		// viewFotm �����д���ToolBar �� Text �ı���
		final Text text = new Text(viewForm, SWT.BORDER | SWT.WRAP
				| SWT.V_SCROLL);
		viewForm.setContent(text); // �����ı���Ϊ viewForm �������

		// �� ViewForm �д��� CoolBar �������� CoolBar �� ���� �����ӹ�����
		CoolBar coolBar = new CoolBar(viewForm, SWT.None);
		{
			// ����������1 ,�������д�����ť
			ToolBar toolBar = new ToolBar(coolBar, SWT.NONE);
			ToolItem getItem = new ToolItem(toolBar, SWT.PUSH);
			getItem.setText("ȡ��");

			ToolItem clearItem = new ToolItem(toolBar, SWT.DROP_DOWN);
			clearItem.setText("���");

			getItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {

					String str = text.getText();
					MessageDialog.openInformation(null, null, str);
				}
			});

			clearItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					text.setText("");
				}
			});

			// ���� һ�� CoolItem ������ ToolBar �ӹ�����
			CoolItem coolItem = new CoolItem(coolBar, SWT.None);
			coolItem.setControl(toolBar);

			// ���� toolBar �ĺ��ʳߴ磬����toolBar �ĳߴ�������coolItem
			toolBar.pack(); // ����toolBar�ĳߴ�
			Point size = toolBar.getSize();
			coolItem.setSize(size);
			coolItem.setMinimumSize(size); // ����coolItem ����С�ߴ磬����ť���ᱻ�����ӹ����������

		}

		{
			// �����ӹ�����2
			ToolBar toolBar = new ToolBar(coolBar, SWT.None);
			ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
			toolItem.setText("next");

			CoolItem coolItem = new CoolItem(coolBar, SWT.None);
			coolItem.setControl(toolBar);

			toolBar.pack(); // ����toolBar�ĳߴ�
			Point size = toolBar.getSize();
			coolItem.setSize(size);
			coolItem.setMinimumSize(size); // ����coolItem ����С�ߴ磬����ť���ᱻ�����ӹ����������

		}

		{
			// ����������3

			Combo combo = new Combo(coolBar, SWT.None);
			combo.add("www.baidu.com");
			combo.select(0);

			CoolItem coolItem = new CoolItem(coolBar, SWT.None);
			coolItem.setControl(combo);

			combo.pack(); // ����toolBar�ĳߴ�
			Point size = combo.getSize();
			coolItem.setSize(size);
			coolItem.setMinimumSize(size); // ����coolItem ����С�ߴ磬����ť���ᱻ�����ӹ����������

		}

		viewForm.setTopLeft(coolBar);

		// ���� coolBar ���ӹ������ĸı䣬 ���иı������� ���� viewForm ���������λ��
		coolBar.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {

				viewForm.layout();

			}
		});

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