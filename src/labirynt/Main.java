package labirynt;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		int[][] labirynt = {
			 {0,0,0,0,0,0,2,0},
			 {3,0,3,3,3,3,3,0},
			 {0,0,3,0,0,0,0,0},
			 {0,3,3,0,0,0,0,0},
			 {0,0,3,3,0,0,0,0},
			 {0,0,0,0,0,3,3,1},
		};
		
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
