public class HelloWorld2 {
	public static void main(String[] arguments) {
		if (arguments.length == 0 ) {
			System.out.println("Вы не передавали параметров");
		} else {
			System.out.println("Вы ввели " + arguments.length + " параметров");
		}
	}
} 
