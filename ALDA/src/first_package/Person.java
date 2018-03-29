package first_package;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Person {

	private String name;
	private String telNmb;
	private Date dob;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Person(){
		dob = new Date();
		this.read();
	}
	
	//Getter & Setter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelNmb() {
		return telNmb;
	}
	public void setTelNmb(String telNmb) {
		this.telNmb = telNmb;
	}
	public String getDob() {
		return sdf.format(dob).toString();
	}
	public void setDob(String dob) {
		try {
			this.dob = sdf.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	//Methods
	
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
			
			System.out.println("Bitte geben Sie das Geburtsdatum ein: (TT/MM/JJJJ)");
			dobCheck = s.nextLine();
			
			//Check if Format is valid
			dobValid = dataTest(dobCheck);
			
			//If valid change DOB
			if (dobValid) {
				setDob(dobCheck);
				System.out.println("Geburtsdatum: " + this.getDob().toString());
			}
		}
	}
	
	public boolean dataTest(String dob) {
		
		Date date = null;
		try {
		    date = sdf.parse(dob);
		    if (!dob.equals(sdf.format(date))) {
		        date = null;
		    }
		} catch (ParseException ex) {
		    ex.printStackTrace();
		}
		if (date == null) {
		    System.out.println("Eingabe nicht in korrektem Format: TT/MM/JJJJ");
		    return false;
		} else {
		    return true;
		}
		
	}
	
	public String toString() {
		
		String descr = "Name: " + this.getName() + " | Telefonnummer: " + this.getTelNmb() + " | Gebrutsdatum: " + this.getDob();
		System.out.println(descr);
		return descr;
		
	}
	
	
}
