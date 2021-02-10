package mate.academy.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.dto.UserResponseDto;
import mate.academy.model.User;
import mate.academy.service.UserService;
import mate.academy.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        int age = 25;
        String name = "Mik";
        for (int i = 0; i < 4; i++) {
            User user = new User();
            user.setName(name);
            user.setAge(age++);
            userService.add(user);
            name = name + "ek";
        }
        return "Successful inject";
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        User userById = userService.getById(id);
        return userMapper.convertToUserDto(userById);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> userDto = new ArrayList<>();
        return userService.listUsers()
                .stream()
                .map(user -> userMapper.convertToUserDto(user))
                .collect(Collectors.toList());
    }
}
