package com.vaadin.demo.dashboard.domain.questions;

import java.util.ArrayList;
import java.util.List;

public class Questionary {

	private String userName;

	private List<Question> answeredQuestions = new ArrayList<Question>();

	private Question currentQuestion;
	
	private boolean finished = false;
	
	public void answerCurretQuestion(Answer a) {
		this.currentQuestion.setAnswer(a);
		this.answeredQuestions.add(currentQuestion);
		currentQuestion = null;
	}
	public void setAnsweredQuestions(List<Question> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	public List<Question> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public boolean isFinished() {
		return finished;
	}
}
