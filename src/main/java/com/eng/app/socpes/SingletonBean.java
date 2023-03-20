package com.eng.app.socpes;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class SingletonBean {

    Logger logger = LogManager.getLogger(SingletonBean.class);

    @Autowired
    private PrototypeBean prototypeBean;

    public SingletonBean() {
        logger.info("SingletonBean instance created");
    }



}
