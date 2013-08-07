package com.verphen.module;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CanvasDemo {
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(display);

		// -----------code start --------------------

		shell.setLayout(new RowLayout());
		final Canvas canvas = new Canvas(shell, SWT.BORDER);

		canvas.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {

				Image image = (Image) canvas.getData();
				if (image != null) {
					e.gc.drawImage(image, 10, 10);
				}
			}
		});

		final Image freshImage = new Image(display, "1.gif");
		final Image nextImage = new Image(display, "2.gif");

		Button button1 = new Button(shell, SWT.None);
		button1.setText("ͼƬ1");
		button1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				canvas.setData(nextImage);
				canvas.redraw();
			}
		});

		Button button2 = new Button(shell, SWT.None);
		button2.setText("ͼƬ2");
		button2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				canvas.setData(freshImage);
				canvas.redraw();
			}
		});

		Button cleanButton = new Button(shell, SWT.None);
		cleanButton.setText("���ͼƬ");
		cleanButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				canvas.setData(null);
				canvas.redraw();
			}
		});

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
