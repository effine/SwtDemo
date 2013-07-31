/**
 * @author Verphen
 * @date 2013��7��26��  ����11:41:07
 */

package verphen.thread;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TaskGUI {

	private Task task = new Task(this); // TaskΪ��̨������

	// ������������ó����ʵ������
	private Text taskCountText; // �������ı���
	private Button startButton; // ����ʼ����ť
	private Button stopButton; // ��ֹͣ����ť
	private ProgressBar progressBar; // ������
	private Text consoleText; // �����־���ı���console

	public static void main(String[] args) {
		new TaskGUI().open();
	}

	public void open() {

		final Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		shell.setSize(300, 300);
		shell.setLayout(new GridLayout());

		// �������ı���Ͱ�ť����
		Group group = new Group(shell, SWT.None);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setLayout(new GridLayout(4, false));

		// �������ı���
		new Label(group, SWT.None).setText("������");
		taskCountText = new Text(group, SWT.BORDER);
		taskCountText.setText("100"); // Ĭ��������
		taskCountText.setLayoutData(new GridData(100, -1));
		taskCountText.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) { // ֻ��������ֵ
				e.doit = "0123456789".indexOf(e.text) >= 0;
			}
		});
		// ִ�а�ť
		startButton = new Button(group, SWT.PUSH);
		startButton.setText("��ʼ");
		startButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				setButtonState(false); // ����������ť��һ����Ч/��Ч
				// �õ������������߳�ʹ�õı���Ҫ������Ϊfinal
				final int taskCount = Integer.valueOf(taskCountText.getText());
				progressBar.setMaximum(taskCount - 1); // ���ý������ĸ���
				consoleText.insert("��̨�����߳̿�ʼ����.....\n");
				new Thread() { // Ϊ��̨�����¿�һ���߳�
					public void run() {
						task.start(taskCount);
					}

				}.start();
				consoleText.insert("��̨�����߳���������\n");

			}
		});

		// ֹͣ��ť
		stopButton = new Button(group, SWT.PUSH);
		stopButton.setText("ֹͣ");
		stopButton.setEnabled(false);
		stopButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				task.stop(); // ��̨����ֹͣ

			}

		});

		// ������
		progressBar = new ProgressBar(group, SWT.NONE);
		progressBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// ��־�ı���
		consoleText = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		consoleText.setLayoutData(new GridData(GridData.FILL_BOTH));

		// ----------------------------
		shell.layout();
		shell.open();
		shell.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				task.stop(); // ���ڹر�ʱ��֪ͨ��̨��ֹͣ����

			}
		});
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();

	}

	// ����������ť��Ч/��Ч��״̬��trueִ�а�ť��Ч,ֹͣ��ť��Ч
	public void setButtonState(boolean flag) {
		if (!startButton.isDisposed())
			startButton.setEnabled(flag);
		if (!stopButton.isDisposed())
			stopButton.setEnabled(!flag);
	}

	// ��ǰ�ƶ�������
	public void moveProgress(int progress) {

		if (!progressBar.isDisposed())
			progressBar.setSelection(progress);

	}

	// ��consoleText�ı���������־
	public void consolePrintln(String str) {
		if (!consoleText.isDisposed())
			consoleText.insert(str);
	}

}
