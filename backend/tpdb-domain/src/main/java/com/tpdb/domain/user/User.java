package com.tpdb.domain.user;


import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private User updatedBy;
    private User createdBy;

    private String name;
    private String username;
    private String email;
    private String password;

}
