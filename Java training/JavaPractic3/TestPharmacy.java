package three;

public class TestPharmacy {
	public static void main(String[] args) {
		Pharmacy pharmacy = new Pharmacy("������� ������", "���� ������ ������", "�����", "��������� ��������� �", 159);
		System.out.println(pharmacy.toString());
		pharmacy.setOriginCountry("������");
		pharmacy.setSaleDate("02.03.2022");
		System.out.println("������ �������������: " + pharmacy.getOriginCountry() );
		System.out.println("���� ������: " + pharmacy.getSaleDate());
	}
}