package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Bid;

import java.util.Optional;

public interface BidDao {
    Page<Bid> getBid(Pageable pageRequest);
    Optional<Bid> findById(Long id);
}
