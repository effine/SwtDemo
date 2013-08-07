package com.verphen.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BeatifulGraphic {

	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display, SWT.NO_TRIM);

		// -------------code start ----------------

		Region region = new Region();
		region.add(getBackRect1());
		region.add(getBackRect2());
		//
		region.subtract(circle(20, 400, 345));
		//
		shell.setRegion(region);
		Rectangle size = region.getBounds();
		shell.setSize(size.width, size.height);

		// ---------- code end ------------
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		region.dispose();
		display.dispose();
	}

	/*
	 * 制作第一个矩形，返回一个数组，数组包含矩形的四个点的坐标，逆时针连接就是一个矩形
	 */
	public static int[] getBackRect1() {
		int[] rect = new int[2 * 4];
		// A
		rect[0] = 0;
		rect[1] = 0;
		// B
		rect[2] = 0;
		rect[3] = 320;
		// C
		rect[4] = 520;
		rect[5] = 320;
		// D
		rect[6] = 520;
		rect[7] = 0;
		//
		return rect;
	}

	/*
	 * 如上方法，制作第二个矩形
	 */
	public static int[] getBackRect2() {
		int[] rect = new int[2 * 4];
		// E
		rect[0] = 50;
		rect[1] = 320;
		// F
		rect[2] = 50;
		rect[3] = 370;
		// G
		rect[4] = 470;
		rect[5] = 370;
		// H
		rect[6] = 470;
		rect[7] = 320;

		return rect;
	}

	/*
	 * 制作一个圆
	 */
	public static int[] circle(int r, int offsetX, int offsetY) {
		int[] ring = new int[8 * r + 4];
		// x^2 + y^2 = r^2
		for (int i = 0; i < 2 * r + 1; i++) {
			int x = i - r;
			int y = (int) Math.sqrt(r * r - x * x);
			ring[2 * i] = offsetX + x;
			ring[2 * i + 1] = offsetY + y;
			ring[8 * r - 2 * i - 2] = offsetX + x;
			ring[8 * r - 2 * i - 1] = offsetY - y;
		}
		return ring;
	}

}
