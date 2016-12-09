package day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class December3Part2 {
	public static void main(String[] args) throws IOException,
			FileNotFoundException {
		FileInputStream fis = new FileInputStream(
				new File(
						"/Users/bennylam/Documents/workspace/AdventOfCode/src/day3/input.txt"));

		Scanner sc = new Scanner(fis);
		ArrayList<String> list = new ArrayList<>();
		int numberOfValidTriangles = 0;

		// Klar
		while (sc.hasNext()) {
			list.add(sc.next());
		}

		//
		for (int i = 0; i < list.size()-6; i+=9) {
			numberOfValidTriangles += isTriangle(Integer.parseInt(list.get(i)),
					Integer.parseInt(list.get(i + 3)),
					Integer.parseInt(list.get(i + 6)));
		
			numberOfValidTriangles += isTriangle(Integer.parseInt(list.get(i+1)),
					Integer.parseInt(list.get(i + 4)),
					Integer.parseInt(list.get(i + 7)));
			
			numberOfValidTriangles += isTriangle(Integer.parseInt(list.get(i+2)),
					Integer.parseInt(list.get(i + 5)),
					Integer.parseInt(list.get(i + 8)));
		
		
			System.out.println(numberOfValidTriangles);
		}
		sc.close();

	}

	public static int isTriangle(int a, int b, int c) {
		int temp;

		if (a > c) {
			temp = c;
			c = a;
			a = temp;
			if (a > b) {
				temp = b;
				b = a;
				a = temp;
			} else if (b > c) {
				temp = c;
				c = b;
				b = temp;
			}
		} else if (b > c) {
			temp = c;
			c = b;
			b = temp;
		}

		if (a + b > c) {
			return 1;
		}
		return 0;
	}
}
