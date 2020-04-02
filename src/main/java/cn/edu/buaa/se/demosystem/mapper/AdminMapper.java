package cn.edu.buaa.se.demosystem.mapper;

import cn.edu.buaa.se.demosystem.bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {

    public Admin selectByUsername(String username);
}
