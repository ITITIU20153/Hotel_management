package com.example.clean_architecture.domain.model.user;

import lombok.Getter;

@Getter 
public class User {
    private final UserId id;
    private Username username;
    private Password password;
    private UserRole role;
    
    private User(UserId id, Username username, Password password, UserRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static User createAdminUser(Username username,Password password) {
        return new User(UserId.generate(), username, password, UserRole.ADMIN);
    }

    public static User createCustomerUser(Username username,Password password) {
        return new User(UserId.generate(), username, password, UserRole.CUSTOMER);
    }

    public static User createStaffUser(Username username,Password password) {
        return new User(UserId.generate(), username, password, UserRole.STAFF);
    }

    public static User reconstitute(UserId id,Username username,Password password,UserRole role) {
        return new User(id, username, password, role);
    }
}
