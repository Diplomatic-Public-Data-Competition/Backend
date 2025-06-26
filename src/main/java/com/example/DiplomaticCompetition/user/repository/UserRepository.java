package com.example.DiplomaticCompetition.user.repository;

import com.example.DiplomaticCompetition.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
