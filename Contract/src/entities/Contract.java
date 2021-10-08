package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private Integer number;
	private Date date;
	private Double totalValue;
	
	List<Installment> installments = new ArrayList<Installment>();
	
	public Contract(Integer number, Date date, Double totalValue, int n) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	public Contract() {
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}
	
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}
	
	@Override
	public String toString() {
		String toString = "Installments:\n";
		for(Installment i : installments) {
			toString += i.toString() + "\n";
		}
		return toString;
	}
}
