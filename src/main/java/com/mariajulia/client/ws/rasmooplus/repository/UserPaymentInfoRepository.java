package com.mariajulia.client.ws.rasmooplus.repository;

import com.mariajulia.client.ws.rasmooplus.model.UserPaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentInfoRepository extends JpaRepository<UserPaymentInfo, Long> {
}
