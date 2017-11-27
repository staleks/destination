package com.jatheon.demo.destination.service;

import com.jatheon.demo.destination.model.dto.DestinationDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DestinationService {

    /**
     * @return
     */
    List<DestinationDTO> findAll();

}
