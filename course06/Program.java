package course06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import servicies.ContractService;
import servicies.PayPalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		
		System.out.print("Entre com o valor das parcelas: ");
		int n = sc.nextInt();
		
		ContractService contractService = new ContractService(new PayPalService());
		
		contractService.processContract(obj, n);
		
		System.out.println("Parcelas: ");
		
		for (Installment installment : obj.getInstallments()) {
			System.out.println(installment);
		}
		
		
		
		
		sc.close();
	}

}
