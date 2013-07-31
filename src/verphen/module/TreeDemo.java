/**
 * @author  arno
 * @version	 2013-7-2  ����03:11:34
 */

package verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class TreeDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		// ------------------code start ------------------------

		shell.setLayout(new FillLayout());

		// ����tree����SWT.SINGLE�ǵ�ѡ��SWT.MULTI�Ƕ�ѡ
		final Tree tree = new Tree(shell, SWT.SINGLE);
		// final Tree tree = new Tree(shell, SWT.MULTI);

		TreeItem chinaItem = new TreeItem(tree, SWT.None);
		chinaItem.setText("�й�");

		new TreeItem(chinaItem, SWT.NULL).setText("����");
		new TreeItem(chinaItem, SWT.NULL).setText("����");
		new TreeItem(chinaItem, SWT.NULL).setText("̨��");
		new TreeItem(chinaItem, SWT.NULL).setText("����");

		new TreeItem(tree, SWT.None).setText("����");

		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// TreeΪ��ѡ������getSelection�������ص���һ������
				// �������� treeΪ��ѡ����������Ԫ��ֻ��һ��
				TreeItem[] items = tree.getSelection();
				shell.setText(items[0].getText());
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
