package org.devon.data.string.split;

/**
 * @author Devon
 *
 */
public class SubStringDemo {
	public static void main(String[] args) {
		SubStringDemo stringSplitDemo = new SubStringDemo();
		stringSplitDemo.Stirngtrate();
	}

	//
	public void Stirngtrate() {
		String N = "I HATE YOU";
		String L = "";
		String R = "";
		int k = N.length();
		for (int i = 0; i < N.length(); i++) {
			System.out.println("i=" + i);
			if (N.substring(i, i + 1).equals(" ")) {

				L = N.substring(0, i).trim();
				R = N.substring(i + 1, k).trim();
				// System.out.println(L + R);
			}

		}
		System.out.println("L=" + L);
		System.out.println("R=" + R);
	}

}
