package org.example.demo.study.service.missionService;

import lombok.RequiredArgsConstructor;
import org.example.demo.study.converter.MissionConverter;
import org.example.demo.study.domain.Mission;
import org.example.demo.study.domain.Store;
import org.example.demo.study.dto.mission.MissionRequestDTO;
import org.example.demo.study.exception.mission.MissionErrorCode;
import org.example.demo.study.exception.mission.MissionException;
import org.example.demo.study.repository.MissionRepository;
import org.example.demo.study.repository.storeRepo.StoreRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission addMission(MissionRequestDTO.AddMission request) {

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(
                () -> new MissionException(MissionErrorCode.STORE_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, store);

        return missionRepository.save(newMission);
    }
}
