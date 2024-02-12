package com.ekwateur.saas.billing.infra;

import com.ekwateur.saas.billing.domain.ClientRepository;
import com.ekwateur.saas.billing.domain.model.EkwateurClient;
import com.ekwateur.saas.billing.domain.model.EkwateurClient.ParticularClient;
import com.ekwateur.saas.billing.domain.model.EkwateurClient.ProfessionalClient;

import java.util.Map;
import java.util.Optional;

public class ClientInMemoryDB implements ClientRepository {

    public static final Map<String, EkwateurClient> data = Map.of(
        "EKW12345678", new ParticularClient("EKW12345678"),
        "EKW23456789", new ProfessionalClient("EKW23456789", 1000),
        "EKW45678901", new ProfessionalClient("EKW45678901", 1000000000)
    );

    @Override
    public Optional<EkwateurClient> getClient(String clientRef) {
        return Optional.ofNullable(data.get(clientRef));
    }
}
