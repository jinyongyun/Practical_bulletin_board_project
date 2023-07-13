package com.practical.practical_bulletin_board_project.repository;


import com.practical.practical_bulletin_board_project.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}