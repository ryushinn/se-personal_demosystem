package cn.edu.buaa.se.demosystem.service;

import cn.edu.buaa.se.demosystem.bean.Apparatus;
import cn.edu.buaa.se.demosystem.mapper.ApparatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ApparatusService {

    @Autowired
    private ApparatusMapper apparatusMapper;

    public List<Apparatus> findAllApparatuses() {
        return apparatusMapper.selectAll();
    }

    public void insert(Apparatus apparatus) {
        Calendar calendar = Calendar.getInstance();
        apparatus.setBuyTime(calendar.getTime());
        apparatusMapper.insert(apparatus);
    }

    public void deleteByPrimaryKey(int id) {
        apparatusMapper.deleteByPrimaryKey(id);
    }
    public Apparatus findApparatusByPrimaryKey(int id) {
        return apparatusMapper.selectByPrimaryKey(id);
    }
    public void updateApparatusByExample(Apparatus apparatus) {
        apparatusMapper.updateByPrimaryKey(apparatus);
    }

}
