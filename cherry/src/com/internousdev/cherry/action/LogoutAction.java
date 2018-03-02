package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }


    @Override
    public String execute() throws Exception {
        Map<String, Object> session = getSession();
        session.remove("userId");
        session.put("loginFlg", false);
        return SUCCESS;
    }


}