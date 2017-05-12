/**
 * @author welcome
 *
 */
package eg.edu.alexu.csd.datastructure.maze.cs29;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;

public class MazeSolver implements IMazeSolver {

  private int n,m,s,k,l;
  private int[][] locationsArray;
  private boolean[][] visitedArray;
  private String[] mazeArray;
  private boolean foundGoal;
  private boolean foundS;
  private boolean foundE;

  /**
   *constructor.
   */
  private void constructVariables() {
    this.s = 0;
    this.locationsArray = new int[this.n * 2 + this.m * 2][2];//list of point better
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
    if (foundGoal) {
      return this.locationsArray;
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
    if (foundGoal) {
      return this.locationsArray;
    } else {
      return null;
    }
  }
  /**
   * @param file to read the mazeArray
   */
  private void readFromFile(final File file) {
    try {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String str = br.readLine();
    int[] intArray = stringArrayToIntArray(str);
    this.n = intArray[0];
    this.m = intArray[1];
    constructVariables();
    for (int i = 0; i < this.n; i++) {
      str = br.readLine();
      this.mazeArray[i] = str;
      if (this.mazeArray[i].indexOf('S') >= 0) {
        this.k = i;
        this.l = this.mazeArray[i].indexOf('S');
        foundS = true;
      }
      if (this.mazeArray[i].indexOf('E') >= 0) {
        foundE = true;
      }
    }
    br.close();
    } catch (Exception e) {
    }
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
    for (int j = -1; j <= 1; j++) {
      for (int i = -1; i <= 1; i++) {
        if ((o + i) < n && (o + i) >= 0 && (p + j) < m && (p + j) >= 0 && i != j && (i + j) != 0
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
          this.locationsArray[this.s][1] = o + i;
          this.locationsArray[this.s][0] = p + j;
          this.s++;
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
    for (int j = -1; j <= 1; j++) {
      for (int i = -1; i <= 1; i++) {
        if ((o + i) < n && (o + i) >= 0 && (p + j) < m && (p + j) >= 0 && i != j && (i + j) != 0
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
          this.locationsArray[this.s][1] = o + i;
          this.locationsArray[this.s][0] = p + j;
          this.s++;
          break;
        }
      }
      if (this.foundGoal) {
        break;
      }
    }
    return;
  }

}
