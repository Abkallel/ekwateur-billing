package com.ekwateur.saas.billing.domain;

import com.ekwateur.saas.billing.domain.model.EkwateurClient;
import com.ekwateur.saas.billing.domain.model.EnergyPricing;

public class EnergyPricingResolver {

    public static EnergyPricing getPricingValues(EkwateurClient client) {
        return switch (client) {
            case EkwateurClient.ParticularClient ignored -> new EnergyPricing(0.121F, 0.115F);
            case EkwateurClient.ProfessionalClient pp when !pp.hasOneMillionCa() -> new EnergyPricing(0.118F, 0.113F);
            case EkwateurClient.ProfessionalClient pp when pp.hasOneMillionCa() -> new EnergyPricing(0.114F, 0.111F);
            default -> throw new IllegalStateException("Unknown Client type: " + client);
        };
    }
}
