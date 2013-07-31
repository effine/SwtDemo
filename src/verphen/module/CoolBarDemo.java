/**
 * @author  arno
 * @version	 2013-6-28  上午10:53:04
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

		// -------------------核心代码 begin ----------------------------
		shell.setLayout(new FillLayout());

		// viewForm 作为底层容器，采用FillLayout 充满型布局
		final ViewForm viewForm = new ViewForm(shell, SWT.NONE);
		viewForm.setLayout(new FillLayout());

		// viewFotm 容器中创建ToolBar 和 Text 文本框
		final Text text = new Text(viewForm, SWT.BORDER | SWT.WRAP
				| SWT.V_SCROLL);
		viewForm.setContent(text); // 设置文本框为 viewForm 的主组件

		// 在 ViewForm 中创建 CoolBar ，接着在 CoolBar 中 创建 两条子工具栏
		CoolBar coolBar = new CoolBar(viewForm, SWT.None);
		{
			// 创建工具栏1 ,并在其中创建按钮
			ToolBar toolBar = new ToolBar(coolBar, SWT.NONE);
			ToolItem getItem = new ToolItem(toolBar, SWT.PUSH);
			getItem.setText("取得");

			ToolItem clearItem = new ToolItem(toolBar, SWT.DROP_DOWN);
			clearItem.setText("清除");

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

			// 创建 一个 CoolItem 来控制 ToolBar 子工具栏
			CoolItem coolItem = new CoolItem(coolBar, SWT.None);
			coolItem.setControl(toolBar);

			// 调整 toolBar 的合适尺寸，并用toolBar 的尺寸来调整coolItem
			toolBar.pack(); // 调整toolBar的尺寸
			Point size = toolBar.getSize();
			coolItem.setSize(size);
			coolItem.setMinimumSize(size); // 设置coolItem 的最小尺寸，否则按钮将会被其他子工具栏所替代

		}

		{
			// 创建子工具栏2
			ToolBar toolBar = new ToolBar(coolBar, SWT.None);
			ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
			toolItem.setText("next");

			CoolItem coolItem = new CoolItem(coolBar, SWT.None);
			coolItem.setControl(toolBar);

			toolBar.pack(); // 调整toolBar的尺寸
			Point size = toolBar.getSize();
			coolItem.setSize(size);
			coolItem.setMinimumSize(size); // 设置coolItem 的最小尺寸，否则按钮将会被其他子工具栏所替代

		}

		{
			// 创建工具栏3

			Combo combo = new Combo(coolBar, SWT.None);
			combo.add("www.baidu.com");
			combo.select(0);

			CoolItem coolItem = new CoolItem(coolBar, SWT.None);
			coolItem.setControl(combo);

			combo.pack(); // 调整toolBar的尺寸
			Point size = combo.getSize();
			coolItem.setSize(size);
			coolItem.setMinimumSize(size); // 设置coolItem 的最小尺寸，否则按钮将会被其他子工具栏所替代

		}

		viewForm.setTopLeft(coolBar);

		// 监听 coolBar 中子工具栏的改变， 如有改变则重新 排列 viewForm 中字组件的位置
		coolBar.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {

				viewForm.layout();

			}
		});

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