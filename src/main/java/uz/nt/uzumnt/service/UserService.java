package uz.nt.uzumnt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.nt.uzumnt.dto.ResponseDto;
import uz.nt.uzumnt.dto.UserDto;
import uz.nt.uzumnt.model.Users;
import uz.nt.uzumnt.repository.UserRepository;
import uz.nt.uzumnt.service.mapper.UserMapper;

import java.util.Optional;

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

    public ResponseDto<UserDto> updateUser(UserDto userDto) {
        if(userDto.getId() == null){
            return ResponseDto.<UserDto>builder()
                    .message("ID kiritilmagan")
                    .code(-2)
                    .data(userDto)
                    .build();
        }

        Optional<Users> userOptional = userRepository.findById(userDto.getId());

        if(userOptional.isEmpty()){
            return ResponseDto.<UserDto>builder()
                    .data(userDto)
                    .code(-1)
                    .message("ID "+ userDto.getId()+" not found")
                    .build();
        }

        Users user = userOptional.get();
        user.setId(userDto.getId());

        if(userDto.getGender() != null){
            user.setGender(userDto.getGender());
        }
        if(userDto.getFirstName() != null){
            user.setFirstName(userDto.getFirstName());
        }
        if(userDto.getBirthDate() != null){
            user.setBirthDate(userDto.getBirthDate());
        }
        if(userDto.getLastName() != null){
            user.setLastName(userDto.getLastName());
        }
        if(userDto.getMiddleName() != null){
            user.setMiddleName(userDto.getMiddleName());
        }
        if(userDto.getPhoneNumber() != null){
            user.setPhoneNumber(userDto.getPhoneNumber());
        }
        if(userDto.getEmail() != null){
            user.setEmail(userDto.getEmail());
        }



        userRepository.save(user);

        return ResponseDto.<UserDto>builder()
                .message("OK")
                .data(UserMapper.getUserDto(user))
                .success(true)
                .build();
    }


    public ResponseDto<UserDto> getByPhone(String phone) {
        return userRepository.findFirstByPhoneNumber(phone)
                .map(s ->
                    ResponseDto.<UserDto>builder()
                            .success(true)
                            .message("OK")
                            .data(UserMapper.getUserDto(s))
                            .build()
                ).orElse(
                        ResponseDto.<UserDto>builder()
                                .message("Not found")
                                .code(-1)
                                .build()
                );
    }
}
