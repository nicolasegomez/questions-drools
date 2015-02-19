package com.vaadin.demo.dashboard.domain.questions;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import com.vaadin.demo.dashboard.util.DroolsUtils;

public class DroolsQuestionnaireServiceImpl implements QuestionnaireService {

	private KieSession ksession;

	@Override
	public void initQuestionaire() {
		ksession = new DroolsUtils().new KieSessionBuilder().withResources(
				"com/vaadin/demo/dashboard/rules/questionary.drl").build();
	}

	@Override
	public Question getQuestion() {
		ksession.fireAllRules();
		QueryResults results = ksession.getQueryResults( "questionary" );
		QueryResultsRow row = results.iterator().next();
		Questionary questionary = (Questionary) row.get("questionary");
		return questionary.getCurrentQuestion();
	}

	@Override
	public void setAnswer(Answer answer) {
		ksession.fireAllRules();
		ksession.insert(answer);
	}

}
