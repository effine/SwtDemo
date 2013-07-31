/**
 * @author Verphen
 * @date 2013年7月26日  上午11:42:16
 */

package verphen.thread;

import org.eclipse.swt.widgets.Display;

/*
 * 后台处理类
 */
public class Task {

	private TaskGUI taskGUI; // 得到前台界面的引用
	private boolean stopFlag; // 停止后台处理的标志

	// 通过构造方法传入前台对象的引用
	public Task(TaskGUI taskGUI) {
		this.taskGUI = taskGUI;
	}

	// 停止后台处理
	public void stop() {
		stopFlag = true;
	}

	public void start(int taskCount) { // 开始后台处理
		stopFlag = false; // 修改停止标志
		log("后台线程开始执行任务......\n");
		for (int i = 0; i < taskCount; i++) {
			if (stopFlag) { // 一旦发现标志被修改为停止，则退出循环
				break;
			}

			// 每隔0.1秒一次循环，用于模拟一个需较长时间的任务
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				log(e.getMessage());
			}
			log(" 任务 " + (i + 1) + " 处理完毕\n");
			notifyOneTaskFinish(i); // 通知完成一个任务
		}
	}

	private void log(final String str) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				taskGUI.consolePrintln(str); // 向前台的界面的 consoleText输出信息
			}
		});
	}

	private void notifyOneTaskFinish(final int progress) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				taskGUI.moveProgress(progress);
			}
		});
	}

	private void notifyAllTaskFinish() {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				taskGUI.setButtonState(true);
			}
		});

	}
}
