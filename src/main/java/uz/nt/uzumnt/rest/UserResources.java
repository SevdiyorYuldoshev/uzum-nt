package uz.nt.uzumnt.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt.uzumnt.dto.ResponseDto;
import uz.nt.uzumnt.dto.UserDto;
import uz.nt.uzumnt.model.Users;
import uz.nt.uzumnt.repository.UserRepository;
import uz.nt.uzumnt.service.UserService;
import uz.nt.uzumnt.service.mapper.UserMapper;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResources {


    private final UserService userService;

    @PostMapping
    public ResponseDto<UserDto> addUser(@RequestBody UserDto userDto){
        return userService.add(userDto);
    }
}
