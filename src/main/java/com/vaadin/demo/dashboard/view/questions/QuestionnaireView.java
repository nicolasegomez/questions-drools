package com.vaadin.demo.dashboard.view.questions;

import org.vaadin.teemu.wizards.Wizard;

import com.vaadin.demo.dashboard.domain.questions.DroolsQuestionnaireServiceImpl;
import com.vaadin.demo.dashboard.domain.questions.Question;
import com.vaadin.demo.dashboard.domain.questions.QuestionnaireService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class QuestionnaireView extends VerticalLayout implements View {

	private Wizard questionsWizard;
	
	private QuestionPanelFactory questionPanelFactory;
	
	private QuestionnaireService questionnaireService;
	
    public QuestionnaireView() {
        setSizeFull();
        addStyleName("sales");

        addComponent(buildHeader());
        
        questionsWizard = new Wizard();
        questionsWizard.getNextButton().setEnabled(true);
        questionsWizard.getFinishButton().setEnabled(true);
        addComponent(questionsWizard);
        setExpandRatio(questionsWizard, 1);
        
        questionnaireService = new DroolsQuestionnaireServiceImpl();
        questionPanelFactory = new QuestionPanelFactoryImpl();
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
    		 questionsWizard.addStep(new QuestionnaireWizardStep(questionnaireService,
    				 questionPanelFactory,
    				 questionsWizard,
    				 question));
    		 //questionsWizard.addStep(new QuestionnaireFinalWizardStep(), QuestionnaireFinalWizardStep.ID);
    	 }
    }
}
