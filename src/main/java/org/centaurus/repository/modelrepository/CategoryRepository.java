package org.centaurus.repository.modelrepository;

import org.centaurus.entities.Categorie;
import org.centaurus.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepository extends Repository<Categorie, Long> implements ICategoryRepository {

}
