package cn.mapper;

import cn.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查找用户信息
     *
     * @param name
     * @return
     */
    User getUserByName(@Param("name") String name);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();
}