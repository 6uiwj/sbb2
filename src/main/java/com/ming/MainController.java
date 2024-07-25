package com.ming;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @ResponseBody
    @GetMapping("/sbb")
    public String index() {
        return "sbb에 오신 것을 환영합니다.";
    }
}

