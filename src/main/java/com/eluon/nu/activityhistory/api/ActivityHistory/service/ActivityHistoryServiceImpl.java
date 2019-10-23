package com.eluon.nu.activityhistory.api.ActivityHistory.service;

import com.eluon.nu.activityhistory.api.ActivityHistory.Dao.ActivityHistoryDao;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.ResponseModel;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActivityHistoryServiceImpl implements ActivityHistoryService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ActivityHistoryDao activityHistoryDao;
    @Override
    public ResponseEntity<ResponseModel> saveTransactionHistory(TransactionDetails transactionDetails) {
        logger.info("Transaction com.eluon.nu.activityhistory.api.ActivityHistory.service");
        //check whether each attribute is not empty
        if(transactionDetails.getTrx_id().equals("") || transactionDetails.getService_id().equals("") || transactionDetails.getUser_id().equals("") ||
                transactionDetails.getService_message().equals("") || transactionDetails.getUser_type().equals("")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseModel(1,"Request is not right"));
        }

        //send request body to com.eluon.nu.activityhistory.api.ActivityHistory.service class
        int responseBody = activityHistoryDao.saveTransaction(transactionDetails);
        ResponseModel result = new ResponseModel(0,"OK");
        //return result from com.eluon.nu.activityhistory.api.ActivityHistory.service
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
