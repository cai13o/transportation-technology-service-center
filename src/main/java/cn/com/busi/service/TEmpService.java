package cn.com.busi.service;

import cn.com.busi.domain.TContactInfo;
import cn.com.busi.domain.TEmp;
import cn.com.busi.domain.TPersonnelStatus;
import cn.com.busi.domain.TWorkInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TEmpService {


    int deleteByPrimaryKey(String id);

    int insert(TEmp record);

    TEmp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TEmp record);

    int updateByPrimaryKey(TEmp record);

    int insertSelective(TEmp record);

    List<TEmp> findByAll(TEmp tEmp);

    TEmp selectByUsernameAndPassword(String username, String md5Password);
}




