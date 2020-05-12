package com.finley.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ֣Զ�� on 2017/8/1.
 */

@Service
public class DataBaseTestService {
    @Autowired
    DataBaseTestDao dataBaseTestDao;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void testDeadlockTransaction1() {
        dataBaseTestDao.testDeadLock(1, 2, null);
        System.out.println("test deadlock1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test deadlock2");
        dataBaseTestDao.testDeadLock(2, 2, null);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void testDeadlockTransaction2() {
        dataBaseTestDao.testDeadLock(2, null, "test");
        System.out.println("test deadlock3");
        try {

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test deadlock4");
        dataBaseTestDao.testDeadLock(1,null,"test");
    }

}
