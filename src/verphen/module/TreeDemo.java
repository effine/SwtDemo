/**
 * @author  arno
 * @version	 2013-7-2  下午03:11:34
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

		// 创建tree对象，SWT.SINGLE是单选，SWT.MULTI是多选
		final Tree tree = new Tree(shell, SWT.SINGLE);
		// final Tree tree = new Tree(shell, SWT.MULTI);

		TreeItem chinaItem = new TreeItem(tree, SWT.None);
		chinaItem.setText("中国");

		new TreeItem(chinaItem, SWT.NULL).setText("北京");
		new TreeItem(chinaItem, SWT.NULL).setText("贵州");
		new TreeItem(chinaItem, SWT.NULL).setText("台湾");
		new TreeItem(chinaItem, SWT.NULL).setText("大连");

		new TreeItem(tree, SWT.None).setText("美国");

		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// Tree为多选，所以getSelection方法返回的是一个数组
				// 而本例中 tree为单选，所以数组元素只有一个
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
