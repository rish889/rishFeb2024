package com.rish889.rishFeb2024.config;

public class ApiPaths {
    public static final String API_V1 = "/api/v1/rish889";
    public static final String HEALTH_CHECK = API_V1 + "/health";
    public static final String USERS = API_V1 + "/users";
    public static final String USER_BY_ID = USERS + "/{userId}";
}
