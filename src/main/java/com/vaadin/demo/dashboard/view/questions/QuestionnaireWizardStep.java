package com.vaadin.demo.dashboard.view.questions;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import com.vaadin.demo.dashboard.domain.questions.Question;
import com.vaadin.demo.dashboard.domain.questions.QuestionnaireService;
import com.vaadin.ui.Component;

public class QuestionnaireWizardStep implements WizardStep {
	
	private QuestionnaireService questionnaireService;
	private QuestionPanelFactory questionPanelFactory;
	private Question question;
	private Wizard questionsWizard;
	private QuestionPanel questionPanel;

	public QuestionnaireWizardStep(QuestionnaireService questionnaireService,
			QuestionPanelFactory questionPanelFactory,
			Wizard questionsWizard,
			Question question) {
		this.questionnaireService = questionnaireService;
		this.questionPanelFactory = questionPanelFactory;
		this.question = question;
		this.questionsWizard = questionsWizard;
	}
	
	@Override
	public boolean onBack() {
		return false;
	}
	
	@Override
	public boolean onAdvance() {	
		questionnaireService.setAnswer(questionPanel.getAnswer());
		Question newQuestion = questionnaireService.getQuestion();
		if (newQuestion != null)
			//questionsWizard.removeStep(QuestionnaireFinalWizardStep.ID);
			questionsWizard.addStep(new QuestionnaireWizardStep(questionnaireService,
					questionPanelFactory,
					questionsWizard,
					newQuestion));
			//questionsWizard.addStep(new QuestionnaireFinalWizardStep(), QuestionnaireFinalWizardStep.ID);
		return true;
	}
	
	@Override
	public Component getContent() {
		questionPanel = questionPanelFactory.getQuestionPanel(question);
		return questionPanel;
	}
	
	@Override
	public String getCaption() {
		return question.getTitle();
	}

}
