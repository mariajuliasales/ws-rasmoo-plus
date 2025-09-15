package com.mariajulia.client.ws.rasmooplus.controller;

import com.mariajulia.client.ws.rasmooplus.dto.request.UserTypeRequest;
import com.mariajulia.client.ws.rasmooplus.dto.response.UserTypeResponse;
import com.mariajulia.client.ws.rasmooplus.mapper.UserTypeMapper;
import com.mariajulia.client.ws.rasmooplus.service.UserTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-type")
public class UserTypeController {

    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping
    public ResponseEntity<List<UserTypeResponse>> findAll() {
        List<UserTypeResponse> userTypeResponse = userTypeService.findAll().stream()
                .map(UserTypeMapper::toUserTypeResponse)
                .toList();
        return ResponseEntity.ok(userTypeResponse);
    }

    @PostMapping
    public ResponseEntity<UserTypeResponse> create(@Valid @RequestBody UserTypeRequest userTypeRequest) {
        UserTypeResponse userTypeResponse = UserTypeMapper.toUserTypeResponse(
                userTypeService.create(UserTypeMapper.toUserType(userTypeRequest)));

        return ResponseEntity.status(HttpStatus.CREATED).body(userTypeResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserTypeResponse> update(@PathVariable Long id, @Valid @RequestBody UserTypeRequest userTypeRequest) {

        UserTypeResponse userTypeResponse = UserTypeMapper.toUserTypeResponse(
                userTypeService.update(id, UserTypeMapper.toUserType(userTypeRequest)));

        return ResponseEntity.status(HttpStatus.OK).body(userTypeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userTypeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
