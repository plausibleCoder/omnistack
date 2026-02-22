package com.docgen.rulesmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "docgen_rule_audit")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    private Long entityId;

    private String entityType;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    @Lob // Large Object for storing JSON strings
    private String changeDetails;

    private LocalDateTime actionTimestamp;

    private String performedBy; // Placeholder for user principal

    public enum ActionType {
        CREATE, UPDATE, DELETE
    }
}
