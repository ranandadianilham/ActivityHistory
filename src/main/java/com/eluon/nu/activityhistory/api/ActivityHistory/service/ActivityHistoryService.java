package com.eluon.nu.activityhistory.api.ActivityHistory.service;

import com.eluon.nu.activityhistory.api.ActivityHistory.model.ResponseModel;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetails;
import org.springframework.http.ResponseEntity;

public interface ActivityHistoryService {
    public ResponseEntity<ResponseModel> saveTransactionHistory(TransactionDetails transactionDetails);
}
