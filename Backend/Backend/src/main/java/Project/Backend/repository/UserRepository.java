package Project.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByName(String name);
}
