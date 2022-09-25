package br.com.w2lima.appblank.controller;

import br.com.w2lima.appblank.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<User> getUser() {
        User user = new User();
        user.setName("William");
        user.setId(UUID.randomUUID());
        user.setBorn(LocalDate.of(1977,6,28));
        return ResponseEntity.ok(user);
    }

}
