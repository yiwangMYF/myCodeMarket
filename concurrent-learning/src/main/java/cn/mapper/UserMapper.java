package cn.mapper;

import cn.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/12/18 15:53
 * @Version 1.0
 **/
@Mapper
@CacheConfig(cacheNames = "userCache")
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    @Cacheable
    User findById(String id);
}
