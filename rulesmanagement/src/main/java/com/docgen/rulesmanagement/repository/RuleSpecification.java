package com.docgen.rulesmanagement.repository;

import com.docgen.rulesmanagement.domain.Rule;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RuleSpecification {

    public static Specification<Rule> withDynamicQuery(
            String query, String state, String documentType) {

        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Global search query across multiple fields
            if (StringUtils.hasText(query)) {
                String likeQuery = "%" + query.toLowerCase() + "%";
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("category")), likeQuery),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("marketSegment")), likeQuery),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("state")), likeQuery),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("documentType")), likeQuery)
                ));
            }

            // Specific column filters
            if (StringUtils.hasText(state)) {
                predicates.add(criteriaBuilder.equal(root.get("state"), state));
            }

            if (StringUtils.hasText(documentType)) {
                predicates.add(criteriaBuilder.equal(root.get("documentType"), documentType));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
