package org.example.jpareschdl.service;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.jpareschdl.dto.ScheduleResponseDto;
import org.example.jpareschdl.entity.Schedule;
import org.example.jpareschdl.entity.User;
import org.example.jpareschdl.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserService userService;
    private final HttpSession session;

    @Transactional
    public ScheduleResponseDto save(String title, String contents) {

        Long userId = (Long) session.getAttribute("SESSION_KEY");
        // 요청 userName을 갖는 유저 조회
        User findUser = userService.findUserById(userId);

        Schedule schedule = new Schedule(findUser, title, contents);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return ScheduleResponseDto.toDto(savedSchedule);
    }

    public List<ScheduleResponseDto> findAll() {

        // 조회된 'Schedule 리스트' findAllSchedule를 'ScheduleResponseDto 리스트' 형태로 변환하여 리턴한다.
        List<Schedule> findAllSchedule = scheduleRepository.findAll();
        return findAllSchedule.stream().map(ScheduleResponseDto::toDto).toList();
    }

    public ScheduleResponseDto findById(Long id) {

        // scheduleRepository 내에서 default로 선언한 메서드를 사용하여 바로 Schedule Entity로 반환받는다! (id를 통해 특정 게시물 조회)
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return ScheduleResponseDto.toDto(findSchedule);

    }

    @Transactional
    public ScheduleResponseDto update(Long id, String title, String contents) {

        // 요청한 id로 해당 일정 조회
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        // 일정에 제목, 내용 저장
        findSchedule.update(title, contents);

        return ScheduleResponseDto.toDto(findSchedule);
    }

    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }

}
