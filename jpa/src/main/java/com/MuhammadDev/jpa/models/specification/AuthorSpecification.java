package com.MuhammadDev.jpa.models.specification;

import com.MuhammadDev.jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/*
AuthorSpecification class have some filtering methods used in searching
 */

public class AuthorSpecification {

    /*
    search with specific age
     */

    public static Specification<Author> hasAge(int age) {
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder builder
        ) -> {
            if (age < 0) {
                return null;
            }
            return builder.equal(root.get("age"), age);
        };
    }
    /*
    search with %part% of Author's name
     */

        public static Specification<Author> firstnameLike(String firstname) {
            return (
                    Root<Author> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder builder
            ) -> {
                if (firstname == null) {
                    return null;
                }
                return builder.like(root.get("firstName"), "%"+firstname+"%");
            };
        }

    }






