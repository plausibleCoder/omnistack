package com.docgen.rulesmanagement.service;

import com.docgen.rulesmanagement.domain.AuditEntry;
import com.docgen.rulesmanagement.domain.Rule;
import com.docgen.rulesmanagement.dto.RuleDto;
import com.docgen.rulesmanagement.exception.ResourceNotFoundException;
import com.docgen.rulesmanagement.repository.RuleRepository;
import com.docgen.rulesmanagement.repository.RuleSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class RuleService {

    private final RuleRepository ruleRepository;
    private final AuditService auditService;

    public Page<RuleDto> findAllRules(Pageable pageable, String query, String state, String documentType) {
        var spec = RuleSpecification.withDynamicQuery(query, state, documentType);
        return ruleRepository.findAll(spec, pageable).map(this::toDto);
    }

    public RuleDto findRuleById(Long id) {
        return ruleRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found with id: " + id));
    }

    public RuleDto createRule(RuleDto ruleDto) {
        Rule rule = toEntity(ruleDto);
        rule.setRuleId(null); // Ensure it's a new entity
        Rule savedRule = ruleRepository.save(rule);
        auditService.logAction(savedRule, AuditEntry.ActionType.CREATE);
        return toDto(savedRule);
    }
    
    public void deleteRule(Long id) {
        Rule rule = ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found with id: " + id));
        auditService.logAction(rule, AuditEntry.ActionType.DELETE);
        ruleRepository.deleteById(id);
    }

    public RuleDto patchRule(Long id, Map<String, Object> updates) {
        Rule rule = ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found with id: " + id));

        updates.forEach((key, value) -> {
            // Use reflection or a library like MapStruct for better implementation
            try {
                java.lang.reflect.Field field = rule.getClass().getDeclaredField(key);
                field.setAccessible(true);
                // Basic type conversion
                if (field.getType().equals(LocalDate.class)) {
                    field.set(rule, LocalDate.parse(value.toString()));
                } else {
                    field.set(rule, value);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Ignore fields that don't exist
            }
        });
        
        Rule updatedRule = ruleRepository.save(rule);
        auditService.logAction(updatedRule, AuditEntry.ActionType.UPDATE);
        return toDto(updatedRule);
    }
    
    // --- Mapper methods ---
    private RuleDto toDto(Rule rule) {
        RuleDto dto = new RuleDto();
        BeanUtils.copyProperties(rule, dto);
        return dto;
    }

    private Rule toEntity(RuleDto dto) {
        Rule rule = new Rule();
        BeanUtils.copyProperties(dto, rule);
        return rule;
    }
}
