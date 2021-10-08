package services;

public class PaypalPaymentService implements PaymentService {

	public double installment(double amount, int month)
	{
		double total = amount + 0.01 * month * amount;
		total += total * 0.02;
		return total;
	}
}
