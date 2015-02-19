package com.vaadin.demo.dashboard.view.questions;

import com.vaadin.demo.dashboard.domain.questions.Question;

public class QuestionPanelFactoryImpl implements QuestionPanelFactory {

	@Override
	public QuestionPanel getQuestionPanel(Question question) {
		QuestionPanel questionPanel;
		questionPanel = new SimpleQuestionPanel();
		questionPanel.setQuestion(question);
		return questionPanel;
	}

}
