package com.cathaybk.mktdata.restful.api;


import com.cathaybk.mktdata.data.MemoryStore;
import com.cathaybk.mktdata.model.Country;
import com.cathaybk.mktdata.model.Trade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeControllerTest {
    private final static Logger logger = LoggerFactory.getLogger(TradeControllerTest.class);

    @Autowired
    private TradeController tradeController;

    @Autowired
    private MemoryStore memoryStore;

    @Test
    public void test_post_trade() throws Exception {
        Trade trade = new Trade();
        trade.setId(0);
        trade.setRate(new BigDecimal(0.7471));
        trade.setAmt(new BigDecimal(1000));
        trade.setPlacedTime(LocalDateTime.now());
        trade.setOriginCountry(Country.HK);
        trade.setUserId("Johnny Wong");
        trade.setCurrPair("EUR/GBP");
        tradeController.postTrade(trade);
        Assert.assertEquals("Numer of Trade is not expected", memoryStore.getTrades().size(), 1);
        Assert.assertEquals("Id is not expected", memoryStore.getTrades().get(0).getId(), trade.getId());
        Assert.assertEquals("Rate is not expected", memoryStore.getTrades().get(0).getRate(), trade.getRate());
        Assert.assertEquals("Amt is not expected", memoryStore.getTrades().get(0).getAmt(), trade.getAmt());
        Assert.assertEquals("Placed Time is not expected", memoryStore.getTrades().get(0).getPlacedTime(), trade.getPlacedTime());
        Assert.assertEquals("Original Country is not expected", memoryStore.getTrades().get(0).getOriginCountry(), trade.getOriginCountry());
        Assert.assertEquals("User Id is not expected", memoryStore.getTrades().get(0).getUserId(), trade.getUserId());
        Assert.assertEquals("Currency Pair is not expected", memoryStore.getTrades().get(0).getCurrPair(), trade.getCurrPair());
    }

    @Test
    public void test_get_trades() throws Exception {
        for (int i=0;i<23;i++) {
            Trade trade = new Trade();
            trade.setId(this.memoryStore.getAvailableID());
            trade.setRate(new BigDecimal(0.7471));
            trade.setAmt(new BigDecimal(1000));
            trade.setPlacedTime(LocalDateTime.now());
            trade.setOriginCountry(Country.HK);
            trade.setUserId("Johnny Wong");
            trade.setCurrPair("EUR/GBP");
            this.tradeController.postTrade(trade);
        }
        Assert.assertEquals("Currency Pair is not expected", memoryStore.getTrades().size(), 23);
    }
}