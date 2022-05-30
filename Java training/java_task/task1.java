/*
Найти максимальный по модулю элемент в одномерном массиве x. Затем к каждому элементу массива прибавить этот максимальный элемент.
*/
public class Mas {
	public static void main(String args[]) {
		int max = 0;
		int[] myArray = new int[10];
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = -100 + (int) (Math.random()*200);
			System.out.print("\t" + myArray[i]);
			if (Math.abs(myArray[i]) >= max)
				max = myArray[i];
		}
		System.out.print("\n" + "\n");
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] += max;
			System.out.print("\t" + myArray[i]);
		}
	}
}
