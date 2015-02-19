package com.vaadin.demo.dashboard.domain.questions;

public interface QuestionnaireService {
	
	void initQuestionaire();
	
	Question getQuestion();
	
	void setAnswer(Answer answer);

}
