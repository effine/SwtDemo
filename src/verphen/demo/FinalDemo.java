/**
 * @author  arno
 * @version	 2013-6-14  обнГ05:14:31
 */

package verphen.demo;

public class FinalDemo {
	final int AGE = 12;

	public static void main(String[] args) {

		new FinalDemo().p();

	}

	public void p() {
		System.out.println(AGE);
	}

	public void editAge() {
	}
}
