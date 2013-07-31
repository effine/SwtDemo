/**
 * @author  arno
 * @version	 2013-7-1  上午09:46:34
 */

package verphen.module;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Canvas;

public class MenuDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		// ------------------code start ------------------------

		// 设置菜单栏
		Menu mainMenu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(mainMenu);

		// 设置界面右击菜单
		// Menu mainMenu = new Menu(shell, SWT.POP_UP);
		// shell.setMenu(mainMenu);

		MenuItem fileItem = new MenuItem(mainMenu, SWT.CASCADE);
		fileItem.setText("文件(&F)");

		MenuItem helpItem = new MenuItem(mainMenu, SWT.CASCADE);
		helpItem.setText("帮助(&H)");

		// 创建文件菜单下的子菜单:新建、退出
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileItem.setMenu(fileMenu);
		MenuItem newFileItem = new MenuItem(fileMenu, SWT.CASCADE);
		newFileItem.setText("新建(&N)");

		MenuItem exitItem = new MenuItem(fileMenu, SWT.CASCADE);
		exitItem.setText("退出(&X)");

		// 创建“文件 ——>新建”菜单下的子菜单：项目、包、类、接口、其他
		Menu newFileMenu = new Menu(shell, SWT.DROP_DOWN);
		newFileItem.setMenu(newFileMenu);

		MenuItem newProject = new MenuItem(newFileMenu, SWT.PUSH);
		newProject.setText("项目\tCtrl+N");
		newProject.setAccelerator(SWT.CTRL + 'N'); // 设置快捷键

		newProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(null, null, "新建项目");
			}
		});

		new MenuItem(newFileMenu, SWT.SEPARATOR); // 分隔符
		new MenuItem(newFileMenu, SWT.PUSH).setText("包");
		new MenuItem(newFileMenu, SWT.PUSH).setText("类");
		new MenuItem(newFileMenu, SWT.PUSH).setText("接口");
		new MenuItem(newFileMenu, SWT.SEPARATOR); // 分隔符
		new MenuItem(newFileMenu, SWT.PUSH).setText("其他");

		Slider slider = new Slider(shell, SWT.VERTICAL);
		slider.setBounds(312, 37, 17, 133);
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(25, 23, 215, 170);

		// ------------------code end ------------------------
		shell.layout();
		shell.open();
		while (!shell.isDisposed()) {
			while (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
