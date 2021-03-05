package cn.com.busi.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import cn.com.busi.domain.TMarquee;

public interface TMarqueeMapper {
    int deleteByPrimaryKey(String id);

    int insert(TMarquee record);

    int insertSelective(TMarquee record);

    TMarquee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TMarquee record);

    int updateByPrimaryKey(TMarquee record);

    List<TMarquee> findByAll(TMarquee tMarquee);


}