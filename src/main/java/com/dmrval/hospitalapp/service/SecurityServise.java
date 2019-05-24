package com.dmrval.hospitalapp.service;

public interface SecurityServise {
    String findLoggerInUsername();
    void autoLogin(String login, String password);
}
