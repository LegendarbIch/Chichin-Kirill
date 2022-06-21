/*������� ��������� �� ����� Java ��� ����������� ������ � ��������� ���������� �������.
������� ��������, �����������, ������ �������/�������, ��������� ����� toString() ��� ������ ������ ����������
�� ������� � ����������������� ����. 
������� 21). ������.
*/
package com.makotogroup.intro;
public class Pharmacy {
	private String PhName;
	private String PatientLPF;
	private String MedecineName;
	private String MedecineType;
	private int MedecinePrice;
	private String OriginCountry;
	private String SaleDate;

	public Pharmacy(String PhName, String PatientLPF, String MedecineName, 
		String MedecineType, int MedecinePrice) {
		this.PhName = PhName;
		this.PatientLPF = PatientLPF;
		this.MedecineName = MedecineName;
		this.MedecineType = MedecineType;
		this.MedecinePrice = MedecinePrice;
	}
	public String getPhName() {
		return PhName;
	}
	public void setPhName(String PhName) {
		this.PhName = PhName;
	}
	public String getPatientLPF() {
		return PatientLPF;
	}
	public void setPatientLPF(String PatientLPF) {
		this.PatientLPF = PatientLPF;
	}
	public String getMedecineName() {
		return MedecineName;
	}
	public void setMedecineName(String MedecineName) {
		this.MedecineName = MedecineName;
	}
	public String getMedecineType() {
		return MedecineType;
	}
	public void setMedecineType(String MedecineType) {
		this.MedecineType = MedecineType;
	}
	public int getMedecinePrice() {
		return MedecinePrice;
	}
	public void setMedecinePrice(int MedecinePrice) {
		this.MedecinePrice = MedecinePrice;
	}
	public String getOriginCountry() {
		return OriginCountry;
	}
	public void setOriginCountry(String OriginCountry) {
		this.OriginCountry = OriginCountry;
	}
	public String getSaleDate() {
		return SaleDate;
	}
	public void setSaleDate(String SaleDate) {
		this.SaleDate = SaleDate;
	}
	public String toString() {
		return "�������� ������: " + PhName + "\n" + "��� ����������: " + PatientLPF + "\n" + "�������� ���������: " + MedecineName + "\n" + 
				"��� ���������: " + MedecineType + "\n" + "���� ���������: " + MedecinePrice + "���" + "\n";
	}
}

