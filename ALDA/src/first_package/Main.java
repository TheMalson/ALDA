package first_package;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int sMatNmb;
		
		//Create Students
		
		Student[] stArray = new Student[4];
		
		stArray[0] = new Student();
		stArray[1] = new Student();
		stArray[2] = new Student();
		stArray[3] = new Student();
		
		//Get MatNmb
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("-------------------------------------------------");
		System.out.println("Bitte geben Sie die gesuchte Matrikelnummer ein");
		sMatNmb = s.nextInt();
		
		System.out.println("Eingegebene Matrikelnummer: " + sMatNmb);
		System.out.println("-----------------------------------------");
		
		//Search Loop
		boolean match = false;
		
		for(int i = 0; i<stArray.length; i++) {
			if(sMatNmb == stArray[i].getMatNmb()) {
				stArray[i].toString();
				match = true;
			}
		}
		
		if (match == false) {
			System.out.println("Es konnte keine Übereinstimmung gefunden werden");
		}
		
	}

}
