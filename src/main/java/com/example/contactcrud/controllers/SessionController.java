package com.example.summerschool.controllers;


import com.example.summerschool.dto.SaveSessionDto;
import com.example.summerschool.models.Session;
import com.example.summerschool.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Session")
public class SessionController {

    @Autowired
    SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @PostMapping("/Create")
    public Integer  createSession(@RequestBody SaveSessionDto saveSessionDto) {
        return sessionService.save(saveSessionDto);
    }

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable Integer id) {
        System.out.println("1");
        return sessionService.findById(id);
    }

    @GetMapping("/All")
    public List<Session> getAllSessions() {
        return sessionService.findAll();
    }

    @PutMapping("/{id}")
    public void updateSession(@PathVariable Integer id, @RequestBody SaveSessionDto updatedSessionDto) {
        sessionService.update(id, updatedSessionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Integer id) {
        sessionService.delete(id);
    }



}
