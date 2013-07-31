/**
 * @author  arno
 * @version	 2013-7-1  ����09:46:34
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

		// ���ò˵���
		Menu mainMenu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(mainMenu);

		// ���ý����һ��˵�
		// Menu mainMenu = new Menu(shell, SWT.POP_UP);
		// shell.setMenu(mainMenu);

		MenuItem fileItem = new MenuItem(mainMenu, SWT.CASCADE);
		fileItem.setText("�ļ�(&F)");

		MenuItem helpItem = new MenuItem(mainMenu, SWT.CASCADE);
		helpItem.setText("����(&H)");

		// �����ļ��˵��µ��Ӳ˵�:�½����˳�
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileItem.setMenu(fileMenu);
		MenuItem newFileItem = new MenuItem(fileMenu, SWT.CASCADE);
		newFileItem.setText("�½�(&N)");

		MenuItem exitItem = new MenuItem(fileMenu, SWT.CASCADE);
		exitItem.setText("�˳�(&X)");

		// �������ļ� ����>�½����˵��µ��Ӳ˵�����Ŀ�������ࡢ�ӿڡ�����
		Menu newFileMenu = new Menu(shell, SWT.DROP_DOWN);
		newFileItem.setMenu(newFileMenu);

		MenuItem newProject = new MenuItem(newFileMenu, SWT.PUSH);
		newProject.setText("��Ŀ\tCtrl+N");
		newProject.setAccelerator(SWT.CTRL + 'N'); // ���ÿ�ݼ�

		newProject.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(null, null, "�½���Ŀ");
			}
		});

		new MenuItem(newFileMenu, SWT.SEPARATOR); // �ָ���
		new MenuItem(newFileMenu, SWT.PUSH).setText("��");
		new MenuItem(newFileMenu, SWT.PUSH).setText("��");
		new MenuItem(newFileMenu, SWT.PUSH).setText("�ӿ�");
		new MenuItem(newFileMenu, SWT.SEPARATOR); // �ָ���
		new MenuItem(newFileMenu, SWT.PUSH).setText("����");

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
