package com.finley.database.service;

import com.finley.database.dao.DataBaseTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ö£Ô¶·æ on 2017/8/1.
 */

@Service
public class DataBaseTestService {
    @Autowired
    DataBaseTestDao dataBaseTestDao;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void testDeadlock1() {
        dataBaseTestDao.updateTest1(1);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dataBaseTestDao.updateTest1(2);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void testDeadlock() {
        dataBaseTestDao.updateTest1(2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dataBaseTestDao.updateTest1(1);
    }

}
