/**
 * @author  arno
 * @version	 2013-6-26  下午02:43:51
 */

package verphen.util;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class ConsoleDemo {
	public static void main(String[] args) {

		// 首先新建一个MessageConsole
		MessageConsole console = new MessageConsole("my console", null);

		// 通过ConsolePlugin得到ConsoleManager，并添加新的MessageConsole
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] { console });

		// 新建一个MessageConsoleStream,用于接收需要显示的信息
		MessageConsoleStream consoleStream = console.newMessageStream();

		// 打开Console视图
		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);

		// 使用MessageConsoleStream来打印信息到Console View
		consoleStream.println("测试打印信息");

	}
}
