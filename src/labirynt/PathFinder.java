package labirynt;

import java.util.ArrayList;
import java.util.HashMap;

public class PathFinder {
	
	public static Coordinate bestPath = null;
	
	public void findPathes(int[][] labirynt, ArrayList<Coordinate> variants, Coordinate end_point) {
		
		ArrayList<Coordinate> new_vars = new ArrayList<>();
		for (Coordinate coordinate : variants) {
			if (coordinate.equ(end_point)) {
				System.out.println("BEST PATH WAS FINDED:");
				findPathTo(coordinate, labirynt);
				return;
			}
			labirynt[coordinate.getY()][coordinate.getX()] = 7;
			new_vars.addAll(coordinate.getVariants(labirynt));
		}
		if (new_vars.isEmpty()) {
			System.out.println("no way");
			return;
		}
		findPathes(labirynt, new_vars, end_point);
	}
	
	public void findPathTo (Coordinate coordinate, int[][] labirynt) {
		labirynt[coordinate.getY()][coordinate.getX()] = 5;
		if (coordinate.getPrevCoordinate() == null) {
			return;
		}
		findPathTo(coordinate.getPrevCoordinate(), labirynt);
	}
	
	public HashMap<String, Coordinate> getStartEndPoints(int[][] labirynt) {
		HashMap<String, Coordinate> coords = new HashMap<>();
		for (int i = 0; i < labirynt.length; i++) {
			for (int j = 0; j < labirynt[i].length; j++) {
				if (labirynt[i][j] == 1) {
					coords.put("start", new Coordinate(j, i));
				}
				if (labirynt[i][j] == 2) {
					coords.put("end", new Coordinate(j, i));
				}
			}
		}
		return coords;
	}
	
	
	public void printLab(int[][] labirynt) {
		String string = "";
		for (int i = 0; i < labirynt.length; i++) {
			for (int j = 0; j < labirynt[i].length; j++) {
				string += String.valueOf(labirynt[i][j]);
			}
			string += "\r\n";
		}
		System.out.print(string);
	}
	
}
