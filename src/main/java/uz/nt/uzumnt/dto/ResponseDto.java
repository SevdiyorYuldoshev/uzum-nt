package uz.nt.uzumnt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ResponseDto<T>{

    /**
     * Code message type:
     *
     * <p> -2 -> validation error </p>
     * <p> -1 -> Not found </p>
     * <p> 0 -> OK </p>
     * <p> 1 -> Database error </p>
     * <p> 2 -> Other error </p>
     */
    private Integer code;
    private String message;
    private T data;

    private boolean success;

}
