package com.vaadin.demo.dashboard.view;

import com.vaadin.demo.dashboard.view.dashboard.DashboardView;
import com.vaadin.demo.dashboard.view.questions.QuestionnaireView;
import com.vaadin.demo.dashboard.view.reports.ReportsView;
import com.vaadin.demo.dashboard.view.sales.SalesView;
import com.vaadin.demo.dashboard.view.schedule.ScheduleView;
import com.vaadin.demo.dashboard.view.transactions.TransactionsView;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

public enum DashboardViewType {
    DASHBOARD("dashboard", DashboardView.class, FontAwesome.HOME, true, true),
    SALES("sales", SalesView.class, FontAwesome.BAR_CHART_O, false, false),
    TRANSACTIONS("transactions", TransactionsView.class, FontAwesome.TABLE, false, false),
    REPORTS("reports", ReportsView.class, FontAwesome.FILE_TEXT_O, true, false),
    SCHEDULE("schedule", ScheduleView.class, FontAwesome.CALENDAR_O, false, false),
    QUESTIONNAIRE("questionnaire", QuestionnaireView.class, FontAwesome.QUESTION, false, true)
    ;

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;
    private final boolean visible;

    private DashboardViewType(final String viewName,
            final Class<? extends View> viewClass, final Resource icon,
            final boolean stateful, final boolean visible) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
        this.visible = visible;
    }
    
    public boolean isVisible() {
		return visible;
	}
    
    public boolean isStateful() {
        return stateful;
    }

    public String getViewName() {
        return viewName;
    }

    public Class<? extends View> getViewClass() {
        return viewClass;
    }

    public Resource getIcon() {
        return icon;
    }

    public static DashboardViewType getByViewName(final String viewName) {
        DashboardViewType result = null;
        for (DashboardViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }

}
