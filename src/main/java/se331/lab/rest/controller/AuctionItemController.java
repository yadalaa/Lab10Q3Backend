package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.service.AuctionItemService;
import se331.lab.rest.util.LabMapper;
@RequiredArgsConstructor
@Controller
public class AuctionItemController {
    final AuctionItemService auctionItemService;
    @GetMapping("auctions")
    public ResponseEntity<?> getAuctionItemLists(@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title",required = false) String title) {
        perPage = perPage == null? 3:perPage;
        page = page == null?1:page;
        Page<AuctionItem> pageOutput;
        if(title ==null){
            pageOutput = auctionItemService.getAuctionItems(perPage,page);
        }else{
            pageOutput = auctionItemService.getAuctionItems(title,title, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionItemDto(pageOutput.getContent())
                ,responseHeader, HttpStatus.OK);

    }
    @GetMapping("auctions/{id}")
    public ResponseEntity<?> getAuctionItem(@PathVariable("id") Long id) {
        AuctionItem output = auctionItemService.getAuctionItem(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionItemDto(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
}
