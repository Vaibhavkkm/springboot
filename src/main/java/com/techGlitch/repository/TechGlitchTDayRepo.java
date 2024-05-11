package com.techGlitch.repository;

import com.techGlitch.model.TechGlitchTDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechGlitchTDayRepo extends JpaRepository<TechGlitchTDay, Long> {
}
