package fourth;

import java.util.ArrayList;

public class ListOfMedicines {
	private ArrayList<Pharmacy> list = new ArrayList<>();
	
	public ListOfMedicines(ArrayList<Pharmacy> list) {
		this.list = list;
	}

	public ArrayList<Pharmacy> getList() {
		return list;
	}
 
	public void addList(Pharmacy medecine) {
		list.add(medecine);
	}
	
}
