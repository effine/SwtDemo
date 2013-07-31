/**
 * @author Verphen
 * @date 2013年7月26日  上午11:10:17
 */

package verphen.module;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ImageRegistryDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		ImageRegistry ir = new ImageRegistry();
		try {
			URL url = new URL("file://icons/simple.gif");
			ImageDescriptor id = ImageDescriptor.createFromURL(url);
			ir.put("refresh", id);
			Image image = ir.get("refresh"); // 取得图像
			ImageDescriptor imageDescriptor = ir.getDescriptor("refresh"); // 取得图像描述
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Color color = new Color(display, 255, 0, 0);

		RGB rgb = new RGB(255, 0, 0);
		Color color1 = new Color(display, rgb);

		Font font = display.getSystemFont(); // 取得系统使用字体

		Font font1 = new Font(display, "隶书", 14, SWT.BOLD | SWT.ITALIC);

		Font font2 = new Font(display, new FontData("隶书", 14, SWT.BOLD)); // 使用FontData对字体属性进行包装
		
		
		
		
		
		

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
