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
    public SimDetailsResponse simStatus(@RequestBody SimDetailsRequest request) {
        return telecomService.simStatus(request);
    }

    @GetMapping(value="/simDetails")
    public List<SimDetailsResponse> simDetails() {
        return telecomService.simDetails();
    }

    @GetMapping(value="/details")
    public SimDetails getSimDetail(@RequestBody SimDetailsRequest simDetailsRequest) throws TelecomException {
        return telecomService.getSimDetail(simDetailsRequest);
    }

    @PostMapping(value="/add")
    public int addSim(@RequestBody SimDetailsRequest simDetailsRequest){
        int simId=telecomService.addSim(simDetailsRequest);
        return simId;
    }

    @PutMapping ("/update")
    public String updateSim(@RequestBody SimDetailsRequest simDetailsRequest)throws TelecomException {
        telecomService.updateSim(simDetailsRequest);
        return "updated";
    }

    @DeleteMapping("/delete")
    public String deleteSim(@RequestBody SimDetailsRequest simDetailsRequest) throws TelecomException {
        telecomService.deleteSim(simDetailsRequest);
        return "deleted";
    }
}
