package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.repository.AuctionItemRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AuctionItemDaoImpl implements AuctionItemDao {
    final AuctionItemRepository auctionItemRepository;
    @Override
    public Integer getAuctionItemSize() {
            return Math.toIntExact(auctionItemRepository.count());
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return  auctionItemRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public AuctionItem getAuctionItem(Long id) {
        return auctionItemRepository.findById(id).orElse(null);
    }

    @Override
    public Page<AuctionItem> getAuctionItem(String description,String type, Pageable page) {
        return auctionItemRepository.findByDescriptionIgnoreCaseContainingOrTypeIgnoreCaseContaining(description,type,page);
    }
}
