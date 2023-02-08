package uz.nt.uzumnt.service.mapper;

import uz.nt.uzumnt.dto.UserDto;
import uz.nt.uzumnt.model.Users;

public class UserMapper {

    public static UserDto getUserDto(Users entity){
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setEmail(entity.getEmail());
        userDto.setGender(entity.getGender());
        userDto.setLastName(entity.getLastName());
        userDto.setFirstName(entity.getFirstName());
        userDto.setBirthDate(entity.getBirthDate());
        userDto.setMiddleName(entity.getMiddleName());
        userDto.setPhoneNumber(entity.getPhoneNumber());
        userDto.setIsActive(entity.getIsActive());

        return userDto;
    }

    public static Users getEntity(UserDto userDto){
        Users entity = new Users();
        entity.setBirthDate(userDto.getBirthDate());
        entity.setEmail(userDto.getEmail());
        entity.setId(userDto.getId());
        entity.setLastName(userDto.getLastName());
        entity.setGender(userDto.getGender());
        entity.setFirstName(userDto.getFirstName());
        entity.setMiddleName(userDto.getMiddleName());
        entity.setPhoneNumber(userDto.getPhoneNumber());
        entity.setIsActive(userDto.getIsActive());

        return entity;
    }
}
