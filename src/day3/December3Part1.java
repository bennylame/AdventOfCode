package day3;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class December3Part1 {

	public static void main(String[] args) throws IOException,
			FileNotFoundException {

		FileReader fr = new FileReader(
				new File(
						"/Users/bennylam/Documents/workspace/AdventOfCode/src/day3/input.txt"));

		BufferedReader br = new BufferedReader(fr);

		int numberOfInvalidTriangles = 0;

		// 0 1 2
		// 0 2 1
		// 1 0 2
		// 1 2 0
		// 2 1 0
		// 2 0 1

		while (br.ready()) {
			String[] triangle = br.readLine().split(
					"\\s\\s\\s\\s|\\s\\s\\s|\\s\\s");
			// String[] triangle = br.readLine().split("\\s\\s ");
		//	System.out.println("Triangle with side: a:" + triangle[1] + " b: "
			//		+ triangle[2] + " c: " + triangle[3]);
			if (Integer.parseInt(triangle[1]) > Integer.parseInt(triangle[3])) {
				String temp = triangle[3];
				triangle[3] = triangle[1];
				triangle[1] = temp;
				if (Integer.parseInt(triangle[1]) > Integer
						.parseInt(triangle[2])) {
					temp = triangle[2];
					triangle[2] = triangle[1];
					triangle[1] = temp;
				} else if (Integer.parseInt(triangle[2]) > Integer
						.parseInt(triangle[3])) {
					temp = triangle[3];
					triangle[3] = triangle[2];
					triangle[2] = temp;
				}
			} else if (Integer.parseInt(triangle[2]) > Integer.parseInt(triangle[3])) {
				String temp = triangle[3];
				triangle[3] = triangle[2];
				triangle[2] = temp;
			}
			int a = Integer.parseInt(triangle[1]);
			int b = Integer.parseInt(triangle[2]);
			int c = Integer.parseInt(triangle[3]);

		//	System.out.println("Triangle with side(update): a:" + triangle[1] + " b: "
		//	+ triangle[2] + " c: " + triangle[3]);
			
			if (a + b > c) {
				numberOfInvalidTriangles++;
					System.out.println("Triangle with side(update): a:" + triangle[1] + " b: "
					+ triangle[2] + " c: " + triangle[3]);

			}

		}
		/*
		 * int j = 0; while (j < 4) { String[] triangle =
		 * br.readLine().split("\\s\\s\\s\\s|\\s\\s\\s|\\s\\s");
		 * 
		 * for (int i = 0; i < triangle.length; i++) {
		 * System.out.println("Triangle: " + triangle[i]); }j++; }
		 */

		System.out.println(numberOfInvalidTriangles);

	}

}
