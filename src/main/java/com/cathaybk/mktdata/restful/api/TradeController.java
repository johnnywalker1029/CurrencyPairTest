package com.cathaybk.mktdata.restful.api;

import com.cathaybk.mktdata.data.MemoryStore;
import com.cathaybk.mktdata.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TradeController {

    private MemoryStore memoryStore;

    @Autowired
    private TradeController(MemoryStore memoryStore) {
        this.memoryStore = memoryStore;
    }

    @PostMapping("/api/post_trade")
    public void postTrade(@RequestBody Trade trade) throws InterruptedException {
        try {
            trade.setId(memoryStore.getAvailableID());
            if (trade.getPlacedTime() == null) {
                trade.setPlacedTime(LocalDateTime.now());
            }
            this.memoryStore.getTrades().add(trade);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/api/trades")
    public List<Trade> getTrades() {
        return this.memoryStore.getTrades();
    }


}
