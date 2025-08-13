package com.project.api.repositories;

import com.project.api.entities.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog , Long> {
}
