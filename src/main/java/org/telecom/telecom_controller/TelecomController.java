package org.telecom.telecom_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.telecom.telecom_service.TelecomService;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
public class TelecomController {


    @Autowired
    private TelecomService telecomService;

    @GetMapping
    public String helloWorld() {
        return "Helloworld";
    }

    //URI path should be small letters or camelcasing, same as java variables
    @GetMapping(value="/status/{simNumber}/{serviceNumber}")
    public String simStatus(@PathVariable @Valid @Min(value=13) Long simNumber,@Min(value=13) Long serviceNumber)
    {
        return telecomService.simStatus(simNumber,serviceNumber);
    }

}
