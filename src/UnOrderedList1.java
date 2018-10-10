import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class UnOrderedList1 {
	public static String[] readFile() throws Exception {
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
	public static void main(String[] args) {

	}
}
