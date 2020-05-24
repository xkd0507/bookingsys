package com.sys.bookingsys.service;

import com.sys.bookingsys.domain.Term;


/**
 *
 */
public interface TermService {
    boolean termSet(Term term);
    boolean updatePreTerm();
    Term getTerm();
}
