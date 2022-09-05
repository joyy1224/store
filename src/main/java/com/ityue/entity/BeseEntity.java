package com.ityue.entity;


import lombok.*;

import java.io.Serializable;
import java.util.Date;

/*作为实体类的基类*/
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BeseEntity implements Serializable {

    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

}
