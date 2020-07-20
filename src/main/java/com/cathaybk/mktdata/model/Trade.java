package com.cathaybk.mktdata.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Trade {

    private int id;
    private String userId;
    private String currPair;
    private BigDecimal amt;
    private BigDecimal rate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime placedTime;
    private Country originCountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrPair() {
        return currPair;
    }

    public void setCurrPair(String currPair) {
        this.currPair = currPair;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDateTime getPlacedTime() {
        return placedTime;
    }

    public void setPlacedTime(LocalDateTime placedTime) {
        this.placedTime = placedTime;
    }

    public Country getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(Country originCountry) {
        this.originCountry = originCountry;
    }
}
