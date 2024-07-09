package com.abmpf.abmpf.controller;

import com.abmpf.abmpf.entities.Client;
import com.abmpf.abmpf.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<Client> registerClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.registerClient(client));
    }
}
