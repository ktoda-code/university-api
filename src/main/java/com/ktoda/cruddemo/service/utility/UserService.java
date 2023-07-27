package com.ktoda.cruddemo.service.utility;

public interface UserService {
    String generateUsername(String firstName);

    String generateEmail(String firstName, String lastName);
}
