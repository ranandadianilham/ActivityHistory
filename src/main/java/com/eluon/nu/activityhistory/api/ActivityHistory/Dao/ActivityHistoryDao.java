package com.eluon.nu.activityhistory.api.ActivityHistory.Dao;

import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityHistoryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int saveTransaction(TransactionDetails transDetails){
        String sql = "insert into transactionhistory(trx_id,user_id,service_id,service_message) values (?,?,?,?)";

        return jdbcTemplate.update(sql,transDetails.getTrx_id(),transDetails.getUser_id(), transDetails.getService_id(),transDetails.getService_message());
    }
}
