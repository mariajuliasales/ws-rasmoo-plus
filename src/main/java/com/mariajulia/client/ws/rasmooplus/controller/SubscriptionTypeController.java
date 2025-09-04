package com.mariajulia.client.ws.rasmooplus.controller;

import com.mariajulia.client.ws.rasmooplus.model.SubscriptionType;
import com.mariajulia.client.ws.rasmooplus.service.SubscriptionTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {

    public final SubscriptionTypeService subscriptionTypeService;

    public SubscriptionTypeController(SubscriptionTypeService subscriptionTypeService) {
        this.subscriptionTypeService = subscriptionTypeService;
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable Long id) {
        SubscriptionType subscriptionType = subscriptionTypeService.findById(id);
        if (subscriptionType != null) {
            return ResponseEntity.status(HttpStatus.OK).body(subscriptionType);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
