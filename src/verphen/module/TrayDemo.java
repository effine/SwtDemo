/**
 * @author Verphen
 * @date 2013-7-18  ����04:58:44
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
				| SWT.ICON_INFORMATION); // ������ʾ
		Tray tray = shell.getDisplay().getSystemTray(); // ȡ��ϵͳ������ͼ��

		if (tray != null) {
			TrayItem item = new TrayItem(tray, SWT.NONE); // �������̶���
			item.setToolTipText("QQ��������"); // ������ʾ����
			item.setImage(new Image(display, "icons/simple.gif")); // ����ͼ��
			item.setToolTip(tip);

			// ���ɲ˵���һ�ͼ��ʱ��ʾ
			final Menu menu = new Menu(shell, SWT.POP_UP);
			final MenuItem showMenu = new MenuItem(menu, SWT.PUSH);
			showMenu.setText("&Hide");
			showMenu.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					boolean showFlag = shell.isVisible();
					shell.setVisible(!showFlag);

					showMenu.setText(showFlag ? "S&show" : "&Hide");

					tip.setText("QQ����ͼ��");

					tip.setMessage("�Ҽ�����ͼ�꣬\n ����ѡ��˵�");

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

			// Ϊ����ͼ������¼�
			item.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event e) {
					System.out.println("��굥��");
				}
			});

			item.addListener(SWT.DefaultSelection, new Listener() {
				public void handleEvent(Event e) {
					System.out.println("���˫��");
				}
			});

			item.addListener(SWT.MenuDetect, new Listener() {
				public void handleEvent(Event event) {
					menu.setVisible(true); // �Ҽ������˵�ʱ��ʾͼ��
				}
			});

			// Ч���� �رմ���ʱ��С��������

			shell.addShellListener(new ShellAdapter() {

				public void shellClosed(ShellEvent e) {

					e.doit = false; // ʹ�رյİ�ť��Ч
					shell.setVisible(false);
					showMenu.setText("S&show");
					tip.setText("QQ����ͼ��");
					tip.setMessage("�Ҽ������˵�ʱ������ѡ��˵�");
					tip.setVisible(true);
				}

			});

		} else {

			tip.setText("��ϵͳ��֧������ͼ��");
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
