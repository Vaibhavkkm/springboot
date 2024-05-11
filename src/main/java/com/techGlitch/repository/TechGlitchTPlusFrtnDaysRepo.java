package com.techGlitch.repository;

import com.techGlitch.model.TechGlitchTPlusFrtnDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechGlitchTPlusFrtnDaysRepo extends JpaRepository<TechGlitchTPlusFrtnDays, Long> {
}
