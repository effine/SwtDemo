/**
 * @author Verphen
 * @date 2013��7��26��  ����9:25:51
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
		text.setText("Eclipse�����ŵ���ͨ");
		StyleRange styleRange = new StyleRange(); // ����һ����ʽ
		styleRange.start = 0; // ��ʼ�ַ������ĺ���ĸ����һ���ַ���
		styleRange.length = "Eclipse".length(); // Ӧ�õ��ַ���
		styleRange.fontStyle = SWT.BOLD; // ����
		styleRange.foreground = display.getSystemColor(SWT.COLOR_BLUE);
		styleRange.background = display.getSystemColor(SWT.COLOR_RED);
		// styleRange.underline = true; // �»���
		// styleRange.strikeout = true; // ɾ����
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
