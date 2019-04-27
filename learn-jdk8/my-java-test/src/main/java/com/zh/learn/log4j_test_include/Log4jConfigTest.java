package com.zh.learn.log4j_test_include;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-27
 */
public class Log4jConfigTest {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Log4jConfigTest.class);

        logger.trace( " this is {} trace log", Log4jConfigTest.class.getName() );
        logger.debug( " this is {} debug log", Log4jConfigTest.class.getName() );
        logger.info( " this is {} info log", Log4jConfigTest.class.getName() );
        logger.warn( " this is {} warn log", Log4jConfigTest.class.getName() );
        logger.error( " this is {} error log", Log4jConfigTest.class.getName());


    }

}
