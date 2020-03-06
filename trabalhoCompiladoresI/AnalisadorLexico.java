import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import separador.EnumClassToken;
import separador.Token;

public class AnalisadorLexico {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Token> tk = new ArrayList<Token>();
		String bruteText = keyboard.nextLine();

		for (int i = 0; i < bruteText.length(); i++) {
			try {
				if (bruteText.charAt(i) == '(' || bruteText.charAt(i) == ')') {
					tk.add(new Token(Character.toString(bruteText.charAt(i)), EnumClassToken.SIMBOLO));
				} else if (verifica(bruteText.charAt(i), "[+*/-]")) {
					tk.add(new Token(Character.toString(bruteText.charAt(i)), EnumClassToken.OPERADOR));
				} else if (verifica(bruteText.charAt(i), "[0-9]")) {
					i = pegaCadeia(tk, bruteText, i, EnumClassToken.NUMERO, "[0-9]");
				} else if (verifica(bruteText.charAt(i), "[a-zA-Z]")) {
					i = pegaCadeia(tk, bruteText, i, EnumClassToken.IDENTIFICADOR, "[a-zA-Z0-9]");
				}else {
					i = pegaCadeia(tk, bruteText, i, EnumClassToken.OUT, "[^a-zA-Z0-9\\(\\)+*/-]");
				}

			} catch (StringIndexOutOfBoundsException e) {
				System.out.println(bruteText.charAt(i));
			}
		}
		for (Token token2 : tk) {
			System.out.println(token2.toString());
		}
		keyboard.close();
	}

	private static int pegaCadeia(ArrayList<Token> tk, String bruteText, int i, EnumClassToken e, String regex) {
		int j = i;
		for (; j < bruteText.length() && verifica(bruteText.charAt(j), regex); j++) {
		}
		String temp = bruteText.substring(i, j);
		tk.add(new Token(temp, e));
		return j - 1;
	}

	public static boolean verifica(char text, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text + "");
		return m.matches();
	}
}
//(1+2)*(A3-4)
//     ######$$567&&**90 666aB
// ))((..... 123a345 % .
