package com.sky.test;

import com.sky.smart.core.annotation.Action;
import com.sky.smart.core.annotation.Controller;
import com.sky.smart.core.bean.Param;
import com.sky.smart.core.bean.View;
import com.sky.smart.core.helper.AopHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liansongyang on 2018/3/2.
 */
@Controller
public class TestAction {
    private static final Logger logger = LoggerFactory.getLogger(TestAction.class);

    @Action("get:/test")
    public View test(Param param) throws Exception {
        System.out.println("~~~~~~~~~~~~~~");
        return new View("test.jsp");
    }

}
