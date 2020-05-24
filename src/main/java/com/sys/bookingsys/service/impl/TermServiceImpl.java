package com.sys.bookingsys.service.impl;

import com.sys.bookingsys.domain.Term;
import com.sys.bookingsys.mapper.TermMapper;
import com.sys.bookingsys.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 */
@Service
public class TermServiceImpl implements TermService {

    @Autowired
    private TermMapper termMapper;


    @Override
    public boolean termSet(Term term) {
        try{
            termMapper.termSet(term);
        }catch (Exception e){
            return false;
        }
        return true;

    }
//
    @Override
    public boolean updatePreTerm(){
        try{
            termMapper.updatePreTerm();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Term getTerm(){
        return termMapper.getTerm();
    }
}
