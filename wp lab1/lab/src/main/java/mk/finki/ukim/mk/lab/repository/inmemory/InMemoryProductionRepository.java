//package mk.finki.ukim.mk.lab.repository;
//
//import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
//import mk.finki.ukim.mk.lab.model.Production;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class InMemoryProductionRepository {
//    public List<Production> findAll() {
//        return DataHolder.productions;
//    }
//
//    public Production findProductionByName(String name) {
//        return DataHolder.productions.stream()
//                .filter(p -> p.getName().equals(name))
//                .findFirst()
//                .orElse(null);
//    }
//}
