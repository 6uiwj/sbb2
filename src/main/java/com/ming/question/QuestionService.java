package com.ming.question;

import com.ming.DataNotFoundException;
import com.ming.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    /**
     * 게시글 목록 출력
     * @param page
     * @return
     */
    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page,10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    /**
     * id값으로 질문데이터 조회
     * @param id
     * @return
     */
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }

    }

    /**
     * 질문 저장 서비스
     * @param subject
     * @param content
     */
    public void create(String subject, String content, SiteUser user) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }

    /**
     * 질문 수정
     * @param question
     * @param subject
     * @param content
     */
    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    public void delete (Question question){
        this.questionRepository.delete(question);
    }

    public void vote(Question question, SiteUser siteUser)
    {
        question.getVoter().add(siteUser);
        this.questionRepository.save(question);
    }
}
