package com.ekwateur.saas.billing.domain;

import com.ekwateur.saas.billing.domain.model.EkwateurClient;

import java.util.Optional;

public interface ClientRepository {
    Optional<EkwateurClient> getClient(String clientRef);
}
