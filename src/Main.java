import exceptions.*;

public class Main {
	public static void main(String[] args) {
		String login = "wewpmnOw2_33";
		String password = "hghghg888";
		String confirmPassword = "hghghg888";

		checkRegistrationData(login, password, confirmPassword);
	}


	public static void checkRegistrationData(String login, String password, String confirmPassword) {
		try {
			CheckRegistration.checkPassword(password, confirmPassword);
			CheckRegistration.checkLogin(login);
		} catch (WrongLoginException e) {
			System.out.println("Длина логина свыше 20 символов");
		} catch (WrongLoginSymbolException e) {
			System.out.println("Недопустимый символ в логине");
		} catch (WrongLongPasswordException e) {
			System.out.println("Длина пароля свыше 19 символов");
		} catch (WrongPasswordSymbolException e){
			System.out.println("Недопустимый символ в пароле");
		} catch (WrongPasswordException e) {
			System.out.println("Пароль и проверочный пароль не совпадают");
		}
	}
}