package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Bid;
import se331.lab.rest.repository.AuctionItemRepository;
import se331.lab.rest.repository.BidRepository;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionItemRepository auctionItemRepository;
    final BidRepository bidRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Bid b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
        b1 = bidRepository.save(Bid.builder()
                .amount(50)
                .datetime(LocalDateTime.now())
                .build());
        b2 = bidRepository.save(Bid.builder()
                .amount(100)
                .datetime(LocalDateTime.now())
                .build());
        b3 = bidRepository.save(Bid.builder()
                .amount(150)
                .datetime(LocalDateTime.now())
                .build());
        b4 = bidRepository.save(Bid.builder()
                .amount(200)
                .datetime(LocalDateTime.now())
                .build());
        b5 = bidRepository.save(Bid.builder()
                .amount(250)
                .datetime(LocalDateTime.now())
                .build());
        b6 = bidRepository.save(Bid.builder()
                .amount(300)
                .datetime(LocalDateTime.now())
                .build());
        b7 = bidRepository.save(Bid.builder()
                .amount(350)
                .datetime(LocalDateTime.now())
                .build());
        b8 = bidRepository.save(Bid.builder()
                .amount(400)
                .datetime(LocalDateTime.now())
                .build());
        b9 = bidRepository.save(Bid.builder()
                .amount(450)
                .datetime(LocalDateTime.now())
                .build());
        b10 = bidRepository.save(Bid.builder()
                .amount(500)
                .datetime(LocalDateTime.now())
                .build());
        b11 = bidRepository.save(Bid.builder()
                .amount(550)
                .datetime(LocalDateTime.now())
                .build());
        b12 = bidRepository.save(Bid.builder()
                .amount(600)
                .datetime(LocalDateTime.now())
                .build());
        b13 = bidRepository.save(Bid.builder()
                .amount(650)
                .datetime(LocalDateTime.now())
                .build());
        b14 = bidRepository.save(Bid.builder()
                .amount(700)
                .datetime(LocalDateTime.now())
                .build());
        b15 = bidRepository.save(Bid.builder()
                .amount(750)
                .datetime(LocalDateTime.now())
                .build());
        AuctionItem item1,item2,item3,item4,item5;
        item1 = auctionItemRepository.save(AuctionItem.builder()
                .description("Pocket-sized multi-function device")
                .type("Smartphone")
                .build());
//        item1.getBids().add(b1);
//        item1.getBids().add(b2);
//        item1.getBids().add(b3);
        b1.setItem(item1);
        b2.setItem(item1);
        b3.setItem(item1);
        item1.setSuccessfulBid(b3);
        item2 = auctionItemRepository.save(AuctionItem.builder()
                .description("Shoulder-worn bag")
                .type("Backpack")
                .build());
//        item2.getBids().add(b4);
//        item2.getBids().add(b5);
//        item2.getBids().add(b6);
        b4.setItem(item2);
        b5.setItem(item2);
        b6.setItem(item2);
        item2.setSuccessfulBid(b6);
        item3 = auctionItemRepository.save(AuctionItem.builder()
                .description("Two-wheel transport")
                .type("Bicycle")
                .build());
//        item3.getBids().add(b7);
//        item3.getBids().add(b8);
//        item3.getBids().add(b9);
        b7.setItem(item3);
        b8.setItem(item3);
        b9.setItem(item3);
        item3.setSuccessfulBid(b9);
        item4 = auctionItemRepository.save(AuctionItem.builder()
                .description("Image-capturing gadget")
                .type("Digital Camera")
                .build());
//        item4.getBids().add(b10);
//        item4.getBids().add(b10);
//        item4.getBids().add(b10);
        b10.setItem(item4);
        b11.setItem(item4);
        b12.setItem(item4);
        item4.setSuccessfulBid(b12);
        item5 = auctionItemRepository.save(AuctionItem.builder()
                .description("Java brewer")
                .type("Coffee Maker")
                .build());
//        item5.getBids().add(b13);
//        item5.getBids().add(b14);
//        item5.getBids().add(b15);
        b13.setItem(item5);
        b14.setItem(item5);
        b15.setItem(item5);
        item5.setSuccessfulBid(b15);
    }
}
