package org.example.jpareschdl.repository;

import org.example.jpareschdl.entity.User;
import org.example.jpareschdl.exception.CustomException;
import org.example.jpareschdl.exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND, id));
    }

    User findByEmail(String email);

}
