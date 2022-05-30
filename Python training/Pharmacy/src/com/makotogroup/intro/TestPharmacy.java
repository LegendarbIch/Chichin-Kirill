/*Создать программу на языке Java для определения класса в некоторой предметной области.
Описать свойства, конструктор, методы геттеры/сеттеры, перекрыть метод toString() для вывода полной информации
об обьекте в отформатированном виде. 
Вариант 21). Аптека.
*/
package com.makotogroup.intro;
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
