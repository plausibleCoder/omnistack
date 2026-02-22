-- This script is executed on startup by Spring Boot if found.
-- It defines the database schema for the DocGen Rules Management application.

-- Drop tables if they already exist to ensure a clean state on each startup.
DROP TABLE IF EXISTS docgen_rule_engine;
DROP TABLE IF EXISTS docgen_rule_audit;


-- =================================================================
-- Table for storing the core document generation rules.
-- Corresponds to the 'Rule' entity.
-- =================================================================
CREATE TABLE docgen_rule_engine (
    -- Primary Key
    rule_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    -- Rule attributes
    category VARCHAR(255) NOT NULL,
    market_segment VARCHAR(255),
    state VARCHAR(255),
    product_status VARCHAR(255),
    marketing_status VARCHAR(255),
    benefit_period VARCHAR(255),
    document_type VARCHAR(255),
    effective_date DATE,
    product_type VARCHAR(255),
    replication_period VARCHAR(255),
    replication_frequency VARCHAR(255),
    document_language VARCHAR(255),
    format VARCHAR(255),
    watermark VARCHAR(255),
    publish VARCHAR(255),
    dps_external VARCHAR(255),
    dps_internal VARCHAR(255),
    contract_codes VARCHAR(1000),
    document_generation VARCHAR(255),
    plan_format VARCHAR(255),

    -- Auto-managed timestamp for the last update
    updated_at TIMESTAMP
);


-- =================================================================
-- Table for auditing all Create, Update, and Delete actions.
-- Corresponds to the 'AuditEntry' entity.
-- =================================================================
CREATE TABLE docgen_rule_audit (
    -- Primary Key
    audit_id BIGINT AUTO_INCREMENT PRIMARY KEY,

    -- Link to the entity that was changed
    entity_id BIGINT,
    entity_type VARCHAR(255),

    -- Audit information
    action_type VARCHAR(50),
    action_timestamp TIMESTAMP,
    performed_by VARCHAR(255),

    -- JSON or text representation of the entity state
    -- Using TEXT for compatibility and to store large JSON strings
    change_details TEXT
);
