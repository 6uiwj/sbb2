package com.ming.question;

import com.ming.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    /**
     * 질문 목록 출력
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {
        //Question 객체들을 담는 List 생성 (findAll: Question엔티티의 행을 전부 가져옴)
        //List<Question> questionList = this.questionRepository.findAll(); //질문 목록 전부 가져옴

        //서비스 이용하여 조회
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    /**
     * id에 해당하는 질문 상세페이지 출력
     * @param model
     * @param id
     * @return
     */
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    /**
     * 질문 등록
     * @return
     */
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    /**
     * 질문등록 - 저장 처리
     * @param questionForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult ){
        if(bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
