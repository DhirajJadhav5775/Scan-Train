package com.Scan_Train.Scan_Train.Repository;

import com.Scan_Train.Scan_Train.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Integer, User>
{

}
