/**
 * @author welcome
 *
 */
package eg.edu.alexu.csd.datastructure.maze.cs29;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs29.QueueList;
import eg.edu.alexu.csd.datastructure.stack.cs29.Stack;
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
  /** parents array is where the maze cells'parents are stored.*/
  private Point[][] parents;
  /** foundGoal flag to stop the recursion when Exit is found.*/
  private boolean foundGoal;
  /** foundS flag to check if the maze has no start.*/
  private boolean foundS;
  /** foundE flag to check if the maze has no Exit.*/
  private boolean foundE;
  /** used in the BFS.*/
  private QueueList queue;
  /** used in the DFS.*/
  private Stack stack;

  /**constructor to set variables.*/
  private void constructVariables() {
    this.locationsArray = new ArrayList<int[][]>();
    this.visitedArray = new boolean[this.n][this.m];
    this.parents = new Point[n][m];
    this.mazeArray = new String[this.n];
    this.parents = new Point[n][m];
    this.stack = new Stack();
    this.queue = new QueueList();
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
    parents[k][l] = new Point(-1, -1);
    queue.enqueue(new Point(k, l));
    pathBFS(k, l);
    int[][]startCoor = new int[1][2];
    startCoor[0][0] = k;
    startCoor[0][1] = l;
    if (foundGoal) {
      locationsArray.add(startCoor);
    }
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
    parents[k][l] = new Point(-1, -1);
    stack.push(new Point(k, l));
    pathDFS(k, l);
    int[][]startCoor = new int[1][2];
    startCoor[0][0] = k;
    startCoor[0][1] = l;
    if (foundGoal) {
      locationsArray.add(startCoor);
    }
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
    try {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String str = br.readLine();
    int[] intArray = stringArrayToIntArray(str);
    this.n = intArray[0];
    this.m = intArray[1];
    constructVariables();
    for (int i = 0; i < this.n; i++) {
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
    br.close();
    } catch (Exception e) {
      throw null;
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
    for (int j = 1; j >= -1; j--) {
      for (int i = 1; i >= -1; i--) {
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

  /**BFS recursion iterated.
   * @param x &
   * @param y is the Coordinates of the start point  */
  private void pathBFS(final int x, final int y) {
    int o = x, p = y;
    this.visitedArray[o][p] = true;
    while (!queue.isEmpty() && !foundGoal) {
      Point newNode = (Point) queue.dequeue();
      o = newNode.x;
      p = newNode.y;
      for (int i = 1; i >= -1; i--) {
        for (int j = 1; j >= -1; j--) {
          if ((o + i) < n && (o + i) >= 0 && (p + j) < m
              && (p + j) >= 0 && i != j && (i + j) != 0
              && !this.visitedArray[o + i][p + j]
              && this.mazeArray[o + i].charAt(p + j) != '#') {
              this.parents[o + i][p + j] = new Point(o, p);
              this.visitedArray[o + i][p + j] = true;
              if (this.mazeArray[o + i].charAt(p + j) == '.') {
                queue.enqueue(new Point(o + i, p + j));
              }
              if (this.mazeArray[o + i].charAt(p + j) == 'E') {
                foundGoal = true;
                o += i;
                p += j;
                break;
              }
          }
        }
        if (foundGoal) {
          break;
        }
      }
    }
    findingPath(o, p);
  }
  /**DFS recursion iterated.
   * @param x &
   * @param y is the Coordinates of the start point  */
  private void pathDFS(final int x, final int y) {
    int o = x, p = y;
    this.visitedArray[o][p] = true;
    while (!stack.isEmpty() && !foundGoal) {
      for (int j = -1; j <= 1; j++) {
        for (int i = -1; i <= 1; i++) {
          if ((o + i) < n && (o + i) >= 0 && (p + j) < m
              && (p + j) >= 0 && i != j && (i + j) != 0
              && !this.visitedArray[o + i][p + j]
              && this.mazeArray[o + i].charAt(p + j) != '#') {
              this.parents[o + i][p + j] = new Point(o, p);
              this.visitedArray[o + i][p + j] = true;
              if (this.mazeArray[o].charAt(p) == 'E') {
                foundGoal = true;
                break;
              }
              if (this.mazeArray[o + i].charAt(p + j) == '.'
                  || this.mazeArray[o + i].charAt(p + j) == 'E') {
                stack.push(new Point(o + i, p + j));
              }
              if (this.mazeArray[o + i].charAt(p + j) == 'E') {
                this.visitedArray[o + i][p + j] = false;
                //foundGoal = true;
                //break;
              }
          }
        }
        if (foundGoal) {
          break;
        }
      }
      if (!foundGoal) {
        Point newNode = (Point) stack.pop();
        o = newNode.x;
        p = newNode.y;
      }
    }
    findingPath(o, p);
   }
  /** to trace the path.
   * by passing @param x &
   * @param y as the exit point*/
  public void findingPath(final int x, final int y) {
    int o = x, p = y;
    while (o != k || p != l) {
      int[][] arr = new int[1][2];
      arr[0][0] = o;
      arr[0][1] = p;
      this.locationsArray.add(arr);
      Point pt = this.parents[o][p];
      o = pt.x;
      p = pt.y;
    }
  }

}
