/**
 * @author Verphen
 * @date 2013��7��26��  ����11:42:16
 */

package verphen.thread;

import org.eclipse.swt.widgets.Display;

/*
 * ��̨������
 */
public class Task {

	private TaskGUI taskGUI; // �õ�ǰ̨���������
	private boolean stopFlag; // ֹͣ��̨����ı�־

	// ͨ�����췽������ǰ̨���������
	public Task(TaskGUI taskGUI) {
		this.taskGUI = taskGUI;
	}

	// ֹͣ��̨����
	public void stop() {
		stopFlag = true;
	}

	public void start(int taskCount) { // ��ʼ��̨����
		stopFlag = false; // �޸�ֹͣ��־
		log("��̨�߳̿�ʼִ������......\n");
		for (int i = 0; i < taskCount; i++) {
			if (stopFlag) { // һ�����ֱ�־���޸�Ϊֹͣ�����˳�ѭ��
				break;
			}

			// ÿ��0.1��һ��ѭ��������ģ��һ����ϳ�ʱ�������
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				log(e.getMessage());
			}
			log(" ���� " + (i + 1) + " �������\n");
			notifyOneTaskFinish(i); // ֪ͨ���һ������
		}
	}

	private void log(final String str) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				taskGUI.consolePrintln(str); // ��ǰ̨�Ľ���� consoleText�����Ϣ
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
