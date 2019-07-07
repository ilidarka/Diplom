package com.leshko.diplom.repos;

import com.leshko.diplom.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepo extends JpaRepository<Job, Long> {

    List<Job> findByTag(String tag);

}
