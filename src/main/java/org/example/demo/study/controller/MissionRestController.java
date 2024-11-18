package org.example.demo.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.apiPayload.ApiResponse;
import org.example.demo.study.converter.MissionConverter;
import org.example.demo.study.domain.Mission;
import org.example.demo.study.dto.mission.MissionRequestDTO;
import org.example.demo.study.service.missionService.MissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionService missionService;

    @PostMapping("/missions/add")
    ApiResponse<?> addMission(@RequestBody @Valid MissionRequestDTO.AddMission request) {
        Mission missionResult = missionService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(missionResult));
    }

}
