package org.example.demo.study.repository.storeRepo;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Object> dynamicQueryWithBooleanBuilder(String name, Float score);
}
