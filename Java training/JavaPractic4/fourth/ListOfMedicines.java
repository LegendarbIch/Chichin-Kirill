/* 
 * Вариант 21). Учет продажи лекарств в аптеке. Создать родительский класс 
 * "Аптека" (название аптеки, адрес, город, ФИО директора) и дочерние классы:
 *  -"клиенты аптеки" (название аптеки, фамилия, имя, отчество клиента, процент
 *  скидки);
 *  -"лекарственный фонд аптеки" (название аптеки, название лекарства, тип лекарства
 *  ,цена лекарства, страна-производитель);
 *  -"продажи" (название аптеки, название лекарства, ФИО клиента, количество, сумма к оплате).
 *  Реализовать класс для хранения списка лекарств с методом добавления нового лекарства и
 *  методом печати списка лекарств.
 */
package fourth;

import java.util.ArrayList;

public class ListOfMedicines {
	private ArrayList<Pharmacy> list = new ArrayList<>();
	
	public ListOfMedicines(ArrayList<Pharmacy> list) {
		this.list = list;
	}

	public ArrayList<Pharmacy> getList() {
		return list;
	}
 
	public void addList(Pharmacy medecine) {
		list.add(medecine);
	}
	
}
