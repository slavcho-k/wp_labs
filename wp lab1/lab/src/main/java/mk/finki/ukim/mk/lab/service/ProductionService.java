package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Production;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionService {
    List<Production> findAll();
}
