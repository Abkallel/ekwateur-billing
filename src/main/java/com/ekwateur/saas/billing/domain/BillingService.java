package com.ekwateur.saas.billing.domain;

import com.ekwateur.saas.billing.domain.model.ConsumptionQuantity;
import com.ekwateur.saas.billing.domain.model.EnergyPricing;

import java.util.List;

public class BillingService {
    private final ClientRepository repository;

    public BillingService(ClientRepository repository) {
        this.repository = repository;
    }

    public float compute(String clientRef, List<ConsumptionQuantity> consumptions) {

        return repository.getClient(clientRef)
            .map(EnergyPricingResolver::getPricingValues)
            .map(unitPrice -> doCalculate(consumptions, unitPrice))
            .orElseThrow(() -> new RuntimeException("No client found for this user"));
    }

    private static float doCalculate(List<ConsumptionQuantity> consumptions, EnergyPricing unitPricing) {
        return consumptions.stream()
            .map(consumption -> unitPricing.getPricing(consumption.energyType()) * consumption.quantity())
            .reduce(0F, Float::sum);
    }
}
