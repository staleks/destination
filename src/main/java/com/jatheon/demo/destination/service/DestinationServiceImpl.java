package com.jatheon.demo.destination.service;

import com.jatheon.demo.destination.model.Country;
import com.jatheon.demo.destination.model.Destination;
import com.jatheon.demo.destination.model.dto.DestinationDTO;
import com.jatheon.demo.destination.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RefreshScope
public class DestinationServiceImpl implements DestinationService {

    private DestinationRepository destinationRepository;

    @Value("${filter.country:0}")
    private Integer countryFilter;

    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public List<DestinationDTO> findAll() {
        Pageable pageRequest = new PageRequest(0, 100);
        if (countryFilter != 0) {
            Page<Destination> destinationsFilteredDB = destinationRepository.filterByCountryId(countryFilter, pageRequest);
            return mapFromList(destinationsFilteredDB.getContent());
        } else {

            Page<Destination> destinationsAllDB = destinationRepository.findAll(pageRequest);
            return mapFromList(destinationsAllDB.getContent());
        }
    }

    @Override
    public DestinationDTO findOne(final Long destinationId) {
        return mapFromEntity(destinationRepository.findOne(destinationId));
    }

    /**
     *
     * @param entity
     * @return
     */
    private DestinationDTO mapFromEntity(Destination entity) {
        return new DestinationDTO(entity.getId(), entity.getName(), entity.getStarRating(), Country.countryById(entity.getCountryId()).getName());
    }

    /**
     *
     * @param destinations
     * @return
     */
    private List<DestinationDTO> mapFromList(List<Destination> destinations) {
        List<DestinationDTO> result = new ArrayList<>();
        for (Destination des: destinations) {
            result.add(mapFromEntity(des));
        }
        return result;
    }
}
