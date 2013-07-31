/**
 * @author Verphen
 * @date 2013年7月26日  上午11:41:07
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

	private Task task = new Task(this); // Task为后台处理类

	// 将界面组件设置成类的实例变量
	private Text taskCountText; // 任务数文本框
	private Button startButton; // “开始”按钮
	private Button stopButton; // “停止”按钮
	private ProgressBar progressBar; // 进度条
	private Text consoleText; // 输出日志的文本框console

	public static void main(String[] args) {
		new TaskGUI().open();
	}

	public void open() {

		final Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		shell.setSize(300, 300);
		shell.setLayout(new GridLayout());

		// 任务数文本框和按钮的组
		Group group = new Group(shell, SWT.None);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setLayout(new GridLayout(4, false));

		// 任务数文本框
		new Label(group, SWT.None).setText("任务数");
		taskCountText = new Text(group, SWT.BORDER);
		taskCountText.setText("100"); // 默认任务数
		taskCountText.setLayoutData(new GridData(100, -1));
		taskCountText.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) { // 只能输入数值
				e.doit = "0123456789".indexOf(e.text) >= 0;
			}
		});
		// 执行按钮
		startButton = new Button(group, SWT.PUSH);
		startButton.setText("开始");
		startButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				setButtonState(false); // 设置两个按钮有一个有效/无效
				// 得到任务数，多线程使用的变量要求类型为final
				final int taskCount = Integer.valueOf(taskCountText.getText());
				progressBar.setMaximum(taskCount - 1); // 设置进度条的格数
				consoleText.insert("后台处理线程开始启动.....\n");
				new Thread() { // 为后台任务新开一个线程
					public void run() {
						task.start(taskCount);
					}

				}.start();
				consoleText.insert("后台处理线程启动结束\n");

			}
		});

		// 停止按钮
		stopButton = new Button(group, SWT.PUSH);
		stopButton.setText("停止");
		stopButton.setEnabled(false);
		stopButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				task.stop(); // 后台任务停止

			}

		});

		// 进度条
		progressBar = new ProgressBar(group, SWT.NONE);
		progressBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// 日志文本框
		consoleText = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		consoleText.setLayoutData(new GridData(GridData.FILL_BOTH));

		// ----------------------------
		shell.layout();
		shell.open();
		shell.addDisposeListener(new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				task.stop(); // 窗口关闭时，通知后台类停止处理

			}
		});
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();

	}

	// 设置两个按钮有效/无效的状态，true执行按钮有效,停止按钮无效
	public void setButtonState(boolean flag) {
		if (!startButton.isDisposed())
			startButton.setEnabled(flag);
		if (!stopButton.isDisposed())
			stopButton.setEnabled(!flag);
	}

	// 向前移动进度条
	public void moveProgress(int progress) {

		if (!progressBar.isDisposed())
			progressBar.setSelection(progress);

	}

	// 向consoleText文本框输入日志
	public void consolePrintln(String str) {
		if (!consoleText.isDisposed())
			consoleText.insert(str);
	}

}
