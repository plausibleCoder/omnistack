package com.docgen.rulesmanagement.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

// Using a single DTO for simplicity, can be split into Create/Update/Response DTOs
@Data
public class RuleDto {
    private Long ruleId;
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
    private LocalDateTime updatedAt;
}
