package com.restaurant.menu.service;

import com.restaurant.menu.models.Menu;
import com.restaurant.common.models.Audit;
import com.restaurant.common.models.embeddable.Status;
import com.restaurant.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.bson.types.ObjectId;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class MenuService {

    private final MenuRepository menuRepository;

    public Menu createMenu(Menu menu){
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(ObjectId id) {
        return menuRepository.findById(id);
    }

    public Menu updateMenu(Menu menu, ObjectId id) {
        // Find the existing menu by id
        Optional<Menu> existingMenu = menuRepository.findById(id);
        if (existingMenu.isPresent()) {
            Menu menuToUpdate = existingMenu.get();
            // Update existing menu fields (excluding id) based on the provided menu object
            menuToUpdate.setName(menu.getName());
            menuToUpdate.setDescription(menu.getDescription());
            menuToUpdate.setCategories(menu.getCategories());
            menuToUpdate.setTags(menu.getTags());
            menuToUpdate.setStatus(menu.getStatus());
            return menuRepository.save(menuToUpdate);
        } else {
            return null;
        }
    }

    public void deleteMenuById(ObjectId id){
        log.info("Deleting menu with id: {}", id);
        menuRepository.deleteById(id);
    }
}
