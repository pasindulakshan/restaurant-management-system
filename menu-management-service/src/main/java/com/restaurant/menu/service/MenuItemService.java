package com.restaurant.menu.service;
import com.restaurant.menu.models.MenuItem;
import com.restaurant.common.models.Audit;
import com.restaurant.common.models.embeddable.Status;
import com.restaurant.menu.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.bson.types.ObjectId;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }
    public Optional<MenuItem> findMenuItemById(ObjectId id) {
        return menuItemRepository.findById(id);
    }
    public List<MenuItem> findAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public List<MenuItem> findAllNotDeletedMenuItems() {
        return menuItemRepository.findAllNotDeleted();
    }

    public MenuItem updateMenuItem(ObjectId id, MenuItem updatedMenuItem) {
        // Check if the menu item exists
        Optional<MenuItem> existingMenuItemOptional = menuItemRepository.findById(id);
        if (existingMenuItemOptional.isPresent()) {
            MenuItem existingMenuItem = existingMenuItemOptional.get();
            // Update fields
            existingMenuItem.setName(updatedMenuItem.getName());
            existingMenuItem.setDescription(updatedMenuItem.getDescription());
            existingMenuItem.setModifierGroups(updatedMenuItem.getModifierGroups());
            existingMenuItem.setIngredients(updatedMenuItem.getIngredients());
            existingMenuItem.setPackaging(updatedMenuItem.getPackaging());
            existingMenuItem.setAllergens(updatedMenuItem.getAllergens());
            existingMenuItem.setClassifications(updatedMenuItem.getClassifications());
            existingMenuItem.setTags(updatedMenuItem.getTags());
            existingMenuItem.setImageUrl(updatedMenuItem.getImageUrl());
            existingMenuItem.setBarcode(updatedMenuItem.getBarcode());
            existingMenuItem.setPreparationTime(updatedMenuItem.getPreparationTime());
            existingMenuItem.setPrice(updatedMenuItem.getPrice());
            // Save and return updated menu item
            return menuItemRepository.save(existingMenuItem);
        } else {
            // If the menu item doesn't exist, return null or throw an exception as per requirement
            return null;
        }
    }

    public boolean deleteMenuItem(ObjectId id) {
        // Check if the menu item exists
        Optional<MenuItem> menuItemOptional = menuItemRepository.findById(id);
        if (menuItemOptional.isPresent()) {
            // Soft delete by marking status as DELETED
            MenuItem menuItem = menuItemOptional.get();
            menuItem.setStatus(Status.DELETED);
            menuItemRepository.save(menuItem);
            return true;
        } else {
            // If the menu item doesn't exist, return false
            return false;
        }
    }
}
