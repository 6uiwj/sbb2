package com.ming.answer;

import com.ming.DataNotFoundException;
import com.ming.question.Question;
import com.ming.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    /**
     * 답변 저장
     * @param question
     * @param content
     */
    public void create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
    }

    /**
     * 답변 조회
     * @param id
     * @return
     */
    public Answer getAnswer(Integer id) {
        Optional<Answer> answer = this.answerRepository.findById(id);
        if(answer.isPresent()) {
            return answer.get();
        } else {
            throw new DataNotFoundException("answer not found");

        }
    }

    /**
     * 답변 수정
     * @param answer
     * @param content
     */
    public void modify(Answer answer, String content) {
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }

    /**
     * 삭제
     * @param answer
     */
    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }
}
