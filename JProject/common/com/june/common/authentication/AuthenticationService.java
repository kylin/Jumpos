package com.june.common.authentication;

public interface AuthenticationService {
    boolean login(String username, String userGroup, String password) throws SecurityException;
}
