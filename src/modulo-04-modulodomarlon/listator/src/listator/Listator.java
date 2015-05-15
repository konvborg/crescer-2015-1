package listator;

import java.io.File;

import javax.security.auth.x500.X500Principal;

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
		



