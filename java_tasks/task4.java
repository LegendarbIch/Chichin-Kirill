public class HelloWorld4 {
	public static void main(String[] args){
		String name = "Kirill"; 
		String password = "qwert";
		if ((name.equals(args[0]) && password.equals(args[1])) || (name.equals(args[1]) && password.equals(args[0]))) {
			System.out.println("Вас узнали. Добро пожаловать");
		} else {
			System.out.println("Логин и пароль не распознаны. Доступ запрещён");
		}
		
	}
}
