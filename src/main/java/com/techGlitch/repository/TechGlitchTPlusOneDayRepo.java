package com.techGlitch.repository;

import com.techGlitch.model.TechGlitchTPlusOneDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechGlitchTPlusOneDayRepo extends JpaRepository<TechGlitchTPlusOneDay, Long> {
}
