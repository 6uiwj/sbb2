package com.ming;

import com.ming.question.Question;
import com.ming.question.QuestionRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
class Project01ApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Transactional
	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("sbb 제목");
		q1.setContent("sbb 내용");
		q1.setCreateDate(LocalDateTime.now());
		 this.questionRepository.save(q1);

	 	Question q2 = new Question();
		 q2.setSubject("sbb 제목2");
		 q2.setContent("sbb 내용2");
		 q2.setCreateDate(LocalDateTime.now());
		 this.questionRepository.save(q2);

	}





}
