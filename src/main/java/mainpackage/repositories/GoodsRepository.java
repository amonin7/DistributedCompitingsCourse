package mainpackage.repositories;

import mainpackage.entities.GoodEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GoodsRepository extends CrudRepository<GoodEntity, Long> {
    Optional<GoodEntity> findByName(String name);
}
