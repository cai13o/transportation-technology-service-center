package cn.com.busi.service;

import cn.com.busi.domain.TMarquee;

import java.util.List;

public interface TMarqueeService{


    int deleteByPrimaryKey(String id);

    int insert(TMarquee record);

    int insertSelective(TMarquee record);

    TMarquee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TMarquee record);

    int updateByPrimaryKey(TMarquee record);

    List<TMarquee> findByAll(TMarquee tMarquee);
}
