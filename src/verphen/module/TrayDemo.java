/**
 * @author Verphen
 * @date 2013-7-18  下午04:58:44
 */

package verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

public class TrayDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		final Shell shell = new Shell(display);

		// -----------code start --------------------

		final ToolTip tip = new ToolTip(shell, SWT.BALLOON
				| SWT.ICON_INFORMATION); // 气泡显示
		Tray tray = shell.getDisplay().getSystemTray(); // 取得系统的托盘图标

		if (tray != null) {
			TrayItem item = new TrayItem(tray, SWT.NONE); // 创建托盘对象
			item.setToolTipText("QQ正在运行"); // 托盘提示文字
			item.setImage(new Image(display, "icons/simple.gif")); // 托盘图标
			item.setToolTip(tip);

			// 生成菜单项，右击图标时显示
			final Menu menu = new Menu(shell, SWT.POP_UP);
			final MenuItem showMenu = new MenuItem(menu, SWT.PUSH);
			showMenu.setText("&Hide");
			showMenu.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					boolean showFlag = shell.isVisible();
					shell.setVisible(!showFlag);

					showMenu.setText(showFlag ? "S&show" : "&Hide");

					tip.setText("QQ托盘图标");

					tip.setMessage("右键单击图标，\n 可以选择菜单");

					tip.setVisible(true);
				}

			});

			MenuItem exitMenu = new MenuItem(menu, SWT.PUSH);
			exitMenu.setText("&Exit");
			exitMenu.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					System.exit(0);
				}
			});

			// 为托盘图标添加事件
			item.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event e) {
					System.out.println("鼠标单击");
				}
			});

			item.addListener(SWT.DefaultSelection, new Listener() {
				public void handleEvent(Event e) {
					System.out.println("鼠标双击");
				}
			});

			item.addListener(SWT.MenuDetect, new Listener() {
				public void handleEvent(Event event) {
					menu.setVisible(true); // 右键单击菜单时显示图标
				}
			});

			// 效果： 关闭窗口时最小化到托盘

			shell.addShellListener(new ShellAdapter() {

				public void shellClosed(ShellEvent e) {

					e.doit = false; // 使关闭的按钮无效
					shell.setVisible(false);
					showMenu.setText("S&show");
					tip.setText("QQ托盘图标");
					tip.setMessage("右键单击菜单时，可以选择菜单");
					tip.setVisible(true);
				}

			});

		} else {

			tip.setText("该系统不支持托盘图标");
			tip.setLocation(400, 400);

		}

		// -----------code end --------------------
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
