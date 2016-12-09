package day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class December2Part2 {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		FileInputStream fis = new FileInputStream(
				new File(
						"/Users/bennylam/Documents/workspace/AdventOfCode/src/day2/inputSecond.txt"));

		Scanner sc = new Scanner(fis);

		int x = 0;
		int y = 2;
		char[][] keypad = new char[][] { { '0', '0', '1', '0', '0' },
				{ '0', '2', '3', '4', '0' }, { '5', '6', '7', '8', '9' },
				{ '0', 'A', 'B', 'C', '0' }, { '0', '0', 'D', '0', '0' } };

		// System.out.println(keypad[y][x]);

		while (sc.hasNext()) {
			String s = sc.nextLine();

			for (int i = 0; i < s.length(); i++) {
			//	System.out.println("Current Letter: " + s.charAt(i) + " (" + y
				//		+ "," + x + ")");

				if ((s.charAt(i) == 'U' && y == 0)
						|| (s.charAt(i) == 'D' && y == 4)
						|| (s.charAt(i) == 'L' && x == 0)
						|| (s.charAt(i) == 'R' && x == 4)) {
					continue;
				} else if (s.charAt(i) == 'U' && keypad[y - 1][x] == '0'
						|| s.charAt(i) == 'D' && keypad[y + 1][x] == '0'
						|| s.charAt(i) == 'L' && keypad[y][x-1] == '0'
						|| s.charAt(i) == 'R' && keypad[y][x+1] == '0') {
					continue;
				} else {
					switch (s.charAt(i)) {
					case 'U':
						y--;
						break;
					case 'D':
						y++;
						break;
					case 'L':
						x--;
						break;
					case 'R':
						x++;
						break;
					}
				}
			//	System.out.println("Next coord: " + "(" + y + "," + x + ")");
			}
			System.out.println(keypad[y][x]);

		}
	}
}
