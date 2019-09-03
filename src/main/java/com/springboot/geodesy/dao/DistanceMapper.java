package com.springboot.geodesy.dao;

import com.springboot.geodesy.entity.Distance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceMapper {
    public long saveDistanceList(Distance distance);

    public long delDistanceInfo(String dataDt);
}
