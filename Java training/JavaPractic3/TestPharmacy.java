package three;

public class TestPharmacy {
	public static void main(String[] args) {
		Pharmacy pharmacy = new Pharmacy("Зеленая аптека", "Иван Иванов Иваныч", "Ношпа", "Лекарство категории А", 159);
		System.out.println(pharmacy.toString());
		pharmacy.setOriginCountry("Россия");
		pharmacy.setSaleDate("02.03.2022");
		System.out.println("Страна производитель: " + pharmacy.getOriginCountry() );
		System.out.println("Цена товара: " + pharmacy.getSaleDate());
	}
}