package com.sjxie.util;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("通过实现ApplicationRunner接口，在spring boot项目启动后打印参数");
        /*StepExecutor test = new StepExecutor();
		Thread myThread = new Thread(test);
		myThread.start();
        System.out.println();*/
    }
}