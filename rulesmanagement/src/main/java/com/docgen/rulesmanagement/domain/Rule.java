package com.docgen.rulesmanagement.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "docgen_rule_engine")
@Data
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;

    @NotNull
    private String category;
    
    private String marketSegment;
    private String state;
    private String productStatus;
    private String marketingStatus;
    private String benefitPeriod;
    private String documentType;
    private LocalDate effectiveDate;
    private String productType;
    private String replicationPeriod;
    private String replicationFrequency;
    private String documentLanguage;
    private String format;
    private String watermark;
    private String publish;
    private String dpsExternal;
    private String dpsInternal;
    private String contractCodes;
    private String documentGeneration;
    private String planFormat;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
