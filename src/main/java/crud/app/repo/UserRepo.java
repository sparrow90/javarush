package crud.app.repo;

import crud.app.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Page<User> findAllByNameIgnoreCaseContaining(String search, Pageable pageable);
}
