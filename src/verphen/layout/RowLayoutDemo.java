/**
 * @author  arno
 * @version	 2013-6-26  上午09:51:36
 */

package verphen.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import verphen.util.SwtWindowAlignCenter;

/*
 *	行列式布局管理器 
 */

public class RowLayoutDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		// shell.setSize(300, 400);

		RowLayout layout = new RowLayout();
		// layout.type =SWT.VERTICAL; 和上面new FillLayout(SWT.VERTICAL)作用一样
		// layout.marginHeight = 10;
		// layout.marginWidth = 30;
		// layout.spacing = 20;

		/*
		 * layout.wrap = false; 控制自动换行，默认为true（自动换行）
		 * 
		 * layout.pack = false;pack控制组件的大小，false表示组件大小相同，默认为true
		 * 
		 * layout.justify = true;	justify 组件间距根据容器空间拉伸 ，true表示不拉伸，默认为false
		 */

		

		shell.setLayout(layout);
		SwtWindowAlignCenter.setCenter(shell);
		new Button(shell, SWT.NONE).setText("确定");
		new Button(shell, SWT.NONE).setText("取消");
		new Button(shell, SWT.NONE).setText("帮助");

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
