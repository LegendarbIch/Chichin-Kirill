package fourth;

import java.util.ArrayList;

public class TestPharmacy4 {
	// ����� ���������� �������� � ������
	public static void AddingToTheList() {
		ArrayList<Pharmacy> medecineList = new ArrayList<>(); 
		ListOfMedicines listofmedicines = new ListOfMedicines(medecineList);
		
		//���������� ������ ���������
		PharMedecineFund pharmedecinefund1 = new PharMedecineFund();
		pharmedecinefund1.setPhName("������� ������");
		pharmedecinefund1.setMedecineName("���������");
		pharmedecinefund1.setMedecineType("��� �");
		pharmedecinefund1.setMedecinePrice(499);
		pharmedecinefund1.setOriginCountry("��������");
		
		listofmedicines.addList(pharmedecinefund1);
		
		//���������� ������ ���������
		PharMedecineFund pharmedecinefund2 = new PharMedecineFund();
		pharmedecinefund2.setPhName("������");
		pharmedecinefund2.setMedecineName("�������");
		pharmedecinefund2.setMedecineType("��� �");
		pharmedecinefund2.setMedecinePrice(600);
		pharmedecinefund2.setOriginCountry("������");
		
		listofmedicines.addList(pharmedecinefund2);
		
		//���������� ������ ���������
		PharMedecineFund pharmedecinefund3 = new PharMedecineFund();
		pharmedecinefund3.setPhName("������ ����");
		pharmedecinefund3.setMedecineName("�����");
		pharmedecinefund3.setMedecineType("�� ���� � ������");
		pharmedecinefund3.setMedecinePrice(120);
		pharmedecinefund3.setOriginCountry("������");
		
		listofmedicines.addList(pharmedecinefund3);
		
		System.out.println(listofmedicines.getList());
	}
	public static void PharCustomers() {
		Phar�ustomers phcust = new Phar�ustomers("�����", "�������", "���������", 20);
		phcust.setPhName("������� ������");
		System.out.println(phcust.toString());
	}
	public static void main(String[] args) {
		
		AddingToTheList();
		PharCustomers();
	}
}
