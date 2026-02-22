package com.docgen.rulesmanagement.controller;

import com.docgen.rulesmanagement.dto.RuleDto;
import com.docgen.rulesmanagement.service.RuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/rules")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @GetMapping
    public Page<RuleDto> getAllRules(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String documentType,
            @RequestParam(defaultValue = "ruleId") String sortBy,
            @RequestParam(defaultValue = "asc") String order
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString(order), sortBy);
        Pageable pageable = PageRequest.of(page, limit, sort);
        return ruleService.findAllRules(pageable, query, state, documentType);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RuleDto> getRuleById(@PathVariable Long id) {
        return ResponseEntity.ok(ruleService.findRuleById(id));
    }

    @PostMapping
    public ResponseEntity<RuleDto> createRule(@Valid @RequestBody RuleDto ruleDto) {
        return new ResponseEntity<>(ruleService.createRule(ruleDto), HttpStatus.CREATED);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<RuleDto> patchRule(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(ruleService.patchRule(id, updates));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }
}
