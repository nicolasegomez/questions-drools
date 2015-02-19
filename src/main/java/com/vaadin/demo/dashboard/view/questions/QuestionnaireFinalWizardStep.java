package com.vaadin.demo.dashboard.view.questions;

import org.vaadin.teemu.wizards.WizardStep;

import com.vaadin.ui.Component;

public class QuestionnaireFinalWizardStep implements WizardStep {
	
	public static String ID = "EndQuestion"; 

	@Override
	public String getCaption() {
		return "End";
	}

	@Override
	public Component getContent() {
		return new RegardsQuestionPanel();
	}

	@Override
	public boolean onAdvance() {
		return true;
	}

	@Override
	public boolean onBack() {
		return false;
	}

}
