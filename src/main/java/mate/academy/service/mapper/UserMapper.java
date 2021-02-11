package mate.academy.service.mapper;

import mate.academy.dto.UserResponseDto;
import mate.academy.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto convertToUserDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        return userDto;
    }
}
