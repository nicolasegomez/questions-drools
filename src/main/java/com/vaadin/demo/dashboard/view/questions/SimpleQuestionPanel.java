package com.vaadin.demo.dashboard.view.questions;

import com.google.gwt.user.client.ui.Hidden;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.demo.dashboard.domain.questions.Answer;
import com.vaadin.demo.dashboard.domain.questions.Question;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

public class SimpleQuestionPanel extends CustomComponent implements QuestionPanel {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private TextArea txtArea_answer;
	private long questionId;
	@AutoGenerated
	private Label lbl_question;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public SimpleQuestionPanel() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// lbl_question
		lbl_question = new Label();
		lbl_question.setImmediate(false);
		lbl_question.setWidth("100.0%");
		lbl_question.setHeight("-1px");
		lbl_question.setValue("Label");
		mainLayout.addComponent(lbl_question);
		
		// txtArea_answer
		txtArea_answer = new TextArea();
		txtArea_answer.setImmediate(false);
		txtArea_answer.setWidth("100.0%");
		txtArea_answer.setHeight("-1px");
		mainLayout.addComponent(txtArea_answer);
		mainLayout.setExpandRatio(txtArea_answer, 1.0f);
		
		return mainLayout;
	}

	@Override
	public void setQuestion(Question question) {
		lbl_question.setValue(question.getText());
		questionId = question.getId();
	}

	@Override
	public Answer getAnswer() {
		Answer answer = new Answer();
		answer.setText(txtArea_answer.getValue());
		answer.setQuestionId(questionId);
		return answer;
	}

}
