package org.example.demo.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.demo.study.apiPayload.ApiResponse;
import org.example.demo.study.converter.MemberMissionConverter;
import org.example.demo.study.converter.MissionConverter;
import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.mapping.MemberMission;
import org.example.demo.study.dto.mission.MemberMissionRequestDTO;
import org.example.demo.study.dto.mission.MemberMissionResponseDTO;
import org.example.demo.study.dto.mission.MissionRequestDTO;
import org.example.demo.study.dto.mission.MissionResponseDTO;
import org.example.demo.study.service.missionService.MissionService;
import org.example.demo.study.validation.annotation.CheckPage;
import org.example.demo.study.validation.annotation.ExistStore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionService missionService;

    @PostMapping("/missions/add")
    ApiResponse<?> addMission(@RequestBody @Valid MissionRequestDTO.AddMission request) {
        Mission missionResult = missionService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(missionResult));
    }

    @PostMapping("/members/missions/add")
    ApiResponse<?> addMemberMission(@RequestBody @Valid MemberMissionRequestDTO.AddMemberMission request) {
        MemberMission memberMissionResult = missionService.addMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.addMemberMissionResultDTO(memberMissionResult));
    }

    @GetMapping("/stores/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query string 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 id, path variable 입니다.")
    })
    public ApiResponse<MissionResponseDTO.MissionPreviewListDTO> getMissionList(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                               @CheckPage @RequestParam(name = "page") Integer page) {

        Integer zeroBasedPage = page - 1;
        return ApiResponse.onSuccess(MissionConverter.missionPreviewListDTO(missionService.getMissionList(storeId, zeroBasedPage)));
    }

    @GetMapping("members/{memberId}/missions/challenging")
    @Operation(summary = "특정 유저의 진행중인 미션 목록 조회 API", description = "특정 유저의 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query string 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "memberId", description = "멤버의 id, path variable 입니다.")
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreviewListDTO> getChallengingMissionList(@PathVariable(name = "memberId") Long memberId,
                                                                           @CheckPage @RequestParam(name = "page") Integer page) {
        Integer zeroBasedPage = page - 1;
        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionPreviewListDTO(missionService.getChallengingMemberMissionList(memberId, zeroBasedPage)));
    }

    @PatchMapping("/{missionId}/complete-request")
    @Operation(summary = "미션 진행 상태를 완료로 변경하는 API", description = "특정 유저의 특정 미션의 진행 상태를 완료로 변경하는 API입니다.")
    public ApiResponse<MemberMissionResponseDTO.memberMissionResultDTO> updateMissionStatus(@PathVariable(name = "missionId") Long missionId,
                                                                                            @RequestParam(name = "memberId") Long memberId) {

        MemberMission memberMission = missionService.completeMission(memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toCompleteMissionResponseDTO(memberMission));
    }


}
