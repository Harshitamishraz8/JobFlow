
package com.jobflow.service;
import com.jobflow.entity.JobApplication;
import com.jobflow.exception.ResourceNotFoundException;
import com.jobflow.repository.JobApplicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public JobApplication create(JobApplication application) {
        return repository.save(application);
    }

    public Page<JobApplication> getAll(String status, Pageable pageable) {
        if (status != null && !status.isBlank()) {
            return repository.findByStatusIgnoreCase(status, pageable);
        }
        return repository.findAll(pageable);
    }

    public JobApplication update(Long id, JobApplication updated) {
        JobApplication existing = repository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Application not found: " + id));

        existing.setCompany(updated.getCompany());
        existing.setRole(updated.getRole());
        existing.setStatus(updated.getStatus());

        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(
                "Application not found: " + id);
        }
        repository.deleteById(id);
    }
    
public JobApplication getById(Long id) {
    return repository.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException(
                    "Application not found: " + id));
}
}