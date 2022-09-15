package pavicevic.koArtwebshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pavicevic.koArtwebshop.dto.UserDTO;
import pavicevic.koArtwebshop.entity.User;
import pavicevic.koArtwebshop.repository.UserRepository;
import pavicevic.koArtwebshop.service.CartService;
import pavicevic.koArtwebshop.service.UserService;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartService cartService;

    @PostMapping(value = "api/users/add")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @GetMapping(value = "api/users/name/{name}")
    public ResponseEntity<UserDTO> findUserByName(@PathVariable String name) {
        UserDTO userDTO = userService.findUserByName(name);
        log.info(userDTO.toString());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value = "api/users/find/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") Integer id) {
        UserDTO userDTO = userService.findUserById(id);
        log.info(userDTO.toString());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value = "api/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }



    @PutMapping(value = "api/users/update/{id}")

    public  ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") Integer id ) {
        if (user.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User updateUser = userService.updateUser(user);

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping(value = "api/users/delete/{id}")
    public  ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        cartService.deleteCart(id);
        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
