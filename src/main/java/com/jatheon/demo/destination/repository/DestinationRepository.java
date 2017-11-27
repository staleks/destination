package com.jatheon.demo.destination.repository;

import com.jatheon.demo.destination.model.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends PagingAndSortingRepository <Destination, Long> {

    @Query("select d from Destination d where d.countryId <> ?1")
    Page<Destination> filterByCountryId(Integer countryId, Pageable pageable);

}
