package com.project.api.entities;

import com.project.api.enums.AuditType;
import jakarta.persistence.*;

@Entity
@Table(name = AuditLog.name)
public class AuditLog extends BaseEntity{
    public static final  String name = "audit_log";

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(
            name = "auditType",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private AuditType auditType;

    @Basic
    @Column(
            name = "userId",
            nullable = false
    )
    private String userId;

    @Basic
    @Column(
            name = "details",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String details;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuditType getAuditType() {
        return auditType;
    }

    public void setAuditType(AuditType auditType) {
        this.auditType = auditType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
