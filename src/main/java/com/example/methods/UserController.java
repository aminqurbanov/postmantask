package com.example.methods;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {


        private final UserService userService;
        @PostMapping("/create-user")
        @ResponseStatus(HttpStatus.CREATED)
        public void createUser(@RequestBody User user){
            userService.createUser(user);
        }

        @PutMapping("/{id}")
        public void updateUser(@PathVariable String id,User user){
            userService.updateUser(id, user);

        }
        @GetMapping
        public List<User> getUserByAge(@RequestParam int fromAge, @RequestParam int toAge){
            return userService.getUserByAge(fromAge, toAge);
        }

    }


