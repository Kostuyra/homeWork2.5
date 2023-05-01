import exceptions.*;

public class CheckRegistration {

	static void checkLogin(String login) {
		if (login.length() > 20) {
			throw new WrongLoginException();
		}
		if (checkWord(login) == false) {
			throw new WrongLoginSymbolException();
		}
	}

	static void checkPassword(String password, String confirmPassword) {
		if (password.length() >= 20) {
			throw new WrongLongPasswordException();
		}
		if (checkWord(password) == false) {
			throw new WrongPasswordSymbolException();
		}
		checkConfirmPassword(password, confirmPassword);
	}

	private static void checkConfirmPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword) == false) {
			throw new WrongPasswordException();
		}
	}

	private static boolean checkWord(String word) {
		char ch = '\u0000';
		boolean bool = false;
		for (int i = 0; i < word.length(); i++) {
			ch = word.charAt(i);
			if (checkWordForDigit(ch) || checkWordForLatin(ch) || checkWordForSign(ch)) {
				bool = true;
			} else {
				return false;
			}
		}
		return bool;
	}

	private static boolean checkWordForSign(Character ch) {
		return ch.equals("_");
	}

	private static boolean checkWordForLatin(Character ch) {
		return Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.BASIC_LATIN);
	}

	private static boolean checkWordForDigit(Character ch) {
		return Character.isDigit(ch);
	}

}
