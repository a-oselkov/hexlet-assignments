package exercise.service;

import exercise.model.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

//public class UserSpecification implements Specification<User> {
//
//    private SearchCriteria searchCriteria;
//
//    public UserSpecification(SearchCriteria searchCriteria) {
//        this.searchCriteria = searchCriteria;
//    }
//
//    @Override
//    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//        // BEGIN
//
//        // END
//        }
//}
