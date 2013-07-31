/**
 * @author Verphen
 * @date 2013年7月26日  上午10:18:42
 */

package verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ImageDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		shell.setLayout(new FillLayout());
		Image im = new Image(display, 100, 50);
		// 生成一张宽100像素，高50像素的白色图片

		// 使用image 生成一个GC对象，并用它在图像上写红底黑字
		GC gc = new GC(im);
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
		gc.setBackground(display.getSystemColor(SWT.COLOR_RED));

		gc.drawText("hello world", 0, 0, false);
		gc.dispose();
		new Button(shell, SWT.NONE).setImage(im);

		/*
		 * Image image = PlatformUI.getWorkbench().getSharedImages()
		 * .getImage(ISharedImages.IMG_DEC_FIELD_WARNING); Button button = new
		 * Button(shell, SWT.NONE); button.setImage(image);
		 */

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
