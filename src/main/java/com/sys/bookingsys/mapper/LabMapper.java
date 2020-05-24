package com.sys.bookingsys.mapper;

import com.sys.bookingsys.domain.Lab;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface LabMapper {
    List<Lab> getLabList();
    void deleteLabByLabId(int labId);
    void editLabByLabId(Lab lab);
    void addLabByHand(Lab lab);
}
