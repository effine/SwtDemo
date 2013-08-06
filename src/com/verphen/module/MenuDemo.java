package com.verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuDemo {

	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		// ------------------ code start ------------------------------

		Menu mainMenu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(mainMenu);
		MenuItem fileItem = new MenuItem(mainMenu, SWT.CASCADE);
		fileItem.setText("文件（&F）");

		MenuItem helpItem = new MenuItem(mainMenu, SWT.CASCADE);
		helpItem.setText("帮助(&H)");

		// 创建文件菜单的子菜单：新建 、退出
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		

		// ------------------ code end ------------------------------

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
