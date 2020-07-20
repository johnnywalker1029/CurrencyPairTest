package com.cathaybk.mktdata.data;

import com.cathaybk.mktdata.model.Trade;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryStore {

    int GLOBAL_ID = 0;

    List<Trade> trades = new ArrayList<>();

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    public int getAvailableID() {
        return GLOBAL_ID++;
    }
}
