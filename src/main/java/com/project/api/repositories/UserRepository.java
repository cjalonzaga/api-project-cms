package com.project.api.repositories;

import com.project.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
                SELECT CASE WHEN COUNT(u) > 0
                THEN TRUE
                ELSE FALSE
                END
                FROM User u WHERE u.username = :username
            """)
    Boolean isUserExist( String username );

    User findByUsername(String username);
}
