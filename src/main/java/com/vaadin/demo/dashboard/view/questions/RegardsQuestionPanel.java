package com.vaadin.demo.dashboard.view.questions;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.demo.dashboard.domain.questions.Answer;
import com.vaadin.demo.dashboard.domain.questions.Question;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class RegardsQuestionPanel extends CustomComponent implements QuestionPanel{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private Label label_1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public RegardsQuestionPanel() {
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
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("100.0%");
		label_1.setHeight("-1px");
		label_1.setValue("Thanks for taking the time to fill out this questionnaire.");
		mainLayout.addComponent(label_1);
		
		return mainLayout;
	}

	@Override
	public void setQuestion(Question question) {	
	}

	@Override
	public Answer getAnswer() {
		return null;
	}

}