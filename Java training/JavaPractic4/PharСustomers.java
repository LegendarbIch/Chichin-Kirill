package fourth;

public class Phar�ustomers extends Pharmacy {
	
	private String ClientFamily;
	private String ClientName; 
	private String ClientMiddleName;
	private int Discount;
	
	public Phar�ustomers() {};
	
	public Phar�ustomers(String ClientFamily, String ClientName, String ClientMiddleName, int Discount) {
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
		return " �������� ������: "+ super.getPhName() + "\n ��� �������: " + getClientName()
		+ "\n ������� �������: " + getClientFamily() + "\n �������� �������: " + getClientMiddleName()
		+ "\n ������ � �������: " + getDiscount();
	}
}
