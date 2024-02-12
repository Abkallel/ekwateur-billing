package com.ekwateur.saas.billing;

import com.ekwateur.saas.billing.domain.BillingService;
import com.ekwateur.saas.billing.domain.model.ConsumptionQuantity;
import com.ekwateur.saas.billing.domain.model.EnergyType;
import com.ekwateur.saas.billing.infra.ClientInMemoryDB;

import java.util.List;
import java.util.Scanner;

public class BillingApplication {

    public static void main(String[] args) {

        var billing = new BillingService(new ClientInMemoryDB());
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's is client reference: ");
        String client = scanner.nextLine();
        System.out.println("What's is his gas consumption: ");
        int gasConsumption = scanner.nextInt();
        System.out.println("What's is his electricity consumption: ");
        int elecConsumption = scanner.nextInt();

        var result = billing.compute(
            client,
            List.of(new ConsumptionQuantity(EnergyType.GAS, gasConsumption), new ConsumptionQuantity(EnergyType.ELECTRICITY, elecConsumption))
        );

        System.out.printf("The billing value is : %f%n", result);

    }
}
