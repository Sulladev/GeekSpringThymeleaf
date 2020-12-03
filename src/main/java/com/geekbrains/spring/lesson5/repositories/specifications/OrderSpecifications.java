package com.geekbrains.spring.lesson5.repositories.specifications;

import com.geekbrains.spring.lesson5.entities.Order;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecifications {

    public static Specification<Order> priceGreaterOrEqualsThan(Integer minPrice) {
        return (Specification<Order>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("currentPrice"), minPrice);  // where p.price >= minPrice
    }

    public static Specification<Order> priceLesserOrEqualsThan(Integer maxPrice) {
        return (Specification<Order>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("currentPrice"), maxPrice); // where p.price <= maxPrice
    }

    public static Specification<Order> titleLike(String titlePart) {
        return (Specification<Order>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("code"), String.format("%%%s%%", titlePart)); // where p.title like %titlePart%
    }
}
