/**
 * @author welcome
 *
 */
package eg.edu.alexu.csd.datastructure.maze.cs29;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
/**
 * MazeSolver Class.
 */
public class MazeSolver implements IMazeSolver {
   /** n & m maze array dimensions.*/
  private int n, m;
  /** k & l coordinates of start point.*/
  private int k, l;
  /** locationsArray is the path steps stored in a list.*/
  private ArrayList<int[][]> locationsArray;
  /** visited array to mark visited cells.*/
  private boolean[][] visitedArray;
  /** maze array is where the maze cells are stored.*/
  private String[] mazeArray;
  /** foundGoal flag to stop the recursion when Exit is found.*/
  private boolean foundGoal;
  /** foundS flag to check if the maze has no start.*/
  private boolean foundS;
  /** foundE flag to check if the maze has no Exit.*/
  private boolean foundE;

  /**constructor to set variables.*/
  private void constructVariables() {
    this.locationsArray = new ArrayList<int[][]>();
    this.visitedArray = new boolean[this.n][this.m];
    this.mazeArray = new String[this.n];
    this.foundGoal = false;
    this.foundS = false;
    this.foundE = false;


  }
  /**
  * Read the maze file, and solve it using Breadth First Search.
  * @param maze maze file
  * @return the coordinates of the found path from point 'S'
  * to point 'E' inclusive, or null if no path found.
  * coordinates indexes are zero based.
  */
  @Override
  public int[][] solveBFS(final File maze) {
    readFromFile(maze);
    if (!foundS || !foundE) {
      throw null;
    }
    recursionBFS(k, l);
    int[][] locations = new int[locationsArray.size()][2];
    int i = 0;
    while (i < locationsArray.size()) {
      locations[i][0] = locationsArray.get(i)[0][0];
      locations[i][1] = locationsArray.get(i)[0][1];
      i++;
    }
    if (foundGoal) {
      return locations;
    } else {
      return null;
    }
  }
  /**
  * Read the maze file, and solve it using Depth First Search.
  * @param maze maze file
  * @return the coordinates of the found path from point 'S'
  * to point 'E' inclusive, or null if no path found.
  * coordinates indexes are zero based.
  */
  @Override
  public int[][] solveDFS(final File maze) {
    readFromFile(maze);
    if (!foundS || !foundE) {
      throw null;
    }

    recursionDFS(k, l);
    int[][]startCoor = new int[1][2];
    startCoor[0][0] = k;
    startCoor[0][1] = l;
    locationsArray.add(startCoor);
    int[][] locations = new int[locationsArray.size()][2];
    int i = 0;
    while (i < locationsArray.size()) {
      locations[i][0] = locationsArray.get(locationsArray.size() - 1 - i)[0][0];
      locations[i][1] = locationsArray.get(locationsArray.size() - 1 - i)[0][1];
      i++;
    }
    if (foundGoal) {
      return locations;
    } else {
      return null;
    }
  }
  /**
   * @param file to read the mazeArray
   */
  private void readFromFile(final File file) {
    //int z = 0;
    try {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String str = br.readLine();
    int[] intArray = stringArrayToIntArray(str);
    this.n = intArray[0];
    this.m = intArray[1];
    constructVariables();
    for (int i = 0; i < this.n; i++) {
      //z++;
      this.mazeArray[i] = br.readLine();
      if (this.mazeArray[i].indexOf('S') >= 0) {
        this.k = i;
        this.l = this.mazeArray[i].indexOf('S');
        foundS = true;
      }
      if (this.mazeArray[i].indexOf('E') >= 0) {
        foundE = true;
      }
    }
    //z++;
    br.close();
    } catch (Exception e) {
      throw null;
    }
    //not working // i think problem in condition for br.readLine() != null
//    if (z != this.n) {
//      throw null;
//    }
//    for (int i = 0; i < mazeArray.length; i++) {
//      if (mazeArray[i].length() != this.m) {
//        throw null;
//      }
//    }
  }
  /**
   * @param intString to get dimensions
   * @return array of dimensions
   */
  public static int[] stringArrayToIntArray(final String intString) {
    String[] intStringSplit = intString.split(" ");
    int[] result = new int[intStringSplit.length];
    for (int i = 0; i < intStringSplit.length; i++) {
        result[i] = Integer.parseInt(intStringSplit[i]);
    }
    return result;
}

  /**
   * DFS recursion.
   * @param o and
   * @param p for start
   */
  private void recursionDFS(final int o, final int p) {
    for (int j = 1; j <= -1; j--) {
      for (int i = 1; i <= -1; i--) {
        if ((o + i) < n && (o + i) >= 0 && (p + j) < m
            && (p + j) >= 0 && i != j && (i + j) != 0
            && !this.visitedArray[o + i][p + j]) {
          this.visitedArray[o + i][p + j] = true;
          if (this.mazeArray[o + i].charAt(p + j) == '#') {
            continue;
          } else if (this.mazeArray[o + i].charAt(p + j) == '.') {
            recursionDFS(o + i, p + j);
          } else if (this.mazeArray[i + o].charAt(p + j) == 'E') {
            this.foundGoal = true;
          }
        }
        if (this.foundGoal) {
          int[][] tempArr = new int[1][2];
          tempArr[0][0] = o + i;
          tempArr[0][1] = p + j;
          this.locationsArray.add(tempArr);
          break;
        }
      }
      if (this.foundGoal) {
        break;
      }
    }
  }

  /**
   * BFS recursion.
   * @param o and
   * @param p for start
   */
  private void recursionBFS(final int o, final int p) {
    for (int j = 1; j <= -1; j--) {
      for (int i = 1; i <= -1; i--) {
        if ((o + i) < n && (o + i) >= 0 && (p + j) < m
            && (p + j) >= 0 && i != j && (i + j) != 0
            && !this.visitedArray[o + i][p + j]) {
          this.visitedArray[o + i][p + j] = true;
          if (this.mazeArray[o + i].charAt(p + j) == '#') {
            continue;
          } else if (this.mazeArray[o + i].charAt(p + j) == '.') {
            recursionDFS(o + i, p + j); //dequeue & enqueue
          } else if (this.mazeArray[i + o].charAt(p + j) == 'E') {
            this.foundGoal = true;
          }
        }
        if (this.foundGoal) {
          int[][] tempArr = new int[1][2];
          tempArr[0][0] = o + i;
          tempArr[0][1] = p + j;
          this.locationsArray.add(tempArr);
          break;
        }
      }
      if (this.foundGoal) {
        break;
      }
    }
  }

}
