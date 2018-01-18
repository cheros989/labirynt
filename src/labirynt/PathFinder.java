package labirynt;

import java.util.ArrayList;

public class PathFinder {
	
	public static ArrayList<Coordinate> bestPath = new ArrayList<>();
	public static ArrayList<Coordinate> pathes = new ArrayList<>();
	
	public void findPathes(int[][] labirynt, Coordinate start_point, Coordinate end_point) {
		
		if (start_point.equ(end_point)) {
			System.out.println("Path has been finded");
			pathes.add(start_point);
			return;
		}
		labirynt[start_point.getY()][start_point.getX()] = 7;
		for (Coordinate coordinate : start_point.getVariants(labirynt)) {
			findPathes(labirynt, coordinate, end_point);
		}
	}
	
	public ArrayList<Coordinate> findBestPath () {
		ArrayList<Coordinate> bestPath = new ArrayList<>();
		if (pathes.isEmpty()) {
			System.err.println("has not pathes");
			return null;
		}
		findPathSize(pathes.get(0));
		bestPath.addAll(PathFinder.bestPath);
		for (Coordinate path : pathes) {
			findPathSize(path);
			if (bestPath.size() > PathFinder.bestPath.size()) {
				bestPath.clear();
				bestPath.addAll(PathFinder.bestPath);
			}
		}
		return bestPath;
	}
	
	public Coordinate getStartPoint(int[][] labirynt) {
		for (int i = 0; i < labirynt.length; i++) {
			for (int j = 0; j < labirynt[i].length; j++) {
				if (labirynt[i][j] == 1) {
					return new Coordinate(j, i);
				}
			}
		}
		return null;
	}
	
	public Coordinate getEndPoint(int[][] labirynt) {
		for (int i = 0; i < labirynt.length; i++) {
			for (int j = 0; j < labirynt[i].length; j++) {
				if (labirynt[i][j] == 2) {
					return new Coordinate(j, i);
				}
			}
		}
		return null;
	}
	
	private void findPathSize(Coordinate end_point) {
		if (end_point.getPrevCoordinate() != null) {
			PathFinder.bestPath.add(end_point);
			findPathSize(end_point.getPrevCoordinate());
		}
	}
	
	public void printLab(int[][] labirynt) {
		String string = "";
		for (int i = 0; i < labirynt.length; i++) {
			for (int j = 0; j < labirynt[i].length; j++) {
				string += String.valueOf(labirynt[i][j]);
			}
			string += "\r\n";
		}
		System.out.println(string);
	}
	
}
