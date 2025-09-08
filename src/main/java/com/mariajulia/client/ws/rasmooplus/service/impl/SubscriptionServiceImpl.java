package com.mariajulia.client.ws.rasmooplus.service.impl;

import com.mariajulia.client.ws.rasmooplus.exception.NotFoundException;
import com.mariajulia.client.ws.rasmooplus.model.SubscriptionType;
import com.mariajulia.client.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.mariajulia.client.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    public SubscriptionServiceImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        return getSubscriptionType(id);
    }

    @Override
    public SubscriptionType save(SubscriptionType subscriptionType) {
        return subscriptionTypeRepository.save(subscriptionType);
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionType subscriptionType) {
        getSubscriptionType(id);
        return subscriptionTypeRepository.save(SubscriptionType.builder().id(id)
                .name(subscriptionType.getName())
                .accessMonths(subscriptionType.getAccessMonths())
                .price(subscriptionType.getPrice())
                .productKey(subscriptionType.getProductKey())
                .build());
    }

    @Override
    public void deleteById(Long id) {

    }

    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = subscriptionTypeRepository.findById(id);
        if (optionalSubscriptionType.isEmpty()) {
            throw new NotFoundException("SubscriptionType não encontrado");
        }
        return optionalSubscriptionType.get();
    }
}
