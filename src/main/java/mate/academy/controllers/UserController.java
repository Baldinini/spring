package mate.academy.controllers;

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
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public String inject() {
        User mike = new User();
        mike.setName("Mike");
        User olia = new User();
        olia.setName("Olia");
        User karl = new User();
        karl.setName("Karl");
        User kate = new User();
        kate.setName("Kate");
        userService.add(mike);
        userService.add(olia);
        userService.add(karl);
        userService.add(kate);
        return "Successful inject";
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return userMapper.convertToUserDto(userService.getById(id));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(userMapper::convertToUserDto)
                .collect(Collectors.toList());
    }
}
