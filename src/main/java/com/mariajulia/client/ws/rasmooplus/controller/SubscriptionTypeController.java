package com.mariajulia.client.ws.rasmooplus.controller;

import com.mariajulia.client.ws.rasmooplus.dto.request.SubscriptionTypeRequest;
import com.mariajulia.client.ws.rasmooplus.dto.response.SubscriptionTypeResponse;
import com.mariajulia.client.ws.rasmooplus.mapper.SubscriptionTypeMapper;
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
    public ResponseEntity<List<SubscriptionTypeResponse>> findAll() {
        List<SubscriptionTypeResponse> subscriptionTypeResponse = subscriptionTypeService.findAll().stream().
                map(SubscriptionTypeMapper::toSubscriptionTypeResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionTypeResponse> findById(@PathVariable Long id) {
        SubscriptionTypeResponse subscriptionTypeResponse = SubscriptionTypeMapper.toSubscriptionTypeResponse(subscriptionTypeService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeResponse);
    }

    @PostMapping
    public ResponseEntity<SubscriptionTypeResponse> save(@RequestBody SubscriptionTypeRequest subscriptionTypeRequest) {
        SubscriptionTypeResponse subscriptionTypeResponse = SubscriptionTypeMapper.toSubscriptionTypeResponse(
                subscriptionTypeService.save(SubscriptionTypeMapper.toSubscriptionType(subscriptionTypeRequest))
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionTypeResponse> update(@PathVariable Long id, @RequestBody SubscriptionTypeRequest subscriptionTypeRequest) {

        SubscriptionType subscriptionType = SubscriptionTypeMapper.toSubscriptionType(subscriptionTypeRequest);

        SubscriptionTypeResponse subscriptionTypeResponse = SubscriptionTypeMapper.toSubscriptionTypeResponse(subscriptionTypeService.update(id, subscriptionType));

        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        subscriptionTypeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
