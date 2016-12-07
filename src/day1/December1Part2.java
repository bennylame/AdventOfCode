package day1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class December1Part2 {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		// 2 ways to read in a file: Scanner or BufferedReader

		// Scanner
		FileInputStream fin = new FileInputStream(
				new File(
						"/Users/bennylam/Documents/workspace/AdventOfCode/src/day1/input.txt"));
		Scanner sc = new Scanner(fin, "UTF-8");
		sc.close();
		
		// BufferedReader
		FileReader fr = new FileReader(
				new File(
						"/Users/bennylam/Documents/workspace/AdventOfCode/src/day1/input.txt"));

		BufferedReader br = new BufferedReader(fr);
		String[] directions = br.readLine().split(", ");
		br.close();

		System.out.println("Directions Length: " + directions.length);
		
		blocksAway(directions, directions.length);
		
		
		/* Brainstorm 
		 * Coor[0] = 0,0
		 * 
		 * If R4
		 * 
		 * Coor[0] = 0,0
		 * Coor[1] = 1,0
		 * Coor[2] = 2,0
		 * Coor[3] = 3,0
		 * Coor[4] = 4,0
		 * 
		 */
	

	}

	public static Set<String> duplicateCheck(String[] coordinates) {
		// Check for duplicates
		boolean duplicate = false;
		int i = 0;

		Set<String> store = new HashSet<>();
		
		for (String coordinate : coordinates) {
			if (duplicate) {
				break;
			}
			if (store.add(coordinate) == false) {
				System.out.println("Blocks visited twice: " + coordinate
						+ " iteration: " + i);
				duplicate = true;
				String[] blocksaway = coordinate.split(",");
				int howFar = Math.abs(Integer.parseInt(blocksaway[0]))
						+ Math.abs(Integer.parseInt(blocksaway[1]));
				System.out
						.println("Blocks away to duplicated block: " + howFar);
			}
			i++;
		}
		return store;
	}

	public static void blocksAway(String[] directions, int i) {
		int x = 0;
		int y = 0;
		Set<String> store = new HashSet<>();
		char current = 'N';
		String coord = "";
		coord = x+","+y;

		store.add(coord);
		
		for (int j = 0; j < i; j++) {
			int steps = Integer.parseInt(directions[j].substring(1,
					directions[j].length()));

			if (directions[j].charAt(0) == 'L') {
				switch (current) {
				case 'N':		
					for (int k = 0; k < steps; k++) {
						x --;
						coord = x+","+y;
						if (store.add(coord) == false) {
							System.out.println("duplicate");
							System.out.println(coord);
						}
					}
				//	x -= steps;
					current = 'W';
					break;
				case 'S':
					for (int k = 0; k < steps; k++) {
						x ++;
						coord = x+","+y;
						if (store.add(coord) == false) {
							System.out.println("duplicate");
							System.out.println(coord);
						}
					}
				//	x += steps;
					current = 'E';
					break;
				case 'E':
					for (int k = 0; k < steps; k++) {
						y ++;
						coord = x+","+y;
						if (store.add(coord) == false) {
							System.out.println("duplicate");
							System.out.println(coord);
						}
					}
					//y += steps;
					current = 'N';
					break;
				case 'W':
					for (int k = 0; k < steps; k++) {
						y --;
						coord = x+","+y;
						if (store.add(coord) == false) {
							System.out.println("duplicate");
						}
					}
					//y -= steps;
					current = 'S';
					break;

				}
			} else if (directions[j].charAt(0) == 'R') {
				switch (current) {
				case 'N':
					for (int k = 0; k < steps; k++) {
						x ++;
						coord = x+","+y;
						if (store.add(coord) == false) {
							System.out.println("duplicate");
							System.out.println(coord);
						}
					}
					//x += steps;
					current = 'E';
					break;
				case 'S':
					for (int k = 0; k < steps; k++) {
						x--;
						coord = x+","+y;
						if (store.add(coord) == false) {
							System.out.println("duplicate");
							System.out.println(coord);
						}
					}
					//x -= steps;
					current = 'W';
					break;
				case 'E':
					for (int k = 0; k < steps; k++) {
						y --;
						coord = x+","+y;
						if (store.add(coord) == false) {
							System.out.println("duplicate");
							System.out.println(coord);
						}
					}
					//y -= steps;
					current = 'S';
					break;
				case 'W':
					for (int k = 0; k < steps; k++) {
						y ++;
						coord = x+","+y;
						if (store.add(coord) == false) {
							System.out.println("duplicate");
							System.out.println(coord);
						}
					}
				//	y += steps;
					current = 'N';
					break;
				}
			}

			// coordinates[j] = Integer.toString(x)+ ","+ Integer.toString(y);
			System.out.println("Direction " + directions[j] + " Current: "
					+ current + " x: " + x + " y: " + y);
			// System.out.println("Coordinates: " + coordinates[j]);
			System.out.println("Blocks away: " + (Math.abs(x) + Math.abs(y)));
		}
	}

}
