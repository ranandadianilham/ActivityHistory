package com.eluon.nu.activityhistory.api.ActivityHistory.service;

import com.eluon.nu.activityhistory.api.ActivityHistory.Dao.ActivityHistoryDao;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.ResponseModel;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetails;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetailsEntity;
import com.eluon.nu.activityhistory.api.ActivityHistory.other.ResponseApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityHistoryServiceImpl implements ActivityHistoryService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ActivityHistoryDao activityHistoryDao;

    //save transaction history into database
    @Override
    public ResponseEntity saveTransaction(String user_type, TransactionDetails transactionDetails) {

        //if transaction details contain empty field
        /*if(transactionDetails.getUser_id().equals("") || transactionDetails.getCalling_type().equals("") ||
                transactionDetails.getInformation().equals("")){
            ResponseApi responseApi = ResponseApi.builder().status(0).message("empty request").data(null).build();
            return responseApi.toBadRequest();
        }*/

        //try to execute transaction data into dao object
        try{
            activityHistoryDao.saveTransaction(user_type, transactionDetails);
            ResponseApi responseApi = ResponseApi.builder().status(0).message("ok").data(new Object[]{}).build();
            return responseApi.toOk(responseApi);
        }catch (Exception e){
            e.printStackTrace();
            ResponseApi responseApi = ResponseApi.builder().status(0).message("fail").data(null).build();
            return responseApi.toBadRequest();
        }
    }

    //look up all transaction history by user id
    @Override
    public ResponseEntity searchTransactionByUserId(String user_id) {
        logger.info("search under user_id "+user_id);
        try{
            List<TransactionDetailsEntity> listResult = activityHistoryDao.searchHistoryByUserId(user_id);
            ResponseApi responseApi = ResponseApi.builder().status(0).message("ok").data(listResult).build();
            return responseApi.toOk(responseApi);
        }catch (Exception e){
            e.printStackTrace();
            ResponseApi responseApi = ResponseApi.builder().status(0).message("fail").data(null).build();
            return responseApi.toBadRequest();
        }
    }
}
