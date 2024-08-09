package com.ming;

import com.ming.question.Question;
import com.ming.question.QuestionRepository;
import com.ming.question.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
class Project01ApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Test
	void testJpa() {

		for(int i=1; i<=300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용 없음";
			this.questionService.create(subject,content);
			System.out.println("저장 됐니?");
		}
	}





}
