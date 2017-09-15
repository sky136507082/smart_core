package com.sky.test;

import com.sky.smart.core.annotation.Controller;
import com.sky.smart.core.annotation.Inject;

/**
 * Created by sky on 2017/9/15.
 */
@Controller
public class TestController {
    @Inject
    private TestModel testModel;

    public void doPrintln(){
        System.out.println(testModel);
    }

    @Override
    public String toString() {
        return "TestController{" +
                "testModel=" + testModel +
                '}';
    }
}
