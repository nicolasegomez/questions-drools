package com.vaadin.demo.dashboard.domain.questions;

import java.util.ArrayList;

public class QuestionnaireServiceImpl implements QuestionnaireService {
	
	private	int questionNumber = 0;
	private ArrayList<Question> questionList;

	@Override
	public void initQuestionaire() {
		questionList = new ArrayList<Question>();
		Question q = new Question();
		q.setTitle("Age");
		q.setText("Please, insert your age:");
		questionList.add(q);
		q = new Question();
		q.setTitle("Entertainment");
		q.setText("What is your favourite TV serie?");
		questionList.add(q);
	}

	@Override
	public Question getQuestion() {
		if (questionList.size() > questionNumber)
			return questionList.get(questionNumber);
		return null;
	}

	@Override
	public void setAnswer(Answer answer) {
		questionNumber++;
	}

}
