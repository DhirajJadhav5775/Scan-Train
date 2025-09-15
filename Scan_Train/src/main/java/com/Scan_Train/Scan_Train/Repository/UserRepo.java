package com.Scan_Train.Scan_Train.Repository;

import com.Scan_Train.Scan_Train.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
//    boolean existsByEmail(String Email);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
