package labirynt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = null;
		int[][] labirynt = null;
		try {
			scanner = new Scanner(new File(args[0]));
			String first_line[] = scanner.nextLine().split(" ");
			labirynt = new int[Integer.parseInt(first_line[1])][Integer.parseInt(first_line[0])];
			int row = 0;
			while (scanner.hasNextLine()) {
				String line[] = scanner.nextLine().split("");
				int col = 0;
				for (String s : line) {
					labirynt[row][col] = Integer.parseInt(s);
					col++;
				}
				row++;
			}
		} catch (FileNotFoundException|ArrayIndexOutOfBoundsException|NumberFormatException e) {
			System.err.println("Invalid date. Enter equal size of labirynt or greater.\r\n"
					+ "Example for you: \r\n"
					+ "5 5\r\n"
					+ "10000\r\n"
					+ "00033\r\n"
					+ "00030\r\n"
					+ "33033\r\n"
					+ "02000\r\n");
			return;
		} finally {
			scanner.close();
		}
		
		PathFinder pFinder = new PathFinder();
		HashMap<String, Coordinate> points = pFinder.getStartEndPoints(labirynt);
		Coordinate end_point = points.get("end");
		Coordinate start_point = points.get("start");
		ArrayList<Coordinate> variants = new ArrayList<>();
		variants.add(start_point);
		pFinder.findPathes(labirynt, variants, end_point);
		pFinder.printLab(labirynt);
	}
}
