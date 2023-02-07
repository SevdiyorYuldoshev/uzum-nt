package uz.nt.uzumnt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.nt.uzumnt.dto.ResponseDto;
import uz.nt.uzumnt.dto.UserDto;
import uz.nt.uzumnt.model.Users;
import uz.nt.uzumnt.repository.UserRepository;
import uz.nt.uzumnt.service.mapper.UserMapper;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseDto<UserDto> add(UserDto userDto) {
        Users users = UserMapper.getEntity(userDto);

        userRepository.save(users);

        return ResponseDto.<UserDto>builder()
                .code(0)
                .data(UserMapper.getUserDto(users))
                .message("OK")
                .success(true)
                .build();
    }
}
