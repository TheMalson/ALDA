package first_package;

import java.util.Scanner;

public class Student extends Person {

	int matrikelNmb;
	
	public Student() {
		super();
	}
	
	//Getter and Setter
	
	public int getMatNmb () {
		return matrikelNmb;
	}
	
	public void setMatNmb (int matNmb) {
		this.matrikelNmb = matNmb;
	}
	
	//Methods
	
	@Override
	public void read() {
		String dobCheck;
		boolean dobValid = false;
		
		Scanner s = new Scanner(System.in);
		//Get Person information
		
		System.out.println("Bitte geben Sie den Namen ein:");
		setName(s.nextLine());
		System.out.println("Name: " + this.getName());
		
		System.out.println("Bitte geben Sie die Telefonnummer ein:");
		setTelNmb(s.nextLine());
		System.out.println("Telefonnummer: " + this.getTelNmb());
		
		while(dobValid == false) {
			
			System.out.println("Bitte geben Sie das Geburtsdatum ein:");
			dobCheck = s.nextLine();
			
			//Check if Format is valid
			dobValid = dataTest(dobCheck);
			
			//If valid change DOB
			if (dobValid) {
				setDob(dobCheck);
				System.out.println("Geburtsdatum: " + this.getDob().toString());
			}
		}
		
		System.out.println("Bitte geben Sie die Matrikelnummer ein:");
		setMatNmb(s.nextInt());
		System.out.println("Matrikelnummer: " + this.getTelNmb());
	}
	
	@Override
	public String toString() {
		
		String descr = "Name: " + this.getName() + " | Telefonnummer: " + this.getTelNmb() + " | Gebrutsdatum: " + this.getDob() + " | Matrikelnummer: " + matrikelNmb;
		System.out.println(descr);
		return descr;
		
	}
	
	
	
	
}
