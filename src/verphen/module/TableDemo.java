/**
 * @author  arno
 * @version	 2013-7-1  ����11:44:29
 */

package verphen.module;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/*
 * ���Ա��
 * 
 *  ������ʾ���ݿ��еļ�¼������   jface    �е�    tableViewer
 * 
 */

public class TableDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		// ------------------code start ------------------------

		shell.setLayout(new FillLayout());

		// ����һ���ɶ�ѡ�ı�񣬲��������ı�ͷ�ͱ����
		final Table table = new Table(shell, SWT.MULTI | SWT.FULL_SELECTION);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// Ϊtable�������У��������еĿ�ȶ���90
		TableColumn col1 = new TableColumn(table, SWT.None);
		col1.setText("ID");
		col1.setWidth(90);

		TableColumn col2 = new TableColumn(table, SWT.None);
		col2.setText("����");
		col2.setWidth(90);

		TableColumn col3 = new TableColumn(table, SWT.None);
		col3.setText("test");
		col3.setWidth(90);

		// ����Compile ������������������ť
		Composite composite = new Composite(shell, SWT.None);
		composite.setLayout(new RowLayout());

		Button addButton = new Button(composite, SWT.None);
		addButton.setText("����");
		addButton.addSelectionListener(new SelectionAdapter() {
			int i;

			@Override
			public void widgetSelected(SelectionEvent e) {

				// ���� Item
				TableItem item = new TableItem(table, 0);
				item.setText(new String[] { " " + i, "�¸�" + i, "����" + i }); // ��item
				i++;
			}
		});

		Button removeButton = new Button(composite, SWT.None);
		removeButton.setText("ɾ��");
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// �õ����б�ѡ�����е���� ��Ȼ��������ɾ����¼
				int[] sellices = table.getSelectionIndices();
				table.remove(sellices);
			}
		});

		// �������˫���¼�
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				int sellndex = table.getSelectionIndex();
				TableItem item = table.getItem(sellndex);
				String str = "��  1 =" + item.getText(0) + "\n �� 2="
						+ item.getText(1);
				MessageDialog.openInformation(null, null, str);

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

		display.dispose();
	}
}
