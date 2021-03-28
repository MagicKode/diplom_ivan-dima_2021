package tms.diplom_ivan_dima.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tms.diplom_ivan_dima.Model.Category;

@Component
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
