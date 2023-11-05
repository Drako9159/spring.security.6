package drako.springsecurity.repository;

import drako.springsecurity.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserDto, Long> {
}
