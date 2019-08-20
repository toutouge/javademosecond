package com.demo.dao;

import com.demo.pojo.UserPosition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
@Repository
public interface UserPositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPosition record);

    int insertSelective(UserPosition record);

    UserPosition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPosition record);

    int updateByPrimaryKey(UserPosition record);
    List<UserPosition> getvicinity(@Param("minlng") BigDecimal minlng,
                                   @Param("maxlng") BigDecimal maxlng,
                                   @Param("minlat") BigDecimal minlat,
                                   @Param("maxlat") BigDecimal maxlat);

    List<UserPosition> getvicinitysort(@Param("longitude") BigDecimal longitude,
                                       @Param("latitude") BigDecimal latitude);
}