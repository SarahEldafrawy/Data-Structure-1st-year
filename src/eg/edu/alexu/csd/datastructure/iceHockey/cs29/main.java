package eg.edu.alexu.csd.datastructure.iceHockey.cs29;

import java.awt.Point;

class main {
public static void main(final String[] args) {

	iceHockey icehockey = new iceHockey();
	Point[] Coordinates = new Point[100];

	String[] Photo = new String[] {"44444H44S4",
							      "K444K4L444",
								  "4LJ44T44XH",
								  "444O4VIF44",
								  "44C4D4U444",
								  "4V4Y4KB4M4",
								  "G4W4HP4O4W",
								  "4444ZDQ4S4",
								  "4BR4Y4A444",
								  "4G4V4T4444"
								  };
	Coordinates = icehockey.findPlayers(Photo, 4, 16);
	for (int i = 0; i < Coordinates.length; i++) {
		System.out.print(Coordinates[i].x +"  "+Coordinates[i].y+"\n");
	}
 }
}