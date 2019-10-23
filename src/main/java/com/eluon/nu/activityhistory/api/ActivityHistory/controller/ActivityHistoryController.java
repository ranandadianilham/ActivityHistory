package com.eluon.nu.activityhistory.api.ActivityHistory.controller;

import com.eluon.nu.activityhistory.api.ActivityHistory.model.ResponseModel;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.eluon.nu.activityhistory.api.ActivityHistory.service.ActivityHistoryServiceImpl;

@RestController
@RequestMapping
public class ActivityHistoryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ActivityHistoryServiceImpl activityHistoryService;

    @GetMapping("/test")
    public String test(){
        return "test 123";
    }

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseModel> saveTransactionHistory(@Validated @RequestHeader("user_id") String user_id,
                                                                @Validated @RequestBody TransactionDetails transactionDetails){
        //show currently logged in user id
        logger.info("Logged as "+user_id);

       /* //check whether each attribute is not empty
        if(transactionDetails.getTrx_id().equals("") || transactionDetails.getService_id().equals("") || transactionDetails.getUser_id().equals("") ||
                transactionDetails.getService_message().equals("") || transactionDetails.getUser_type().equals("")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseModel(1,"Request is not right"));
        }

        //send request body to com.eluon.nu.activityhistory.api.ActivityHistory.service class
        int responseBody = activityHistoryService.saveTransactionHistory(transactionDetails);
        ResponseModel result = new ResponseModel(0,"OK");*/
        //return result from com.eluon.nu.activityhistory.api.ActivityHistory.service


        return activityHistoryService.saveTransactionHistory(transactionDetails);
    }
}
