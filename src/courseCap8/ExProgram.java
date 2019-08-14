package courseCap8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ExDepartament;
import entities.ExHourContract;
import entities.ExWorker;
import entities.enums2.ExWorkerLevel;

public class ExProgram {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String departamentName = sc.nextLine();
		System.out.println("Enter Worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		ExWorker worker = new ExWorker(workerName, ExWorkerLevel.valueOf(workerLevel), baseSalary, new ExDepartament(departamentName));
				
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
		System.out.println("Enter many contract #" + i +" data:");	
		System.out.print("Date (DD/MM/YYYY): ");
		Date contractDate = sdf.parse(sc.next());
		System.out.print("Value per Hour: ");
		double valuePerHour = sc.nextDouble();
		System.out.print("Duration (hours): ");	
		int hours = sc.nextInt();
		ExHourContract contract = new ExHourContract(contractDate, valuePerHour, hours);
		worker.addContract(contract);
		
		}
		System.out.println("");	
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));		
		System.out.println("Name: "+ worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
