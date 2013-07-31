/**
 * @author  arno
 * @version	 2013-6-26  ����02:43:51
 */

package verphen.util;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class ConsoleDemo {
	public static void main(String[] args) {

		// �����½�һ��MessageConsole
		MessageConsole console = new MessageConsole("my console", null);

		// ͨ��ConsolePlugin�õ�ConsoleManager��������µ�MessageConsole
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] { console });

		// �½�һ��MessageConsoleStream,���ڽ�����Ҫ��ʾ����Ϣ
		MessageConsoleStream consoleStream = console.newMessageStream();

		// ��Console��ͼ
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);

		// ʹ��MessageConsoleStream����ӡ��Ϣ��Console View
		consoleStream.println("���Դ�ӡ��Ϣ");

	}
}
