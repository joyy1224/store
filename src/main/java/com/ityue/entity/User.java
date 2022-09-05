package com.ityue.entity;

import lombok.*;

import java.io.Serializable;
import java.lang.annotation.Target;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BeseEntity implements Serializable {

//    @AutoId
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;
}
