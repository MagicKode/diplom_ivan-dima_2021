package tms.diplom_ivan_dima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.diplom_ivan_dima.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
