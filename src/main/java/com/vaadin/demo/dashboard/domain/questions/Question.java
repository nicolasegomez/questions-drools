package com.vaadin.demo.dashboard.domain.questions;

public class Question {
	
	private Long id;
	private String text;
	private String title;
	private Answer answer;

	public Question() {
		id = System.currentTimeMillis();
	}
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public Answer getAnswer() {
		return answer;
	}
	
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (id!= null && obj!= null && ((Question)obj).getId() != null )
		return id.equals(((Question)obj).getId());
		
		return false;
	}
}
