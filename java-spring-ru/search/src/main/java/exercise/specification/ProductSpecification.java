package exercise.specification;

import exercise.model.Category;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

import java.util.ArrayList;
import java.util.List;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
return nameLike(params.getTitleCont())
        .and(withPriceGt(params.getPriceGt()))
        .and(withPriceLt(params.getPriceLt()))
        .and(withRatingGt(params.getRatingGt()))
        .and(inCategory(params.getCategoryId()));
    }

    public Specification<Product> nameLike(String title) {
        List<Category> add = new ArrayList<>();
        return (root, query, criteriaBuilder) -> title == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public Specification<Product> withPriceGt(Integer price) {
        return (root, query, criteriaBuilder) -> price == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("price"), price);
    }

    public Specification<Product> withPriceLt(Integer price) {
        return (root, query, criteriaBuilder) -> price == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.lessThan(root.get("price"), price);
    }

    public Specification<Product> withRatingGt(Double rating) {
        return (root, query, criteriaBuilder) -> rating == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("rating"), rating);
    }

    public Specification<Product> inCategory(Long categoryId) {
        return (root, query, criteriaBuilder) -> categoryId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("category").get("id"), categoryId);
    }
}
// END
