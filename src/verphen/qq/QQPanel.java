/**
 * @author  arno
 * @version	 2013-6-27  上午09:54:24
 */

package verphen.qq;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * 制作一个型如QQ面板设置的Demo
 */

public class QQPanel {

	private List selectList;
	private Composite rightComp;
	private Composite yourDataComp;
	private Composite otherComp;
	private StackLayout stackLayout = new StackLayout();

	public static void main(String[] args) {
		new QQPanel().open();
	}

	public void open() {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(550, 350);

		shell.setText("个人设置");
		shell.setLayout(new GridLayout());

		// ----------------设置分割线---------------------
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setLayout(new GridLayout(GridData.FILL_BOTH, false));

		selectList = new List(sashForm, SWT.BORDER); // 分割窗口左边的list列表
		selectList.setItems(new String[] { "个人资料", "联系方式" });
		selectList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// 添加list中的选择监听

			}
		});

		rightComp = new Composite(sashForm, SWT.NONE); // 右边是堆栈式 的容器
		rightComp.setLayout(stackLayout);

		// 分为两页，将生成页面的代码提取成为方法，便于代码的清晰
		yourDataComp = createYourDataComp(rightComp);
		otherComp = createOtherComp(rightComp);

		stackLayout.topControl = yourDataComp; // 将"个人资料"面板置于顶端
		sashForm.setWeights(new int[] { 1, 4 }); // 分割窗口左右空间的比例

		// ---------------底部按钮组面板--------------------------
		Composite buttonComp = new Composite(shell, SWT.NONE);
		// 使用GridData让按钮组面板像父类容器shell的右端对齐
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.END;
		buttonComp.setLayoutData(gridData);

		// 设置按钮面板内按钮的行列式布局，按钮间距为15像素
		RowLayout rowLayout = new RowLayout();
		rowLayout.spacing = 15;
		buttonComp.setLayout(rowLayout);

		// 在buttonComp容器中创建三个按钮
		new Button(buttonComp, SWT.NONE).setText("  确定     ");
		new Button(buttonComp, SWT.NONE).setText("  取消     ");
		new Button(buttonComp, SWT.NONE).setText("  应用     ");

		shell.layout(); // 相当于刷新
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	// "个人资料"面板生成方法
	private Composite createYourDataComp(Composite rightComp) {
		Composite comp = new Composite(rightComp, SWT.NONE);
		comp.setLayout(new GridLayout(6, false)); // 面板空间分成6列，组件间距不相等

		new Label(comp, SWT.NONE).setText("用户号码：");

		return comp;
	}

	// "联系方法"面板生成方法
	private Composite createOtherComp(Composite rightComp) {

		Composite comp = new Composite(rightComp, SWT.NONE);
		comp.setLayout(new FillLayout());
		new Label(comp, SWT.NONE).setText("联系方式面板");
		return comp;
	}

}
