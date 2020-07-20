package com.cathaybk.mktdata.restful.api;

import com.cathaybk.mktdata.model.Country;
import com.cathaybk.mktdata.model.Currency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticDataController {

    @GetMapping("/api/static/countries")
    public Country[] getCountries() {
        return Country.values();
    }

    @GetMapping("/api/static/currencies")
    public Currency[] getCurrencies() {
        return Currency.values();
    }

}
