/**
 * @author  arno
 * @version	 2013-6-25  ����02:46:49
 */

package verphen.util;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;

public class SwtWindowAlignCenter {

	public SwtWindowAlignCenter() {
	}

	public static void setCenter(Shell shell) {

		// ȡ����Ļ�Ŀ�Ⱥ͸߶� ����λ�����أ�
		Rectangle rtg = shell.getMonitor().getClientArea();

		int height = rtg.height;
		int width = rtg.width;

		// ȡ�� shell �Ŀ�Ⱥ͸߶�
		int x = shell.getSize().x;
		int y = shell.getSize().y;

		// ���shell����ʱ�����Ͻǵ������
		Point point = new Point((width - x) / 2, (height - y) / 2);
		shell.setLocation(point);	//��λ����
	}
}
