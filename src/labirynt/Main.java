package labirynt;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		int[][] labirynt = {
			 {0,0,0,0,0,0,0,0},
			 {3,0,3,3,3,3,3,0},
			 {0,0,3,0,0,0,0,0},
			 {0,3,3,0,0,0,0,3},
			 {0,0,3,3,0,0,0,3},
			 {2,0,0,0,0,3,0,1},
		};
		
		PathFinder pFinder = new PathFinder();
		Coordinate start_point = pFinder.getStartPoint(labirynt);
		Coordinate end_point = pFinder.getEndPoint(labirynt);
		pFinder.setPriorities(start_point, end_point);
		pFinder.findPathes(labirynt, start_point, end_point);
		pFinder.printLab(labirynt);
		ArrayList<Coordinate> path = pFinder.findBestPath();
		if (path == null)
			return;
		
		for (Coordinate coordinate : path) {
			labirynt[coordinate.getY()][coordinate.getX()] = 5;
		}
		pFinder.printLab(labirynt);
	}
}
