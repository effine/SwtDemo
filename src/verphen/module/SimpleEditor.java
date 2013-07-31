/**
 * @author  arno
 * @version	 2013-6-28  上午09:59:40
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
 * 简单的编辑器
 * 
 */
public class SimpleEditor {

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		// -------------------核心代码 begin ----------------------------

		shell.setLayout(new FillLayout());

		// viewForm 作为底层容器，采用FillLayout 充满型布局
		ViewForm viewForm = new ViewForm(shell, SWT.NONE);
		viewForm.setLayout(new FillLayout());

		// viewFotm 容器中创建ToolBar 和 Text 文本框
		final Text text = new Text(viewForm, SWT.BORDER | SWT.WRAP
				| SWT.V_SCROLL);
		viewForm.setContent(text); // 设置文本框为 viewForm 的主组件

		// 在 viewForm 中创建ToolBar
		ToolBar toolBar = new ToolBar(viewForm, SWT.NONE);
		ToolItem getItem = new ToolItem(toolBar, SWT.PUSH);
		getItem.setText("取得");

		// 给"取得" 菜单按钮设置监听
		getItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String str = text.getText();
				MessageDialog.openInformation(null, null, str);
			}
		});

		ToolItem clearItem = new ToolItem(toolBar, SWT.DROP_DOWN);
		clearItem.setText("清除");
		clearItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
			}
		});

		viewForm.setTopLeft(toolBar);
		// -------------------核心代码 end ----------------------------

		shell.layout();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
