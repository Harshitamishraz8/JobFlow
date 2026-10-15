
package com.jobflow.repository;

import com.jobflow.entity.JobApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

    Page<JobApplication> findByStatusIgnoreCase(
            String status, Pageable pageable);
}