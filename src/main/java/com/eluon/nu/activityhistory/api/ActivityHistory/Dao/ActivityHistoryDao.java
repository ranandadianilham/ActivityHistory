package com.eluon.nu.activityhistory.api.ActivityHistory.Dao;

import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetails;
import com.eluon.nu.activityhistory.api.ActivityHistory.model.TransactionDetailsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityHistoryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //save transaction details into database
    public int saveTransaction(String user_type, TransactionDetails transDetails){

        String sql = "insert into transaction(user_id,user_type,calling_type,information) values(?,?,?,?)";
        return jdbcTemplate.update(sql,
            transDetails.getUser_id(),
            user_type,
            transDetails.getCalling_type(),
            transDetails.getInformation());
    }
    //search for transaction details by user_id
    public List<TransactionDetailsEntity> searchHistoryByUserId(String user_id){
        logger.info("user id "+user_id+" to select from transaction table");
        String sql = "select * from transaction where user_id='"+user_id+"'";
        RowMapper<TransactionDetailsEntity> rowMapper = new BeanPropertyRowMapper<TransactionDetailsEntity>(TransactionDetailsEntity.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
}
