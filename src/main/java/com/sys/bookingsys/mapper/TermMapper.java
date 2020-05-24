package com.sys.bookingsys.mapper;

import com.sys.bookingsys.domain.Term;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 */
@Mapper
public interface TermMapper {

    void termSet(Term term);
    void updatePreTerm();
    Term getTerm();

}
