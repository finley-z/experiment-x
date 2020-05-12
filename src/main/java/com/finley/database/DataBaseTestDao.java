package com.finley.database;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Ö£Ô¶·æ on 2017/8/1.
 */
public interface DataBaseTestDao {

    void testDeadLock(@Param("id") Integer id,@Param("status") Integer status,@Param("value") String value);


}
