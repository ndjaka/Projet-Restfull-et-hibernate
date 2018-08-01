package PersistenceTest;


import org.centaurus.repository.modelrepository.CategoryRepository;
import org.centaurus.app.config.HibernateConfig;
import org.centaurus.entities.Categorie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PersistanceTest {
    private Logger logger = LoggerFactory.getLogger(PersistanceTest.class);
    CategoryRepository categoryRepository = new CategoryRepository();
    HibernateConfig hibernateConfig = new HibernateConfig();

    @BeforeEach
    public void setUp()
    {
        categoryRepository.setSessionFactory(hibernateConfig.getSessionFactory());
    }


    @Test
    public void SaveProduct() {

        //categoryRepositoryImpl.save(new Categorie("ndkaka", "adfad", "adsfadsf"));
        categoryRepository.save(new Categorie("cissoko", "adfad", "adsfadsf"));
        Categorie cat= new Categorie("ulrich", "adfad", "adsfadsf");
      categoryRepository.save(cat);
        Assertions.assertTrue(cat.getId() != null);

    }

    @Test
    public void findOne() {

        categoryRepository.getObjetById(1);

    }
    @Test
    public void findAll() {


        Assertions.assertEquals(3, categoryRepository.getAll().size());

    }
    @Test
    public void delete() {

        categoryRepository.delete(1);

    }



}