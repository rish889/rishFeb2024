package com.rish889.rishFeb2024.service;

import com.rish889.rishFeb2024.model.User;

import java.util.List;

public interface UserService {
    User saveUser(final User user);

    List<User> fetchUsers();

    User fetchUser(final Integer userId);
}
