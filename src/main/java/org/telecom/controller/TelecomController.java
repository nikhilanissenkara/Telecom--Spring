package org.telecom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telecom.exception.TelecomException;
import org.telecom.telecom_service.TelecomService;
import org.telecom.telecomdto.request.SimDetailsRequest;
import org.telecom.telecomdto.response.SimDetailsResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TelecomController {
    Logger logger = LoggerFactory.getLogger(TelecomController.class);
    @Autowired
    private TelecomService telecomService;

    @GetMapping
    public String helloWorld(@RequestBody String str) {
        return str;
    }

    //URI path should be small letters or camelcasing, same as java variables
    @GetMapping(value="/status")
    public ResponseEntity<SimDetailsResponse> simStatus(@Valid @RequestBody SimDetailsRequest simDetailsrequest) {
        logger.debug("SimDetails Status is shown");
        return new ResponseEntity<>(telecomService.simStatus(simDetailsrequest), HttpStatus.OK);
    }

    @GetMapping(value="/simDetails")
    public List<SimDetailsResponse> simDetails() {
        logger.debug(" All SimDetails are fetched ");
        return telecomService.simDetails();
    }

    @GetMapping(value="/details")
    public SimDetailsResponse getSimDetail(@RequestBody SimDetailsRequest simDetailsRequest) throws TelecomException {
        logger.debug("Got Simdetail by Id");
        return telecomService.getSimDetail(simDetailsRequest);
    }

    @PostMapping(value="/add")
    public List<SimDetailsResponse> addSim(@RequestBody SimDetailsRequest simDetailsRequest){
        logger.debug("SimDetails are added");
        return telecomService.addSim(simDetailsRequest);
    }

    @PutMapping ("/update")
    public SimDetailsResponse updateSim(@RequestBody SimDetailsRequest simDetailsRequest)throws TelecomException {
        logger.debug("SimDetails are updated");
        return telecomService.updateSim(simDetailsRequest);
    }

    @DeleteMapping("/delete")
    public List<SimDetailsResponse> deleteSim(@RequestBody SimDetailsRequest simDetailsRequest) throws TelecomException {
        logger.debug("SimDetails are deleted");
        return telecomService.deleteSim(simDetailsRequest);
    }
}
