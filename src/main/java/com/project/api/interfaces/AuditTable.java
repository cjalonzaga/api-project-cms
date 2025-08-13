package com.project.api.interfaces;

import com.project.api.enums.AuditType;
import org.springframework.data.domain.AuditorAware;

public interface AuditTable extends AuditorAware<String> {

    public Long getId();

    public String auditableValue();

    public AuditType auditType();

}
