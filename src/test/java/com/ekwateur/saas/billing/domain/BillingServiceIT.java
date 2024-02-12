package com.ekwateur.saas.billing.domain;

import com.ekwateur.saas.billing.domain.model.ConsumptionQuantity;
import com.ekwateur.saas.billing.domain.model.EnergyType;
import com.ekwateur.saas.billing.infra.ClientInMemoryDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class BillingServiceIT {


    @Test
    void should_compute_billing_for_valid_client() {

        var service = new BillingService(new ClientInMemoryDB());
        var consumptions = List.of(
            new ConsumptionQuantity(EnergyType.ELECTRICITY, 122),
            new ConsumptionQuantity(EnergyType.GAS, 122)
        );
        var result = service.compute(ClientFixture.sampleParticularClient().refClient(), consumptions);
        Assertions.assertEquals(result, 28.792F);
    }


    @Test
    void should_fail_to_compute_billing_du_invalid_client() {

        var service = new BillingService(new ClientInMemoryDB());
        var consumptions = List.of(
            new ConsumptionQuantity(EnergyType.ELECTRICITY, 122),
            new ConsumptionQuantity(EnergyType.GAS, 122)
        );

        Assertions.assertThrows(RuntimeException.class, () -> service.compute("unknownref", consumptions), "No client found for this user");
    }

}
