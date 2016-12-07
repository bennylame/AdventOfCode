package day1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

public class December1Part1 {

	public static String theString = "";
	public static Scanner sc;
	public static char current;

	public static void main(String[] args) throws FileNotFoundException {



		int numberOfBlocks = calculateBlocks();
		System.out.println(numberOfBlocks);

	}

	public static int calculateBlocks() throws FileNotFoundException {
		FileInputStream fin = new FileInputStream(
				new File(
						"/Users/bennylam/Documents/workspace/AdventOfCode/src/day1/input.txt"));
		sc = new Scanner(fin, "UTF-8").useDelimiter(", ");
		int blocksAway = 0;

		current = 'N';
		int x = 0;
		int y = 0;

		String[] direction = null;

		while (sc.hasNext()) {
			direction = sc.next().split(" ");

		
				if (current == 'N') {
					if (direction[0].charAt(0) == 'L') {
						int steps = Integer.parseInt(direction[0].substring(1,
								direction[0].length()));
						x -= steps;
						current = 'W';

					} else if (direction[0].charAt(0) == 'R') {
						int steps = Integer.parseInt(direction[0].substring(1,
								direction[0].length()));
						x += steps;
						current = 'E';
					}

				} else if (current == 'S') {

					if (direction[0].charAt(0) == 'L') {
						int steps = Integer.parseInt(direction[0].substring(1,
								direction[0].length()));
						x += steps;
						current = 'E';

					} else if (direction[0].charAt(0) == 'R') {
						int steps = Integer.parseInt(direction[0].substring(1,
								direction[0].length()));
						x -= steps;
						current = 'W';
					}

				} else if (current == 'W') {

					if (direction[0].charAt(0) == 'L') {
						int steps = Integer.parseInt(direction[0].substring(1,
								direction[0].length()));
						y -= steps;
						current = 'S';

					} else if (direction[0].charAt(0) == 'R') {
						int steps = Integer.parseInt(direction[0].substring(1,
								direction[0].length()));
						y += steps;
						current = 'N';

					}

				} else if (current == 'E') {

					if (direction[0].charAt(0) == 'L') {
						int steps = Integer.parseInt(direction[0].substring(1,
								direction[0].length()));
						y += steps;
						current = 'N';

					} else if (direction[0].charAt(0) == 'R') {
						int steps = Integer.parseInt(direction[0].substring(1,
								direction[0].length()));
						y -= steps;
						current = 'S';
					}

				
			
			}

		}
		
		sc.close();
		blocksAway = Math.abs(x) + Math.abs(y);
		return blocksAway;

	}
}
