package br.com.w2lima.appblank.controller;

import br.com.w2lima.appblank.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

	
    @GetMapping
    public ResponseEntity<UserModel> getUser() {
        UserModel user = new UserModel();
        user.setName("William");
        user.setId(UUID.randomUUID());
        user.setBorn(LocalDate.of(1977,6,28));
        return ResponseEntity.ok(user);
    }

}
