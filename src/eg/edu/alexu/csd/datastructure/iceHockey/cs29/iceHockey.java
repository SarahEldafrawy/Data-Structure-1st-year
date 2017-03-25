package eg.edu.alexu.csd.datastructure.iceHockey.cs29;

import java.awt.Point;
import java.util.*;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class iceHockey implements IPlayersFinder {

	private String[] photoGlobal;
	private int teamGlobal, count = 0, m, n;
	Point CoordinatesMax = new Point(0, 0), CoordinatesMin = new Point(0, 0);

	private boolean[][] maskGlobal;

	int SettingLocations(int row,int col) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if ((row+i) >= 0 && (row+i) < m && (col+j) >= 0 && (col+j) < n && i != j && (i+j) != 0){
					if (photoGlobal[row+i].charAt(col+j) == (char) (teamGlobal+'0') && !maskGlobal[row+i][col+j]) {
						maskGlobal[row+i][col+j] = true;
						count++;
						if (CoordinatesMax.x < (row+i)) {
							CoordinatesMax.x = row+i;
						}
						if (CoordinatesMin.x > (row+i)) {
							CoordinatesMin.x = row+i;
						}
						if (CoordinatesMax.y < (col+j)) {
							CoordinatesMax.y = col+j;
						}
						if (CoordinatesMin.y > (col+j)) {
							CoordinatesMin.y = col+j;
						}
						SettingLocations(row+i, col+j);			
					}
				}
			}
		}
		return count;
	}

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {

		if (photo == null || photo.length == 0) {
			return null;
		}
		teamGlobal = team;
		photoGlobal = photo;
		m = photo.length;
		n = photo[0].length();
		List<Point> PlayersLocationsList = new ArrayList<Point>();

		boolean[][] mask = new boolean[m][n];

		maskGlobal = mask;
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				if (photo[i].charAt(j) == (char) (team+'0') && !mask[i][j]) {
					maskGlobal[i][j] = true;
					count++;
					CoordinatesMax.x = i;
					CoordinatesMax.y = j;
					CoordinatesMin.x = i;
					CoordinatesMin.y = j;
					count = SettingLocations(i,j);
					if (count >= ((float) threshold/(float) 4)) {
						Point TempPoint = new Point(CoordinatesMax.y+CoordinatesMin.y+1,CoordinatesMax.x+CoordinatesMin.x+1);
						PlayersLocationsList.add(TempPoint);
					}
					count = 0;
				}
			}
		}
		Point[] PlayersLocations = PlayersLocationsList.toArray(new Point[PlayersLocationsList.size()]);

		Arrays.sort(PlayersLocations, new Comparator<Point>() {
		      public int compare(Point a, Point b) {
		       int xComp = Integer.compare(a.x, b.x);
		        if (xComp == 0){
		            return Integer.compare(a.y, b.y);
		        }else {
		            return xComp;
		        }    
		    }
		});

		return PlayersLocations;
	}
}