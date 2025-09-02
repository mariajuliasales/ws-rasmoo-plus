package com.mariajulia.client.ws.rasmooplus.repository;

import com.mariajulia.client.ws.rasmooplus.model.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Long> {
}
