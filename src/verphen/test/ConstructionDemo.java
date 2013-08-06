/**
 * @author Verphen
 * @date 2013��8��1��  ����10:53:47
 */

package verphen.test;

public class ConstructionDemo {
	public static String str = "verphen";

	public ConstructionDemo() {
		this(str);
		System.out.println("none arguments construction");
	}

	public ConstructionDemo(String str) {
		System.out.println("a argument str :" + str);
	}

	public static void main(String[] args) {
		System.out.println("main method ");
		new ConstructionDemo();

	}
}
