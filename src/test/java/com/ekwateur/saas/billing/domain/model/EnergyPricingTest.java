package com.ekwateur.saas.billing.domain.model;

import com.ekwateur.saas.billing.domain.EnergyPricingResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ekwateur.saas.billing.domain.ClientFixture.sampleParticularClient;
import static com.ekwateur.saas.billing.domain.ClientFixture.sampleProClient;

class EnergyPricingTest {


    @MethodSource
    @ParameterizedTest
    void should_return_client_pricing(String scenario, EkwateurClient ekwateurClient, EnergyPricing expected) {
        Assertions.assertEquals(EnergyPricingResolver.getPricingValues(ekwateurClient), expected);
    }

    public static Stream<Arguments> should_return_client_pricing() {
        return Stream.of(
            Arguments.arguments("Particular  Client", sampleParticularClient(), new EnergyPricing(0.121F, 0.115F)),
            Arguments.arguments("Pro Client with CA less than 1M ", sampleProClient(999999), new EnergyPricing(0.118F, 0.113F)),
            Arguments.arguments("Pro Client with 1M CA", sampleProClient(1000000), new EnergyPricing(0.114F, 0.111F)),
            Arguments.arguments("Pro Client with CA greater than 1M ", sampleProClient(1000001), new EnergyPricing(0.114F, 0.111F))
        );
    }

}
