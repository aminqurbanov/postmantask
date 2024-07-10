package com.example.methods;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
;

import java.util.*;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UserService {

        private final Map<String, User> users = new HashMap<>();

        public void createUser(User user) {
            User createdUser = User.builder().
                    id(UUID.randomUUID().toString())
                    .age(user.getAge())
                    .name(user.getName()).build();
            users.put(createdUser.getId(), createdUser);
        }
        public void updateUser( String id, User user){
            User user1 = users.get(id);
            user1.setAge(user.getAge());

        }
        public List<User> getUserByAge( int fromAge,  int toAge){
            Collection<User> values = users.values();
            List<User> collect = values.stream().filter(user -> user.getAge() == fromAge && user.getAge() == toAge).collect(Collectors.toList());
            return collect;

        }
        public List<User>mockUsers(){
            User amin = User.builder().id("6471630d-c3fe-43ce-a950-91ef64f588da").name("Amin").age(18).build();
            User anar = User.builder().id("4f0ee4bb-2db0-4ae6-9292-460fb7036b44").name("Anar").age(27).build();
            User farid = User.builder().id("4f0ee4bb-2db0-4ae6-9292-460fb7036b44").name("Farid").age(22).build();
            List<User>userList=Arrays.asList(amin,anar,farid);
            return userList;
        }



    }


