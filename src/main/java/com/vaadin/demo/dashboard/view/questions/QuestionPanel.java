package com.vaadin.demo.dashboard.view.questions;

import com.vaadin.demo.dashboard.domain.questions.Answer;
import com.vaadin.demo.dashboard.domain.questions.Question;
import com.vaadin.ui.Component;

public interface QuestionPanel extends Component {
	
	void setQuestion(Question question);
	
	Answer getAnswer();

}
