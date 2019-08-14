package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums2.ExWorkerLevel;

public class ExWorker {

	private String name;
	private ExWorkerLevel level;
	private Double baseSalary;

	private ExDepartament departament;
	private List<ExHourContract> contracts = new ArrayList<>();

	public ExWorker() {

	}
	public ExWorker(String name, ExWorkerLevel level, Double baseSalary, ExDepartament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ExWorkerLevel getLevel() {
		return level;
	}
	public void setLevel(ExWorkerLevel level) {
		this.level = level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public ExDepartament getDepartament() {
		return departament;
	}
	public void setDepartament(ExDepartament departament) {
		this.departament = departament;
	}
	public List<ExHourContract> getContracts() {
		return contracts;
	}
	//aqui começa
	public void addContract(ExHourContract contract) {
		contracts.add(contract);
	}
	public void removeContract(ExHourContract contract) {
		contracts.remove(contract);
	}
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (ExHourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}