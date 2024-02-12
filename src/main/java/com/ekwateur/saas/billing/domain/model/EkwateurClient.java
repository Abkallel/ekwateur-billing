package com.ekwateur.saas.billing.domain.model;

public interface EkwateurClient {

    String refClient();

    record ParticularClient(String refClient) implements EkwateurClient {
    }

    record ProfessionalClient(String refClient, Integer capital) implements EkwateurClient {
        public boolean hasOneMillionCa() {
            return capital >= 1000000;
        }
    }

}
