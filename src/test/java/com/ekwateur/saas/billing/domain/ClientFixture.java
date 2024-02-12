package com.ekwateur.saas.billing.domain;

import com.ekwateur.saas.billing.domain.model.EkwateurClient;

public interface ClientFixture {

    static EkwateurClient sampleParticularClient() {
        return new EkwateurClient.ParticularClient("EKW12345678");
    }

    static EkwateurClient sampleProClient(int ca) {
        return new EkwateurClient.ProfessionalClient("EKW45678901", ca);
    }
}
