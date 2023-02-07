package uz.nt.uzumnt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ResponseDto<T>{

    private Integer code;
    private String message;
    private T data;

    private boolean success;

}
