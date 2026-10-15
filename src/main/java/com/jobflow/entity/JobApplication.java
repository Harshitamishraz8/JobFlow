
package com.jobflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company name is required")
    @Column(nullable = false)
    private String company;

    @NotBlank(message = "Role is required")
    @Column(nullable = false)
    private String role;

    @NotBlank(message = "Status is required")
    @Pattern(
        regexp = "APPLIED|IN_PROGRESS|INTERVIEW|OFFER|REJECTED|WITHDRAWN",
        message = "Invalid application status"
    )
    @Column(nullable = false)
    private String status = "APPLIED";

    private LocalDateTime appliedAt = LocalDateTime.now();

    public JobApplication() {}

    public Long getId() { return id; }
    public String getCompany() { return company; }
    public String getRole() { return role; }
    public String getStatus() { return status; }
    public LocalDateTime getAppliedAt() { return appliedAt; }

    public void setCompany(String company) { this.company = company; }
    public void setRole(String role) { this.role = role; }
    public void setStatus(String status) { this.status = status; }
}