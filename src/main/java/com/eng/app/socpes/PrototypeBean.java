package com.eng.app.socpes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrototypeBean {

    Logger logger = LogManager.getLogger(PrototypeBean.class);

    public PrototypeBean() {
        logger.info("PrototypeBean instance created");
    }

}
