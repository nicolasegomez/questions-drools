package com.vaadin.demo.dashboard.view.questions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.vaadin.maddon.ListContainer;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.timeline.Timeline;
import com.vaadin.data.Container;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.demo.dashboard.DashboardUI;
import com.vaadin.demo.dashboard.domain.Movie;
import com.vaadin.demo.dashboard.domain.MovieRevenue;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class QuestionaryView extends VerticalLayout implements View {

	private Wizard questionsWizard;
	
    public QuestionaryView() {
        setSizeFull();
        addStyleName("sales");

        addComponent(buildHeader());
        
        questionsWizard = new Wizard();
        addComponent(questionsWizard);
        setExpandRatio(questionsWizard, 1);
    }

    private Component buildHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("viewheader");
        header.setSpacing(true);
        Responsive.makeResponsive(header);

        Label titleLabel = new Label("Questionary");
        titleLabel.setSizeUndefined();
        titleLabel.addStyleName(ValoTheme.LABEL_H1);
        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        header.addComponents(titleLabel);

        return header;
    }

     @Override
    public void enter(final ViewChangeEvent event) {
    	 questionsWizard.addStep(new WizardStep() {
			
			@Override
			public boolean onBack() {
				return true;
			}
			
			@Override
			public boolean onAdvance() {
				return true;
			}
			
			@Override
			public Component getContent() {
				return new Label("Testing");
			}
			
			@Override
			public String getCaption() {
				
				return "First Question";
			}
		});
    	 questionsWizard.addStep(new WizardStep() {
 			
 			@Override
 			public boolean onBack() {
 				return true;
 			}
 			
 			@Override
 			public boolean onAdvance() {
 				return true;
 			}
 			
 			@Override
 			public Component getContent() {
 				return new Label("Testing");
 			}
 			
 			@Override
 			public String getCaption() {
 				
 				return "Second Question";
 			}
 		});
    }
}
