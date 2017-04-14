/**
*/
package eg.edu.alexu.csd.datastructure.iceHockey;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.cs29.IceHockey;
/**
 */
public class IceHockeytest {
	/**
	 */
	private IceHockey test = new IceHockey();
	/**
	 */
	@Test
	public void test1() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {"44444H44S4",
				          "K444K4L444",
			              "4LJ44T44XH",
				          "444O4VIF44",
				          "44C4D4U444",
				          "4V4Y4KB4M4",
				          "G4W4HP4O4W",
				          "4444ZDQ4S4",
				          "4BR4Y4A444",
				          "4G4V4T4444"};
		int team = 4, threshold = 16;
	Point[] locations = {new Point(3, 8), new Point(4, 16), new Point(5, 4),
			new Point(16, 3), new Point(16, 17), new Point(17, 9)};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test2() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {"33JUBU33",
				          "3U3O4433",
				          "O33P44NB",
				          "PO3NSDP3",
				          "VNDSD333",
				          "OINFD33X"};
		int team = 3, threshold = 16;
Point[] locations = {new Point(4, 5), new Point(13, 9), new Point(14, 2)};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test3() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {"8D88888J8L8E888",
						  "88NKMG8N8E8JI88",
						  "888NS8EU88HN8EO",
						  "LUQ888A8TH8OIH8",
						  "888QJ88R8SG88TY",
						  "88ZQV88B88OUZ8O",
						  "FQ88WF8Q8GG88B8",
						  "8S888HGSB8FT8S8",
						  "8MX88D88888T8K8",
						  "8S8A88MGVDG8XK8",
						  "M88S8B8I8M88J8N",
						  "8W88X88ZT8KA8I8",
						  "88SQGB8I8J88W88",
						  "U88H8NI8CZB88B8",
						  "8PK8H8T8888TQR8"};
		int team = 8, threshold = 9;
		Point[] locations = {new Point(1, 17), new Point(3, 3),
			new Point(3, 10), new Point(3, 25), new Point(5, 21),
			new Point(8, 17), new Point(9, 2), new Point(10, 9),
			new Point(12, 23), new Point(17, 16), new Point(18, 3),
			new Point(18, 11), new Point(18, 28), new Point(22, 20),
			new Point(23, 26), new Point(24, 15), new Point(27, 2),
			new Point(28, 26), new Point(29, 16)};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test4() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {"11111",
					      "1AAA1",
				          "1A1A1",
				          "1AAA1",
				          "11111"};
		int team = 1, threshold = 3;
		Point[] locations = {new Point(5, 5), new Point(5, 5)};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test5() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {"2BKLP",
						  "22KAL",
						  "VA2AF",
						  "UHYAN",
						  "O2BLP"};
		int team = 2, threshold = 9;
		Point[] locations = {new Point(2, 2)};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test6() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {"1A1A1",
						  "A1A1A",
						  "1A1A1",
						  "A1A1A",
						  "1A1A1"};
		int team = 1, threshold = 7;
		Point[] locations = {};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test7() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {};
		int team = 1, threshold = 3;
assertNull("No photo is found", icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test8() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = null;
		int team = 1, threshold = 3;
assertNull("No photo is found", icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test9() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {"4444444444",
						  "4444444444",
						  "4444444444",
						  "4444444444",
						  "4444444444",
						  "4444444444",
						  "4444444444",
						  "4444444444",
						  "4444444444",
						  "4444444444",
						  };
		int team = 4, threshold = 9;
		Point[] locations = {new Point(10, 10)};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test10() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {"LGH6jK6DC66MKH6BCK6",
						  "KD6D6w66C66AD6HMJKI",
						  "MG666K6XC66NCHCBL6P",
						  "KB6D6vJ6C66A6H66JK6",
						  };
		int team = 6, threshold = 16;
Point[] locations = {new Point(7, 5), new Point(14, 3), new Point(20, 4)};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test11() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {""};
		int team = 1, threshold = 3;
		Point[] locations = {};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test12() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {"2BK",
						  "22K",
						  };
		int team = 3, threshold = 9;
		Point[] locations = {};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
}
