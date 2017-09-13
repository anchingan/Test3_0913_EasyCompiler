import java.util.Arrays;

public class TCommand {
	
	
	public String standard(String input) { //(a)
		String result = input.trim();
		result = result.toUpperCase();
		return result;
	}
	
	public boolean isPInt(String input) { //(b)
		int t;
		try {
			t = Integer.parseInt(input);
		} catch(Exception e) {
			return false;
		}
		if (t > 0)
			return true;
		return false;
	}
	
	public int isTLang(String input) { //(c)
		if (input.endsWith(";")) {
			String str = standard(input);
			str = str.replace(";", "");
			String[] strArray = str.split("\\s+");
			if (parseCom(strArray[0]) >= 0 && parseCom(strArray[0]) < 3)
				return 1;
		}
		return 0;
	}
	
	private int parseCom(String input) {
		if (input.equals("ADD"))
			return 1;
		else if (input.equals("LOAD"))
			return 0;
		else if (input.equals("PRT")) 
			return 2;
		return -1;
	}
	
	public int computeToken(String s) { //(d)
		int tokens;
		String[] strArray = tSplit(s);
		tokens = strArray.length;
		return tokens;
	}
	
	private String[] tSplit(String s) {
		String str = s.replace(";", "");
		String[] strArray = str.split("\\s+");
		return strArray;
	}
	
	public int parser(String s, int[] params) { //(e)
		if (isTLang(s) == 0)
			return -1;
		s = standard(s);
		String[] strArray = tSplit(s);
		int t = parseCom(strArray[0]);
		if (t == -1)
			return -1;
		else if (t == 2)
			return t;
		else if (isPInt(strArray[1])) {
			params[params.length - 1] = Integer.parseInt(strArray[1]);
			return t;
		}
		
		return -1;
	}


}
