package com.ekwateur.saas.billing.domain.model;

public record EnergyPricing(float electricityUnitPricing, float gasUnitPricing) {

    public float getPricing(EnergyType type) {
        return switch (type) {
            case GAS -> gasUnitPricing;
            case ELECTRICITY -> electricityUnitPricing;
        };
    }

}







