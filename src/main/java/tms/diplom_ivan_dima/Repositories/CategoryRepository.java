package tms.diplom_ivan_dima.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tms.diplom_ivan_dima.Model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
