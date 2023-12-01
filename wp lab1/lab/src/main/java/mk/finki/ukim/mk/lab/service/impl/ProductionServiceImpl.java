package mk.finki.ukim.mk.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Production;
import mk.finki.ukim.mk.lab.repository.jpa.ProductionRepository;
import mk.finki.ukim.mk.lab.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {
    private final ProductionRepository productionRepository;
//    private final InMemoryProductionRepository productionRepository;

    @Override
    public List<Production> findAll() {
        return productionRepository.findAll();
    }
}
