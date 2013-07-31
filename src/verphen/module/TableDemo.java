/**
 * @author  arno
 * @version	 2013-7-1  上午11:44:29
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
 * 测试表格
 * 
 *  如需显示数据库中的记录，则用   jface    中的    tableViewer
 * 
 */

public class TableDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		// ------------------code start ------------------------

		shell.setLayout(new FillLayout());

		// 创建一个可多选的表格，并设置他的表头和表格线
		final Table table = new Table(shell, SWT.MULTI | SWT.FULL_SELECTION);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// 为table设置两列，并且两列的宽度都是90
		TableColumn col1 = new TableColumn(table, SWT.None);
		col1.setText("ID");
		col1.setWidth(90);

		TableColumn col2 = new TableColumn(table, SWT.None);
		col2.setText("姓名");
		col2.setWidth(90);

		TableColumn col3 = new TableColumn(table, SWT.None);
		col3.setText("test");
		col3.setWidth(90);

		// 创建Compile 容器，并放入两个按钮
		Composite composite = new Composite(shell, SWT.None);
		composite.setLayout(new RowLayout());

		Button addButton = new Button(composite, SWT.None);
		addButton.setText("新增");
		addButton.addSelectionListener(new SelectionAdapter() {
			int i;

			@Override
			public void widgetSelected(SelectionEvent e) {

				// 创建 Item
				TableItem item = new TableItem(table, 0);
				item.setText(new String[] { " " + i, "陈刚" + i, "测试" + i }); // 给item
				i++;
			}
		});

		Button removeButton = new Button(composite, SWT.None);
		removeButton.setText("删除");
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// 得到所有被选中序列的序号 ，然后根据序号删除记录
				int[] sellices = table.getSelectionIndices();
				table.remove(sellices);
			}
		});

		// 监听鼠标双击事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				int sellndex = table.getSelectionIndex();
				TableItem item = table.getItem(sellndex);
				String str = "列  1 =" + item.getText(0) + "\n 列 2="
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
