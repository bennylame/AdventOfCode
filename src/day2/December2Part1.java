package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class December2Part1 {
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		// System.out.println(new File(".").getAbsolutePath());

		FileReader fr = new FileReader(
				new File(
						"/Users/bennylam/Documents/workspace/AdventOfCode/src/day2/inputSecond.txt"));

		BufferedReader br = new BufferedReader(fr);
	
		// 1 2 3
		// 4 5 6
		// 7 8 9

		// How should I represent the keypad?

		// If 1 + U/L = 1
		// If 4 + L = 4
		// if 7 + D/L = 7

		// If 2 + U = 2
		// If 8 + D = 8

		// If 3 + U/R = 3
		// If 6 + R = 6;
		// If 9 + D/R = 9

		// Improvements can be done by representing the keypad in an two
		// dimensional array with x and y coordinates.
		int i = 1;
		while (br.ready()) {
			String keypad = br.readLine();
			int fingerOnKey = DetermineKey(keypad);
			System.out.println("Key number " + i + ":" + fingerOnKey);
			i++;
		}
		br.close();
	}
	
	public static int DetermineKey(String input) {
		int fingerOnKey = 5;

		for (int i = 0; i < input.length(); i++) {
			char direction = input.charAt(i);
			switch (fingerOnKey) {
			case 1:
				switch (direction) {
				case 'U':
					break;
				case 'D':
					fingerOnKey = 4;
					break;
				case 'L':
					break;
				case 'R':
					fingerOnKey = 2;
					break;
				}
				break;
			case 2:
				switch (direction) {
				case 'U':
					break;
				case 'D':
					fingerOnKey = 5;
					break;
				case 'L':
					fingerOnKey = 1;
					break;
				case 'R':
					fingerOnKey = 3;
					break;
				}
				break;
			case 3:
				switch (direction) {
				case 'U':
					break;
				case 'D':
					fingerOnKey = 6;
					break;
				case 'L':
					fingerOnKey = 2;
					break;
				case 'R':
					break;
				}
				break;
			case 4:
				switch (direction) {
				case 'U':
					fingerOnKey = 1;
					break;
				case 'D':
					fingerOnKey = 7;
					break;
				case 'L':
					break;
				case 'R':
					fingerOnKey = 5;
					break;
				}
				break;
			case 5:
				switch (direction) {
				case 'U':
					fingerOnKey = 2;
					break;
				case 'D':
					fingerOnKey = 8;
					break;
				case 'L':
					fingerOnKey = 4;
					break;
				case 'R':
					fingerOnKey = 6;
					break;
				}
				break;
			case 6:
				switch (direction) {
				case 'U':
					fingerOnKey = 3;
					break;
				case 'D':
					fingerOnKey = 9;
					break;
				case 'L':
					fingerOnKey = 5;
					break;
				case 'R':
					break;
				}
				break;
			case 7:
				switch (direction) {
				case 'U':
					fingerOnKey = 4;
					break;
				case 'D':
					break;
				case 'L':
					break;
				case 'R':
					fingerOnKey = 8;
					break;
				}
				break;
			case 8:
				switch (direction) {
				case 'U':
					fingerOnKey = 5;
					break;
				case 'D':
					break;
				case 'L':
					fingerOnKey = 7;
					break;
				case 'R':
					fingerOnKey = 9;
					break;
				}
				break;
			case 9:
				switch (direction) {
				case 'U':
					fingerOnKey = 6;
					break;
				case 'D':
					break;
				case 'L':
					fingerOnKey = 8;
					break;
				case 'R':
					break;
				}
				break;

			}
		}
		return fingerOnKey;
	}

}
