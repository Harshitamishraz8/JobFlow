
package com.jobflow.controller;

import com.jobflow.entity.JobApplication;
import com.jobflow.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JobApplication> create(
            @Valid @RequestBody JobApplication application) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(application));
    }

    @GetMapping
    public Page<JobApplication> getAll(
            @RequestParam(required = false) String status,
            @PageableDefault(size = 10, sort = "appliedAt",
                    direction = Sort.Direction.DESC)
            Pageable pageable) {
        return service.getAll(status, pageable);
    }

    @GetMapping("/{id}")
    public JobApplication getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public JobApplication update(
            @PathVariable Long id,
            @Valid @RequestBody JobApplication application) {
        return service.update(id, application);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}