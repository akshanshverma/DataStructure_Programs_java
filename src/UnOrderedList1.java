import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import helper.*;

public class UnOrderedList1 {
	public String[] readFile() throws Exception {
		File f = new File("/home/pc/Akshansh/akku.txt");
		BufferedReader bf = new BufferedReader(new FileReader(f));
		String st, s = null;
		while ((st = bf.readLine()) != null) {
			s = st;
		}
		String[] sArr = s.split(" ");
		bf.close();
		return sArr;
	}


	public static void main(String[] args) throws Exception {
		UnOrderedList1 ul = new UnOrderedList1();
		UnOrderedList<String> u = new UnOrderedList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter word");
		String s = sc.next();
		String[] sAr = null;
		try {
			sAr = ul.readFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (String string : sAr) {
			u.add(string);
		}
		u.list();

		if (u.search(s)) {
			u.remove(s);
			System.out.println("yes");
		} else {
			u.add(s);
			System.out.println("word is added to file");
			
		}
		System.out.println();
		
		u.list();
		Files.write(Paths.get("/home/pc/Akshansh/akku.txt"),u.getData().getBytes());
	}
}
