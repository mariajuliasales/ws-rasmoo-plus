package com.mariajulia.client.ws.rasmooplus.repository;

import com.mariajulia.client.ws.rasmooplus.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
