/**
 * @author Verphen
 * @date 2013年7月26日  上午9:25:51
 */

package verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class StyledTextDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		final Shell shell = new Shell(display);

		// -----------code start --------------------

		shell.setLayout(new FillLayout());
		StyledText text = new StyledText(shell, SWT.WRAP | SWT.BORDER);
		text.setText("Eclipse从入门到精通");
		StyleRange styleRange = new StyleRange(); // 创建一个样式
		styleRange.start = 0; // 开始字符（中文和字母都算一个字符）
		styleRange.length = "Eclipse".length(); // 应用的字符数
		styleRange.fontStyle = SWT.BOLD; // 粗体
		styleRange.foreground = display.getSystemColor(SWT.COLOR_BLUE);
		styleRange.background = display.getSystemColor(SWT.COLOR_RED);
		// styleRange.underline = true; // 下划线
		// styleRange.strikeout = true; // 删除线
		text.setStyleRange(styleRange);

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
