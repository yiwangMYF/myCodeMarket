package cn.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    /**
     * id
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
}