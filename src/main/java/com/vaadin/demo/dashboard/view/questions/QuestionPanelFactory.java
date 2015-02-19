package com.vaadin.demo.dashboard.view.questions;

import com.vaadin.demo.dashboard.domain.questions.Question;

public interface QuestionPanelFactory {
	
	QuestionPanel getQuestionPanel(Question question);

}
