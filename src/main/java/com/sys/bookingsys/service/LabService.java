package com.sys.bookingsys.service;

import com.sys.bookingsys.domain.Lab;

import java.util.List;

/**
 *
 */
public interface LabService {
    List<Lab> getLabList();
    boolean deleteLabByLabId(int labId);
    boolean editLabByLabId(Lab lab);
    boolean addLabByHand(Lab lab);
}
