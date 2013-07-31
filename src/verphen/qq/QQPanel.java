/**
 * @author  arno
 * @version	 2013-6-27  ����09:54:24
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
 * ����һ������QQ������õ�Demo
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

		shell.setText("��������");
		shell.setLayout(new GridLayout());

		// ----------------���÷ָ���---------------------
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setLayout(new GridLayout(GridData.FILL_BOTH, false));

		selectList = new List(sashForm, SWT.BORDER); // �ָ����ߵ�list�б�
		selectList.setItems(new String[] { "��������", "��ϵ��ʽ" });
		selectList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// ���list�е�ѡ�����

			}
		});

		rightComp = new Composite(sashForm, SWT.NONE); // �ұ��Ƕ�ջʽ ������
		rightComp.setLayout(stackLayout);

		// ��Ϊ��ҳ��������ҳ��Ĵ�����ȡ��Ϊ���������ڴ��������
		yourDataComp = createYourDataComp(rightComp);
		otherComp = createOtherComp(rightComp);

		stackLayout.topControl = yourDataComp; // ��"��������"������ڶ���
		sashForm.setWeights(new int[] { 1, 4 }); // �ָ�����ҿռ�ı���

		// ---------------�ײ���ť�����--------------------------
		Composite buttonComp = new Composite(shell, SWT.NONE);
		// ʹ��GridData�ð�ť�������������shell���Ҷ˶���
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.END;
		buttonComp.setLayoutData(gridData);

		// ���ð�ť����ڰ�ť������ʽ���֣���ť���Ϊ15����
		RowLayout rowLayout = new RowLayout();
		rowLayout.spacing = 15;
		buttonComp.setLayout(rowLayout);

		// ��buttonComp�����д���������ť
		new Button(buttonComp, SWT.NONE).setText("  ȷ��     ");
		new Button(buttonComp, SWT.NONE).setText("  ȡ��     ");
		new Button(buttonComp, SWT.NONE).setText("  Ӧ��     ");

		shell.layout(); // �൱��ˢ��
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	// "��������"������ɷ���
	private Composite createYourDataComp(Composite rightComp) {
		Composite comp = new Composite(rightComp, SWT.NONE);
		comp.setLayout(new GridLayout(6, false)); // ���ռ�ֳ�6�У������಻���

		new Label(comp, SWT.NONE).setText("�û����룺");

		return comp;
	}

	// "��ϵ����"������ɷ���
	private Composite createOtherComp(Composite rightComp) {

		Composite comp = new Composite(rightComp, SWT.NONE);
		comp.setLayout(new FillLayout());
		new Label(comp, SWT.NONE).setText("��ϵ��ʽ���");
		return comp;
	}

}
