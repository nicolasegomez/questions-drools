package com.vaadin.demo.dashboard.domain.questions;

public class Answer {
	
	Long questionId;
	
	String text;

	public void setText(String text) {
		this.text = text;
	}
	
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	
	public String getText() {
		return text;
	}
	public Long getQuestionId() {
		return questionId;
	}
	

}
