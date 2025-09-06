package vedaflow.vedaflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vedaflow.vedaflow.user.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByUsername(String username);

    @Query("SELECT u FROM UserModel u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :username ,'%'))")
    List<UserModel> searchByUsername(@Param("username") String username);

}
