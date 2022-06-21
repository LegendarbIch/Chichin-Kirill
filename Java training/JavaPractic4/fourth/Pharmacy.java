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

public class Pharmacy {
	private String PhName;
	private String DirectorLPF;
	private String Address;
	private String City;
	
	public Pharmacy() {};
	
	public Pharmacy(String PhName, String DirectorLPF, String Address, String City) {
		this.PhName = PhName;
		this.DirectorLPF = DirectorLPF;
		this.Address = Address;
		this.City = City;
	}
	public String getPhName() {
		return PhName;
	}
	public void setPhName(String PhName) {
		this.PhName = PhName;
	}
	public String getDirectorLPF() {
		return DirectorLPF;
	}
	public void setDirectorLPF(String DirectorLPF) {
		this.DirectorLPF = DirectorLPF;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String City) {
		this.City = City;
	}
	
	public String toString() {
		return "\n Название аптеки: " + getPhName()
		+ "\n Адресс: " + getAddress() + "\n Город: " + getCity() 
		+ "\n ФИО директора: " + getDirectorLPF();
	}
}
