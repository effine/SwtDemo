/**
 * @author  arno
 * @version	 2013-6-25  下午02:46:49
 */

package verphen.util;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;

public class SwtWindowAlignCenter {

	public SwtWindowAlignCenter() {
	}

	public static void setCenter(Shell shell) {

		// 取得屏幕的宽度和高度 （单位：像素）
		Rectangle rtg = shell.getMonitor().getClientArea();

		int height = rtg.height;
		int width = rtg.width;

		// 取得 shell 的宽度和高度
		int x = shell.getSize().x;
		int y = shell.getSize().y;

		// 算出shell居中时，左上角的坐标点
		Point point = new Point((width - x) / 2, (height - y) / 2);
		shell.setLocation(point);	//定位居中
	}
}
