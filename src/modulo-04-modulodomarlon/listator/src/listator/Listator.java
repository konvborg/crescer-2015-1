package listator;

import java.io.File;

public class Listator {
	public static void main(String[] args) {
			File dir = new File(args[0]);
			File[] filesList = dir.listFiles();
			for (File file : filesList) {
			    if (file.isFile()) {
			        System.out.println(file.getName());
			    }
			}
	}
}
		



