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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ActivityHistoryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String createTrxId(String serviceCode){
        logger.info("crreate new trx id");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String num = String.valueOf(getRandomNumberInRange(0,1000));
        while(num.length() < 4){
            num = "0" + num;
        }
        return (serviceCode.toUpperCase()+dtf.format(now)+num);
    }
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public boolean isTrxIdExist(String trx_id){
        logger.info("check if trx id exist inside db");
        String sql = "select * from transaction where trx_id='"+trx_id+"'";
        RowMapper<TransactionDetailsEntity> rowMapper = new BeanPropertyRowMapper<>(TransactionDetailsEntity.class);
        if(jdbcTemplate.query(sql,rowMapper).size() == 0){
            return true;
        }
        logger.info(trx_id+" already exist as txd_id, try new one.");
        return false;
    }
    //save transaction details into database
    public int saveTransaction(String user_type, TransactionDetails transDetails){
        logger.info("save transaction into databse now");
        String serviceCode = transDetails.getService_code();
        String trx_id = createTrxId(serviceCode);
        boolean checkIfTrxIdExist = isTrxIdExist(trx_id);
        //check if trx_id exist inside db
        while(!checkIfTrxIdExist){
            logger.info(trx_id+" is not exist inside transaction table");
            trx_id = createTrxId(serviceCode);
            checkIfTrxIdExist = isTrxIdExist(trx_id);
        }

        String sql = "insert into transaction(trx_id,user_id,user_type,calling_type,information) values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,
            trx_id,
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
