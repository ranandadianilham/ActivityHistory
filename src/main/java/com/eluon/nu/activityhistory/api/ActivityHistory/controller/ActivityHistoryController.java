package com.eluon.nu.activityhistory.api.ActivityHistory.controller;

import com.eluon.nu.activityhistory.api.ActivityHistory.model.ResponseModel;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.eluon.nu.activityhistory.api.ActivityHistory.service.ActivityHistoryServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/nu/")
public class ActivityHistoryController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ActivityHistoryServiceImpl activityHistoryService;

    @GetMapping("/welcome")
    public String test(){
        return "welcome to activity history";
    }

    //request for inserting transaction history for user type KYAI
    @RequestMapping(value = "insertactivityhistory/kyai", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity insertKyai(@Validated @RequestHeader("user_id") String user_id,
                                                               @Validated @RequestBody TransactionDetails transactionDetails){
        logger.info("insert transaction details as kyai");
        return activityHistoryService.saveTransaction("k",transactionDetails);
    }

    //request for inserting transaction history for user type USER
    @RequestMapping(value = "insertactivityhistory/user", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity insertUser(@Validated @RequestHeader("user_id") String user_id,
                                                    @Validated @RequestBody TransactionDetails transactionDetails){
        logger.info("insert transaction details as user");
        return activityHistoryService.saveTransaction("u",transactionDetails);
    }

    //search history by user id
    @RequestMapping(value = "/userhistory", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity searchTransactionByUserId(@RequestHeader("user_id") String user_id, @RequestBody Map<String, String> userDetails){
        logger.info("search transaction history by user_id");
        return activityHistoryService.searchTransactionByUserId(userDetails.get("user_id"));
    }
}
