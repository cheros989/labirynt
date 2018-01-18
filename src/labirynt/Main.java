package labirynt;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		int[][] labirynt = {
			 {0,0,0,0,0,0,0,2},
			 {0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0},
			 {0,0,0,0,0,0,0,0},
			 {1,0,0,0,0,0,0,0},
		};
		
		PathFinder pFinder = new PathFinder();
		Coordinate start_point = pFinder.getStartPoint(labirynt);
		Coordinate end_point = pFinder.getEndPoint(labirynt);
		pFinder.findPathes(labirynt, start_point, end_point);
		pFinder.printLab(labirynt);
		ArrayList<Coordinate> path = pFinder.findBestPath();
		if (path == null)
			return;
		
		System.out.println("  "+PathFinder.pathes.size());
		for (Coordinate coordinate : path) {
			labirynt[coordinate.getY()][coordinate.getX()] = 5;
		}
		pFinder.printLab(labirynt);
	}
}
