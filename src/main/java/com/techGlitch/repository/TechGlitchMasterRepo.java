package com.techGlitch.repository;

import com.techGlitch.model.TechGlitchMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechGlitchMasterRepo extends JpaRepository<TechGlitchMaster, Long> {

    TechGlitchMaster findByReqRefNo(String reqRefNo);
}
