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

public class PharCustomers extends Pharmacy {
	
	private String ClientFamily;
	private String ClientName; 
	private String ClientMiddleName;
	private int Discount;
	
	public PharCustomers() {};
	
	public PharCustomers(String ClientFamily, String ClientName, String ClientMiddleName, int Discount) {
		this.ClientFamily = ClientFamily;
		this.ClientName = ClientName;
		this.ClientMiddleName = ClientMiddleName;
		this.Discount = Discount;
	}

	public String getClientFamily() {
		return ClientFamily;
	}

	public void setClientFamily(String clientFamily) {
		ClientFamily = clientFamily;
	}

	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}

	public String getClientMiddleName() {
		return ClientMiddleName;
	}

	public void setClientMiddleName(String clientMiddleName) {
		ClientMiddleName = clientMiddleName;
	}

	public int getDiscount() {
		return Discount;
	}

	public void setDiscount(int discount) {
		Discount = discount;
	}
	public String toString() {
		return "Название аптеки: "+ super.getPhName() + "\n Имя клиента: " + getClientName()
		+ "\n Фамилия клиента: " + getClientFamily() + "\n Отчество клиента: " + getClientMiddleName()
		+ "\n Скидка у клиента: " + getDiscount() + "%";
	}
}
