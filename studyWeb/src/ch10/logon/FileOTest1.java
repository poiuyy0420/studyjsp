package ch10.logon;

import java.io.*;

public class FileOTest1 {
	public static void main(String args[]) throws Exception {
		String source = "Have a nice day.";
		char intxt[] = new char[source.length()];
		source.getChars(0, source.length(), intxt, 0);

		FileWriter fw = new FileWriter("temp.txt");
		fw.write(intxt);
		
		fw.close();
	}

}
