package labirynt;

import java.util.ArrayList;

public class Coordinate {
	private int x;
	private int y;
	private Coordinate prevCoordinate;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
		prevCoordinate = null;
	}
	
	public Coordinate(int x, int y, Coordinate prevCoordinate) {
		this.x = x;
		this.y = y;
		this.prevCoordinate = prevCoordinate;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean equ(Coordinate coordinate) {
		return this.x == coordinate.x && this.y == coordinate.y;
	}
	
	public Coordinate getPrevCoordinate() {
		return prevCoordinate;
	};
	public ArrayList<Coordinate> getVariants(int[][] labirynt) {
		ArrayList<Coordinate> variants = new ArrayList<>();
		addUp(variants, labirynt);
		addRight(variants, labirynt);
		addLeft(variants, labirynt);
		addDown(variants, labirynt);
		return variants;
	}
	
	public void addRight(ArrayList<Coordinate> variants, int[][] labirynt) {
		if (x < labirynt[y].length - 1 && (labirynt[y][x+1] == 0 || labirynt[y][x+1] == 2)) {
			variants.add(new Coordinate(x+1, y, this));
		}
	}
	
	public void addLeft(ArrayList<Coordinate> variants, int[][] labirynt) {
		if (x > 0 && (labirynt[y][x-1] == 0 || labirynt[y][x-1] == 2)) {
			variants.add(new Coordinate(x-1, y, this));
		}
	}
	
	public void addDown(ArrayList<Coordinate> variants, int[][] labirynt) {
		if (y < labirynt.length - 1 && (labirynt[y+1][x] == 0 || labirynt[y+1][x] == 2)) {
			variants.add(new Coordinate(x, y+1, this));
		}
	}
	
	public void addUp(ArrayList<Coordinate> variants, int[][] labirynt) {
		if (y > 0 && (labirynt[y-1][x] == 0 || labirynt[y-1][x] == 2)) {
			variants.add(new Coordinate(x, y-1, this));
		}
	}
}
