package cn.edu.buaa.se.demosystem.mapper;

import cn.edu.buaa.se.demosystem.bean.Apparatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ApparatusMapper {
    public Apparatus selectByPrimaryKey(Integer id);

    public List<Apparatus> selectAll();

    public void insert(Apparatus apparatus);

    public void deleteByPrimaryKey(Integer id);

    public void updateByPrimaryKey(Apparatus modified);
}
