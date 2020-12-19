package cn.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/12/18 15:55
 * @Version 1.0
 **/
@Data
public class User  implements Serializable{

    private String id;
    private String name;

}
