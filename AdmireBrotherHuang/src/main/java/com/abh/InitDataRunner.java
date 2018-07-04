package com.abh;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDataRunner implements CommandLineRunner {

    private static Logger logger = LogManager.getLogger(InitDataRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.warn(">>>>>>>>>>>> start initialize data");

        logger.debug("blablabla..");

        logger.warn(">>>>>>>>>>>> initialize data finish");
    }

}
