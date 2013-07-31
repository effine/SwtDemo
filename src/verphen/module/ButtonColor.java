/**
 * @author Verphen
 * @date 2013年7月24日  上午11:40:25
 */

package verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ButtonColor {

	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		// -----------code start --------------------

		Button button = new Button(shell, SWT.NONE);
		button.setLocation(200, 300);

		new ButtonColor().fixSetBackground(button);

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

	private void fixSetBackground(Button button) {
		Color foreground = button.getForeground();
		Color background = button.getBackground();
		int x = 0;
		int y = 0;
		Rectangle rect = button.getBounds();
		int width = rect.width;
		int height = rect.height;
		String text = button.getText();
		if (width == 0)
			width = 1;
		if (height == 0)
			height = 1;
		button.setImage(new Image(button.getParent().getDisplay(), width,
				height));
		Image original = button.getImage();
		GC gc = new GC(original);
		Color oldForeGround = gc.getForeground();
		gc.setForeground(foreground);
		gc.setBackground(background);
		gc.fillGradientRectangle(x, y, width, height, true);
		gc.setForeground(oldForeGround);
		Font font = button.getFont();
		FontData fontData = font.getFontData()[0];
		int fontSize = fontData.getHeight();
		gc.setFont(button.getFont());
		int ximg = (x + width) / 2 - fontSize * text.length() / 3;
		int yimg = (y + height) / 2 - fontSize * 3 / 4;
		gc.drawText(text, ximg < 4 ? ximg : 4, yimg < 4 ? yimg : 4,
				SWT.DRAW_TRANSPARENT | SWT.DRAW_MNEMONIC);
		gc.dispose();
	}
}
