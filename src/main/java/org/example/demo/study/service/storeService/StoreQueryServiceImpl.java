package org.example.demo.study.service.storeService;

import lombok.RequiredArgsConstructor;
import org.example.demo.study.domain.Store;
import org.example.demo.study.repository.storeRepo.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Object> findStoresByNameAndScore(String name, Float score) {
        List<Object> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }
}
