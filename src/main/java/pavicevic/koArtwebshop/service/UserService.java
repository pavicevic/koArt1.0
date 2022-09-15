package pavicevic.koArtwebshop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pavicevic.koArtwebshop.dto.UserDTO;
import pavicevic.koArtwebshop.entity.User;
import pavicevic.koArtwebshop.exception.UserNotFoundException;
import pavicevic.koArtwebshop.mapper.UserMapper;
import pavicevic.koArtwebshop.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;


    public void addUser(UserDTO userDTO){
        User user= userMapper.convertToEntity(userDTO);
        userDTO.setRegisteredAt(LocalDateTime.now());
        userRepository.save(user);
    }

    public UserDTO findUserByName(String name) {
        User user= userRepository.findByName(name);
        log.info(user.toString());
        return userMapper.convertToDTO(user);

    }


    public UserDTO findUserById(Integer id){
        User user= userRepository.findUserById(id).orElseThrow(()->new UserNotFoundException("User by id"+ id + "was not found"));
        return userMapper.convertToDTO(user);

    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
