package ch10.logon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileOTest6 {

	public static void main(String args[]) throws Exception {

		int[] num = { 1, 2, 3, 4, 5 };

		String[] st = { "Kim", "Park", "Jung", "Lee" };

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tmp.txt"));
		oos.writeObject(num);
		oos.writeObject(st);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tmp.txt"));
		int[] num2 = (int[]) ois.readObject();
		

	}
}
