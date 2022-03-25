/*
 * Дан одномерный массив a. Записать в массив z все порядковые номера 
 * отрицательных элементов массива a. Затем упорядочить по убыванию элементы массива a,
 * расположенные между первыми двумя отрицательными элементами.
 */
public class Mas2 {
	public static void main(String args[])
	{
		int b = 0;
		int[] A = {-4, 3, 2, 5, 12, 9, -20, 11, 92, -10};
		for (int i = 0; i < A.length; i++) 
		{
			if (A[i] < 0) {
				b++;
			}
		}
		int[] Z = new int [b];
		int n = 0;
		for (int j = 0; j < A.length; j++)
		{
			if (A[j] < 0) {
				Z[n] = j;
				n++;
			}
		}
		for (int c = 0; c < Z.length; c++){
			System.out.print( Z[c]  + "\t");
		}
		System.out.print("\n" + "Массив а \t  ");
		for (int c = 0; c < A.length; c++){
			System.out.print( A[c]  + "\t");
		}
		System.out.print("\n" + "Отсорт. массив а  ");
		
		for (int i = Z[0]+1; i < Z[1]; i++) {
			for (int j = Z[0]+1; j < Z[1]; j++) {
				if (A[j] < A[j+1]) {
					int gg = A[j];
					A[j] = A[j+1];
					A[j+1] = gg; 
				}
			}
				
		}
		for (int c = 0; c < A.length; c++){
			System.out.print( A[c]  + "\t");
		}
	}
}
