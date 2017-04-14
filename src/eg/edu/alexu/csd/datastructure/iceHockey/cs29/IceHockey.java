/**
 */
package eg.edu.alexu.csd.datastructure.iceHockey.cs29;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
/**
 */
public class IceHockey implements IPlayersFinder {
	/**
	 */
	private final int thersholdDivisionNumber = 4;
	/**
	 */
	private String[] photoGlobal;
	/**
	 */
	private int teamGlobal, count = 0, m, n;
	/**
	 */
	private Point coordinatesMax = new Point(0, 0),
			coordinatesMin = new Point(0, 0);
	/**
	 */
	private boolean[][] maskGlobal;
	/**
	 * @param row for row
	 * @param col for column
	 * @return coordinates
	 */
	final int settingLocations(final int row, final int col) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
			if ((row + i) >= 0 && (row + i) < m && (col + j) >= 0
				&& (col + j) < n && i != j && (i + j) != 0) {
			if (photoGlobal[row + i].charAt(col + j)
					== (char) (teamGlobal + '0')
					&& !maskGlobal[row + i][col + j]) {
					maskGlobal[row + i][col + j] = true;
						count++;
					if (coordinatesMax.x < (row + i)) {
						coordinatesMax.x = row + i;
					}
					if (coordinatesMin.x > (row + i)) {
						coordinatesMin.x = row + i;
					}
					if (coordinatesMax.y < (col + j)) {
						coordinatesMax.y = col + j;
					}
					if (coordinatesMin.y > (col + j)) {
						coordinatesMin.y = col + j;
					}
					settingLocations(row + i, col + j);
					}
				}
			}
		}
		return count;
	}
	/**
	 */
	@Override
	public Point[] findPlayers(final String[] photo, final int team,
			final int threshold) {

		if (photo == null || photo.length == 0) {
			return null;
		}
		teamGlobal = team;
		photoGlobal = photo;
		m = photo.length;
		n = photo[0].length();
		List<Point> playersLocationsList = new ArrayList<Point>();

		boolean[][] mask = new boolean[m][n];

		maskGlobal = mask;
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
		if (photo[i].charAt(j) == (char) (team + '0') && !mask[i][j]) {
					maskGlobal[i][j] = true;
					count++;
					coordinatesMax.x = i;
					coordinatesMax.y = j;
					coordinatesMin.x = i;
					coordinatesMin.y = j;
					count = settingLocations(i, j);
					if (count >= ((float) threshold
					/ (float) thersholdDivisionNumber)) {
		Point tempPoint = new Point(coordinatesMax.y + coordinatesMin.y
				+ 1, coordinatesMax.x + coordinatesMin.x + 1);
					playersLocationsList.add(tempPoint);
					}
					count = 0;
				}
			}
		}
	    Point[] playersLocations = playersLocationsList.toArray(new Point
		[playersLocationsList.size()]);

		Arrays.sort(playersLocations, new Comparator<Point>() {
		      public int compare(final Point a, final Point b) {
		       int xComp = Integer.compare(a.x, b.x);
		        if (xComp == 0) {
		            return Integer.compare(a.y, b.y);
		        } else {
		            return xComp;
		        }
		    }
		});

		return playersLocations;
	}
}
