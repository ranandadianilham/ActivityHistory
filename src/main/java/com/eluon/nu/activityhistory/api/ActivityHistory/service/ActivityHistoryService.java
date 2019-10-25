package com.eluon.nu.activityhistory.api.ActivityHistory.service;

import com.eluon.nu.activityhistory.api.ActivityHistory.model.ResponseModel;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetails;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetailsEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ActivityHistoryService {
    public ResponseEntity<ResponseModel> saveTransaction(String user_type, TransactionDetails transactionDetails);

    public ResponseEntity<TransactionDetailsEntity> searchTransactionByUserId(String user_id);

}
