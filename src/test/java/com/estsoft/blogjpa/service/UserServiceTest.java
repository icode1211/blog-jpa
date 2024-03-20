package com.estsoft.blogjpa.service;

import com.estsoft.blogjpa.domain.User;
import com.estsoft.blogjpa.dto.AddUserRequest;
import com.estsoft.blogjpa.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest() {
        // given:
        AddUserRequest request = new AddUserRequest("mock_email", "mock_pw");

        // when:
        User user = userService.save(request);

        // then:
        assertThat(user.getEmail()).isEqualTo("mock_email");
        assertThat(user.getUsername()).isEqualTo("mock_email");
    }

    @Test
    public void existsTest() {

        boolean exists = userRepository.existsById(1L);

        System.out.println(exists);
//        org.junit.jupiter.api.Assertions.assertTrue(exists);
    }
}