/**
*/
package eg.edu.alexu.csd.datastructure.iceHockey;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
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
	private final int q3 = 3, q4 = 4, q5 = 5, q6 = 6, q7 = 7, q8 = 8,
		q9 = 9, q10 = 10, q11 = 11, q12 = 12, q13 = 13, q14 = 14,
		q15 = 15, q16 = 16, q17 = 17, q18 = 18, q20 = 20, q21 = 21,
		q22 = 22, q23 = 23, q24 = 24, q25 = 25, q26 = 26, q27 = 27,
		q28 = 28, q29 = 29;
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
		int team = q4, threshold = q16;
Point[] locations = {new Point(q3, q8), new Point(q4, q16), new Point(q5, q4),
		new Point(q16, q3), new Point(q16, q17), new Point(q17, q9)};
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
		int team = q3, threshold = q16;
Point[] locations = {new Point(q4, q5), new Point(q13, q9), new Point(q14, 2)};
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
		int team = q8, threshold = q9;
		Point[] locations = {new Point(1, q17), new Point(q3, q3),
		new Point(q3, q10), new Point(q3, q25), new Point(q5, q21),
		new Point(q8, q17), new Point(q9, 2), new Point(q10, q9),
		new Point(q12, q23), new Point(q17, q16), new Point(q18, q3),
		new Point(q18, q11), new Point(q18, q28), new Point(q22, q20),
		new Point(q23, q26), new Point(q24, q15), new Point(q27, 2),
		new Point(q28, q26), new Point(q29, q16)};
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
		int team = 1, threshold = q3;
		Point[] locations = {new Point(q5, q5), new Point(q5, q5)};
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
		int team = 2, threshold = q9;
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
		int team = 1, threshold = q7;
		Point[] locations = {};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test7() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {};
		int team = 1, threshold = q3;
assertNull("No photo is found", icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test8() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = null;
		int team = 1, threshold = q3;
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
		int team = q4, threshold = q9;
		Point[] locations = {new Point(q10, q10)};
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
		int team = q6, threshold = q16;
Point[] locations = {new Point(q7, q5), new Point(q14, q3), new Point(q20, q4)};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
	/**
	 */
	@Test
	public void test11() {
		IPlayersFinder icehockey = (IPlayersFinder) test;
		String[] photo = {""};
		int team = 1, threshold = q3;
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
		int team = q3, threshold = q9;
		Point[] locations = {};
assertArrayEquals(locations, icehockey.findPlayers(photo, team, threshold));
	}
}
