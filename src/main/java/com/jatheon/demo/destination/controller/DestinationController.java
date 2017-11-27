package com.jatheon.demo.destination.controller;

import com.jatheon.demo.destination.model.dto.DestinationDTO;
import com.jatheon.demo.destination.service.DestinationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DestinationController {

    private DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping("/")
    public List<DestinationDTO> getDestinations() {
        return destinationService.findAll();
    }

}
