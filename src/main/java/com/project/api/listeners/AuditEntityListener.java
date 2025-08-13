package com.project.api.listeners;

import com.project.api.entities.AuditLog;
import com.project.api.enums.AuditType;
import com.project.api.repositories.AuditLogRepository;
import com.project.api.utils.BeanUtil;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

public class AuditEntityListener {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @PostPersist
    public void onPostPersist(Object entity) {
        createAudit(entity, AuditType.CREATE);
    }

    @PostUpdate
    public void onPostUpdate(Object entity) {
        createAudit(entity, AuditType.UPDATE);
    }

    @PostRemove
    public void onPostRemove(Object entity) {
        createAudit(entity, AuditType.DELETE);
    }

    private void createAudit(Object entity , AuditType auditType){
        AuditLogRepository auditLogRepository = BeanUtil.getBeanClass(AuditLogRepository.class);

        AuditLog auditLog = new AuditLog();
        auditLog.setValid(true);
        auditLog.setCreatedOn(LocalDateTime.now());
        auditLog.setUpdatedOn(LocalDateTime.now());
        auditLog.setUsername(getCurrentUsername());
        auditLog.setDetails(entity.toString());
        auditLog.setAuditType(auditType);
        auditLog.setUserId(getEntityId(entity));

        auditLogRepository.save(auditLog);

    }

    private String getEntityId(Object entity){
        try {
            Field idField = entity.getClass().getDeclaredField("id");
            idField.setAccessible(true);
            return String.valueOf(idField.get(entity));
        } catch (Exception e) {
            return "unknown";
        }
    }

    private String getCurrentUsername() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return auth != null ? auth.getName() : "anonymous";
        } catch (Exception e) {
            return "system";
        }
    }
}
