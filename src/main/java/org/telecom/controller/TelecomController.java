package org.telecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telecom.exception.TelecomException;
import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.telecom_Entity.SimDetails;
import org.telecom.telecom_service.TelecomService;
import org.telecom.telecomdto.response.SimDetailsResponse;

import java.util.List;

@RestController
public class TelecomController {
    @Autowired
    private TelecomService telecomService;

    @GetMapping
    public String helloWorld() {
        return "Helloworld";
    }

    //URI path should be small letters or camelcasing, same as java variables
    @GetMapping(value="/status")
    public SimDetailsResponse simStatus(@RequestBody SimDetailsRequest simDetailsrequest) {
        return telecomService.simStatus(simDetailsrequest);
    }

    @GetMapping(value="/simDetails")
    public List<SimDetailsResponse> simDetails() {
        return telecomService.simDetails();
    }

    @GetMapping(value="/details")
    public SimDetailsResponse getSimDetail(@RequestBody SimDetailsRequest simDetailsRequest) throws TelecomException {
        return telecomService.getSimDetail(simDetailsRequest);
    }

    @PostMapping(value="/add")
    public List<SimDetailsResponse> addSim(@RequestBody SimDetailsRequest simDetailsRequest){
        return telecomService.addSim(simDetailsRequest);
    }

    @PutMapping ("/update")
    public SimDetailsResponse updateSim(@RequestBody SimDetailsRequest simDetailsRequest)throws TelecomException {
        return telecomService.updateSim(simDetailsRequest);
    }

    @DeleteMapping("/delete")
    public List<SimDetailsResponse> deleteSim(@RequestBody SimDetailsRequest simDetailsRequest) throws TelecomException {
        return telecomService.deleteSim(simDetailsRequest);
    }
}
