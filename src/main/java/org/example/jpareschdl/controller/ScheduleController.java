package org.example.jpareschdl.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jpareschdl.dto.ScheduleCreateRequestDto;
import org.example.jpareschdl.dto.ScheduleResponseDto;
import org.example.jpareschdl.dto.ScheduleUpdateRequestDto;
import org.example.jpareschdl.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@Valid @RequestBody ScheduleCreateRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    // 특정 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    // 특정 일정 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @RequestBody ScheduleUpdateRequestDto requestDto) {

        ScheduleResponseDto updateSchedule = scheduleService.update(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(updateSchedule, HttpStatus.OK);
    }

    // 특정 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
