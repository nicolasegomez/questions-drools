package com.vaadin.demo.dashboard.view.questions;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.event.WizardCancelledEvent;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardProgressListener;
import org.vaadin.teemu.wizards.event.WizardStepActivationEvent;
import org.vaadin.teemu.wizards.event.WizardStepSetChangedEvent;

import com.vaadin.demo.dashboard.domain.questions.DroolsQuestionnaireServiceImpl;
import com.vaadin.demo.dashboard.domain.questions.Question;
import com.vaadin.demo.dashboard.domain.questions.QuestionnaireService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class QuestionnaireView extends VerticalLayout implements View {

	private Wizard questionsWizard;

	private QuestionPanelFactory questionPanelFactory;

	private QuestionnaireService questionnaireService;

	private Layout layout;

	public QuestionnaireView() {
		layout = this;
		setSizeFull();
		addStyleName("sales");

		addComponent(buildHeader());

		createWizard();

		questionnaireService = new DroolsQuestionnaireServiceImpl();
		questionPanelFactory = new QuestionPanelFactoryImpl();
	}

	private void createWizard() {
		if (questionsWizard != null) {
			removeComponent(questionsWizard);
		}
		questionsWizard = new Wizard();
		questionsWizard.getNextButton().setEnabled(true);
		questionsWizard.getFinishButton().setEnabled(true);
		questionsWizard.addListener(new WizardProgressListener() {

			@Override
			public void wizardCompleted(WizardCompletedEvent event) {
				endWizard("Questionnaire Ended");

			}

			@Override
			public void wizardCancelled(WizardCancelledEvent event) {
				endWizard("Questionnaire Ended");

			}

			@Override
			public void stepSetChanged(WizardStepSetChangedEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void activeStepChanged(WizardStepActivationEvent event) {
				questionnaireService.setAnswer(((QuestionnaireWizardStep)event.getActivatedStep()).getQuestionPanel().getAnswer());
				Question newQuestion = questionnaireService.getQuestion();
				if (newQuestion != null){
					//questionsWizard.removeStep(QuestionnaireFinalWizardStep.ID);
					questionsWizard.addStep(new QuestionnaireWizardStep(questionnaireService,
							questionPanelFactory,
							questionsWizard,
							newQuestion));
				}

			}

			private void endWizard(String message) {
				questionsWizard.setVisible(false);
				removeComponent(questionsWizard);
				questionsWizard = null;
				layout.getUI().showNotification(message);
			}
		});
		addComponent(questionsWizard);
		setExpandRatio(questionsWizard, 1);
	}

	private Component buildHeader() {
		HorizontalLayout header = new HorizontalLayout();
		header.addStyleName("viewheader");
		header.setSpacing(true);
		Responsive.makeResponsive(header);

		Label titleLabel = new Label("Questionnaire");
		titleLabel.setSizeUndefined();
		titleLabel.addStyleName(ValoTheme.LABEL_H1);
		titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		header.addComponents(titleLabel);

		return header;
	}

	@Override
	public void enter(final ViewChangeEvent event) {
		questionnaireService.initQuestionaire();

		final Question question = questionnaireService.getQuestion();

		if (question != null) {
			questionsWizard.addStep(new QuestionnaireWizardStep(
					questionnaireService, questionPanelFactory,
					questionsWizard, question));
			// questionsWizard.addStep(new QuestionnaireFinalWizardStep(),
			// QuestionnaireFinalWizardStep.ID);
		}
	}
}
