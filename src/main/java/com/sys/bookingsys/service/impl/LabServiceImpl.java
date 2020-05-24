package com.sys.bookingsys.service.impl;

import com.sys.bookingsys.domain.Lab;
import com.sys.bookingsys.mapper.LabMapper;
import com.sys.bookingsys.service.LabService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class LabServiceImpl implements LabService {

    @Autowired
    private LabMapper labMapper;

    @Override
    public List<Lab> getLabList() {
        return labMapper.getLabList();
    }

    @Override
    public boolean deleteLabByLabId(int labId) {
        try{
            labMapper.deleteLabByLabId(labId);
        }catch (Exception e){
            return false;
        }
        return true;

    }

    @Override
    public boolean editLabByLabId(Lab lab) {
        try{
            labMapper.editLabByLabId(lab);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean addLabByHand(Lab lab) {

        try{
            labMapper.addLabByHand(lab);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
