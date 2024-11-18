package org.example.demo.study.dto.store;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.example.demo.study.validation.annotation.ExistRegion;

public class StoreRequestDTO {

    @Getter
    public static class AddStore {

        @NotNull(message = "store name은 필수입니다.")
        String name;
        @NotNull(message = "store address는 필수입니다.")
        String address;
        @NotNull(message = "RegionId는 필수입니다.")
//        @ExistRegion
        private Long regionId;

    }
}
