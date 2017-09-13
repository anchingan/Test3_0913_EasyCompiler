import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestT {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		TLanguage doT = new TLanguage();
		System.out.println("Command:");
		String str;
		while ((str = scanner.nextLine()) == null);
		if (doT.readCommand(str)) {
			doT.exactTFile();
			System.out.println("Done");
		}
		else
			System.out.println("Program terminate.");
		scanner.close();
	}

}
