package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private PaymentService paymentService;
	
	public ContractService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public void processInstallments(Contract contract, int months) {
		Date date = contract.getDate();
		for(int i=0; i<months; i++)
		{
			double amount = contract.getTotalValue() / months;
			double installment = paymentService.installment(amount, i + 1);
			Date installmentDate = addMonths(date, i + 1);
			contract.getInstallments().add(new Installment(installmentDate, installment));
		}
	}
	
	public Date addMonths(Date date, int n)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);	
		return calendar.getTime();
	}
}
