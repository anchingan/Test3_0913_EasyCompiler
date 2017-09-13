import java.io.*;
import java.lang.*;
import java.util.Arrays;

public class TLanguage {
	private TCommand c;
	private int num, count;
	private String outputName, inputName;
	private int[] print;

	public TLanguage() {
		c = new TCommand();
		num = 0;
		count = 0;
		print = new int [10];
	}
	
	//Decide if String s is a legal command.
	public boolean readCommand(String s) {
		String[] sArray = s.split("\\s");
		if (sArray[0].equalsIgnoreCase("T")) {
			if (sArray.length == 3) {
				if (sArray[1].endsWith(".t")) {
					if (sArray[2].endsWith(".out")) {
						inputName = sArray[1] + ".txt";
						outputName = sArray[2] + ".txt";
						return true;
					}
				}
			}
		}
		System.out.println("Command error!");
		return false;
	}
	
	//Exact commands in Tfile.
	public void exactTFile() throws IOException, FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(inputName));
		String str;
		while ((str = br.readLine()) != null)
			exactCommand(str);
		br.close();
		output();
	}
	
	//Exact T language command.
	public void exactCommand(String s) {
		if (c.isTLang(s) == 0)
			System.out.println(s + " Syntax error!");
		else {
			int[] number = new int[1];
			int t = c.parser(s, number);
			if (t == 0) 
				num = number[0];
			else if (t == 1)
				num += number[0];
			else if (t == 2)
				print();
		}
	}
	
	//Record num into print array.
	public void print() {
		if (count >= print.length)
			print = Arrays.copyOf(print, print.length * 2);
		print[count++] = num;
	}
	
	//Write and output file.
	public void output() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputName));
		if (count != 0) {
			for (int i = 0; i < count; i++) {
				bw.write(Integer.toString(print[i]));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}

}
