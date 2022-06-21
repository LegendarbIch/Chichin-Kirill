package fourth;

public class Sales extends Pharmacy{
	
	PharMedecineFund sales = new PharMedecineFund();
	Phar�ustomers clients = new Phar�ustomers();
	
	private String PatientLPF;
	private int Count;
	private int AmountToBePaid;
	
	public Sales(String PatientLPF, int Count, int AmountToBePaid) {
		this.PatientLPF = PatientLPF;
		this.Count = Count;
		this.AmountToBePaid = AmountToBePaid;
	}
	
	public String getPatientLPF() {
		return PatientLPF;
	}
	public void setPatientLPF() {
		this.PatientLPF = clients.getClientName() + " " + clients.getClientFamily() + " " + clients.getClientMiddleName();
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int Count) {
		this.Count = Count;
	}
	public int getAmountToBePaid() {
		return AmountToBePaid;
	}
	public void setAmountToBePaid() {
		AmountToBePaid = sales.getMedecinePrice() * Count;
		AmountToBePaid -= AmountToBePaid * clients.getDiscount()/100;
	}
	
	public String toString() {
		return  "�������� ������: " + super.getPhName() + "\n �������� ���������: " + sales.getMedecineName() + 
				"\n ���� ���������: " + sales.getMedecinePrice() + " ���" + "\n ��� �������: " + getPatientLPF() +
				"\n ����������: " + getCount() + "\n ����� � ������: " + getAmountToBePaid(); 
	}
}
