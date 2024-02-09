package com.jayasanka.hakkerRank;

public class DataTypesIntTest {

	public static void main(String[] args) {

		String[] dataArr = new String[] {
				"9223372036854775808",
				"9223372036854775807",
				"-9223372036854775808",
				"-9223372036854775807",
				"4294967296",
				"4294967295",
				"-4294967296",
				"-4294967295",
				"65536",
				"65535",
				"-65536",
				"-65535",
				"256",
				"255",
				"-256",
				"-255",
				"12222222222222222222222222222222222222222221"
				};

		for (String data : dataArr) {

			try {
				long x = Long.parseLong(data);
				System.out.println(x + " can be fitted in:");

				if (x >= -128 && x <= 127)
					System.out.println("* byte");
				if (x >= Math.pow(-2, 15) && x <= (Math.pow(2, 15)-1))
					System.out.println("* short");
				if (x >= Math.pow(-2, 31) && x <= (Math.pow(2, 31)-1))
					System.out.println("* int");
				if (x >= Math.pow(-2, 63) && x <= (Math.pow(2, 63)-1))
					System.out.println("* long");

			} catch (Exception e) {
				System.out.println(data + " can't be fitted anywhere.");
			}

		}

	}

}
