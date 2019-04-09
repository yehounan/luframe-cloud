package com.quanlehui.mallservice.controller;

import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.BaseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: yezi
 * @Date: 2019/4/9 13:17
 */
@RestController
public class HomeController {


    @GetMapping(value = "/hello")
    public BaseVO hello(){
        return VOUtils.returnBaseVOSuccess();
    }
}
