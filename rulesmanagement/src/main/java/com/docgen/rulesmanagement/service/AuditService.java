package com.docgen.rulesmanagement.service;

import com.docgen.rulesmanagement.domain.AuditEntry;
import com.docgen.rulesmanagement.repository.AuditEntryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditEntryRepository auditEntryRepository;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public <T> void logAction(T entity, AuditEntry.ActionType actionType) {
        String details = objectMapper.writeValueAsString(entity);

        AuditEntry entry = AuditEntry.builder()
                .entityId(getEntityId(entity))
                .entityType(entity.getClass().getSimpleName())
                .actionType(actionType)
                .changeDetails(details)
                .actionTimestamp(java.time.LocalDateTime.now())
                .performedBy("system") // Replace with actual user later
                .build();

        auditEntryRepository.save(entry);
    }

    // Helper to get ID via reflection, brittle but works for this example
    @SneakyThrows
    private Long getEntityId(Object entity) {
        java.lang.reflect.Field idField = entity.getClass().getDeclaredField("ruleId");
        idField.setAccessible(true);
        return (Long) idField.get(entity);
    }
}
