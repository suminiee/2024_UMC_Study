package org.example.demo.study.service.tempService;

import lombok.RequiredArgsConstructor;
import org.example.demo.study.apiPayload.code.exception.handler.TempHandler;
import org.example.demo.study.apiPayload.code.status.ErrorStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
