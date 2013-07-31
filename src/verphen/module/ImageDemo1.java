/**
 * @author Verphen
 * @date 2013年7月26日  上午10:37:00
 */

package verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ImageDemo1 {

	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		new Button(shell, SWT.NONE).setImage(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImage(ISharedImages.IMG_DEC_FIELD_WARNING));

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
