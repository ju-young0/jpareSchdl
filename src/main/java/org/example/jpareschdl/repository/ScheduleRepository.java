package org.example.jpareschdl.repository;

import org.example.jpareschdl.entity.Schedule;
import org.example.jpareschdl.exception.CustomException;
import org.example.jpareschdl.exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long id) {

        return findById(id).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND, id));
    }
}
