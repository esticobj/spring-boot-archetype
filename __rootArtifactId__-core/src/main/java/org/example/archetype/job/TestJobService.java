package org.example.archetype.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestJobService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @XxlJob("testJob")
    public void testJob() {
        logger.info("testJob begin");
    }
}
