package mate.academy.service.mapper;

import mate.academy.dto.UserResponseDto;
import mate.academy.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto convertToUserDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        return userDto;
    }

    public User convertToUser(UserResponseDto userDto) {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setName(userDto.getName());
        return user;
    }
}
