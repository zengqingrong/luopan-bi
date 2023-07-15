package org.luopanbi.test;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("`user`")
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
