package com.example.demo.controller;

import com.example.demo.service.GenerateToken;
import com.example.demo.service.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class jwtController {

    @Autowired
    GenerateToken generateToken;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping
    String Hello()
    {
        return "Hello";
    }
    //http://localhost:8080/getToken/vpaas-magic-cookie-19abd7149eb746799135ee2fc961418f/d56493/389/vedant
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getToken/{appId}/{tenantId}/{roomName}/{userName}")
    public Token getToken(@PathVariable String appId, @PathVariable String tenantId, @PathVariable String roomName, @PathVariable String userName )
    {
                 Token t = new Token();
                 t.token = generateToken.generateToken(appId,tenantId,roomName,userName);
        return t;
    }
}
