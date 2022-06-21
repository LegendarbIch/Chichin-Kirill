package fourth;

public class PharMedecineFund extends Pharmacy{

	private String MedecineName;
	private String MedecineType;
	private int MedecinePrice;
	private String OriginCountry;
	
	public PharMedecineFund() {};
	
	public PharMedecineFund(String MedecineName, String MedecineType, int MedecinePrice, String OriginCountry) {
		this.MedecineName = MedecineName;
		this.MedecineType = MedecineType;
		this.MedecinePrice = MedecinePrice;
		this.OriginCountry = OriginCountry;
	}

	public String getMedecineName() {
		return MedecineName;
	}
	public void setMedecineName(String medecineName) {
		MedecineName = medecineName;
	}
	public String getMedecineType() {
		return MedecineType;
	}
	public void setMedecineType(String medecineType) {
		MedecineType = medecineType;
	}
	public int getMedecinePrice() {
		return MedecinePrice;
	}
	public void setMedecinePrice(int medecinePrice) {
		MedecinePrice = medecinePrice;
	}
	public void setOriginCountry(String OriginCountry) {
		this.OriginCountry = OriginCountry;
	}
	public String getOriginCountry() {
		return OriginCountry;
	}
	public String toString() {
		return "Название аптеки: " + super.getPhName() + "\n Название лекарства: " + getMedecineName() + 
		"\n Тип лекарства: " + getMedecineType() + "\n Цена лекарства: " + getMedecinePrice() + " руб" +
		"\n Страна производитель: " + getOriginCountry() + "\n \n"; 
	}
}
