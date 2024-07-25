package com.ming.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @GetMapping("/list")
    public String list() {
        return "question_list";
    }
}
