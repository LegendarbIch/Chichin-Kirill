package fourth;

import java.util.ArrayList;

public class TestPharmacy4 {
	// Ìåòîä äîáàâëåíèÿ ëåêàðñòâ â ñïèñîê
	public static void AddingToTheList() {
		ArrayList<Pharmacy> medecineList = new ArrayList<>(); 
		ListOfMedicines listofmedicines = new ListOfMedicines(medecineList);
		
		//Äîáàâëåíèå íîâîãî ëåêàðñòâà
		PharMedecineFund pharmedecinefund1 = new PharMedecineFund();
		pharmedecinefund1.setPhName("Çåëåíàÿ àïòåêà");
		pharmedecinefund1.setMedecineName("Ãàëüöèâèí");
		pharmedecinefund1.setMedecineType("Òèï Á");
		pharmedecinefund1.setMedecinePrice(499);
		pharmedecinefund1.setOriginCountry("Ãåðìàíèÿ");
		
		listofmedicines.addList(pharmedecinefund1);
		
		//Äîáàâëåíèå íîâîãî ëåêàðñòâà
		PharMedecineFund pharmedecinefund2 = new PharMedecineFund();
		pharmedecinefund2.setPhName("Àïòåêà");
		pharmedecinefund2.setMedecineName("Êîãàöåë");
		pharmedecinefund2.setMedecineType("Òèï À");
		pharmedecinefund2.setMedecinePrice(600);
		pharmedecinefund2.setOriginCountry("Øâåöèÿ");
		
		listofmedicines.addList(pharmedecinefund2);
		
		//Äîáàâëåíèå íîâîãî ëåêàðñòâà
		
		PharMedecineFund pharmedecinefund3 = new PharMedecineFund();
		pharmedecinefund3.setPhName("Àïòåêà Âèòà");
		pharmedecinefund3.setMedecineName("Íîøïà");
		pharmedecinefund3.setMedecineType("Îò áîëè â ãîëîâå");
		pharmedecinefund3.setMedecinePrice(120);
		pharmedecinefund3.setOriginCountry("Ðîññèÿ");
		
		listofmedicines.addList(pharmedecinefund3);
		
		System.out.println(listofmedicines.getList());
	}
	public static void PharCustomers() {
		PharÑustomers phcust = new PharÑustomers("Äàíèë", "Äàíèëîâ", "Äàíèëîâè÷", 20);
		phcust.setPhName("Çåëåíàÿ àïòåêà");
		System.out.println(phcust.toString());
	}
	public static void main(String[] args) {
		
		AddingToTheList();
		PharCustomers();
	}
}
