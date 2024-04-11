package kz.realcash.wildcard.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCRMDTO {
    private String id;
    private String token;
    private String login;
    private String id_shops;
    private String blocked;

}
