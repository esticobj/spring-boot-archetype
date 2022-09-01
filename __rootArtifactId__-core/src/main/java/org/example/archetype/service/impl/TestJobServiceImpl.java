package org.example.archetype.service.impl;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.example.archetype.service.TestJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestJobServiceImpl implements TestJobService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @XxlJob("testJob")
    @Override
    public void testJob() {
        logger.info("testJob begin");
    }
}
