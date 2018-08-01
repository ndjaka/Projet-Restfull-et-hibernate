package org.centaurus.SpringController;

import org.centaurus.entities.Categorie;
import org.centaurus.repository.modelrepository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("categorie")
class CategorieController {


    CategoryRepository categoryRepository;

    @Autowired
    public CategorieController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    Collection<Categorie> getAll() {
        return categoryRepository.getAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody
    Categorie add(@RequestBody Categorie categorie) {

        return categoryRepository.save(categorie);

    }


    @RequestMapping(value = "", method = RequestMethod.PUT)
    public @ResponseBody
    Categorie Update(@RequestBody Categorie categorie) {
        return categoryRepository.update(categorie);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void delete(@PathVariable("id") Long id) {
         categoryRepository.delete(id);
    }


}
