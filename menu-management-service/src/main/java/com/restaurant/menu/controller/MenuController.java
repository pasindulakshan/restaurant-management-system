package com.restaurant.menu.controller;

import com.restaurant.menu.models.Menu;
import com.restaurant.common.models.embeddable.Status;
import com.restaurant.common.models.Audit;
import com.restaurant.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/menus")
@RequiredArgsConstructor
@Log4j2
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu){
        log.info("Creating menu: {}", menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.createMenu(menu));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable ObjectId id, @RequestBody Menu menu){
        log.info("Updating menu with id: {}", id);

        Menu updatedMenu = menuService.updateMenu(menu, id); // Pass id to service
        if (updatedMenu != null) {
            return ResponseEntity.ok(updatedMenu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET request to retrieve all menus created.
    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        log.info("Retrieving all menus");
        List<Menu> menus = menuService.getAllMenus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable ObjectId id) {
        log.info("Retrieving menu with id: {}", id);
        Optional<Menu> menu = menuService.getMenuById(id);
        if (menu.isPresent()) {
            return ResponseEntity.ok(menu.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteMenuById(@PathVariable ObjectId id) {
        log.info("Deleting menu with id: {}", id);
        menuService.deleteMenuById(id);
        return ResponseEntity.noContent().build(); // 204 No Content response
    }

    @PatchMapping(path = "/{id}/activate")
    public ResponseEntity<Menu> activateMenu(@PathVariable ObjectId id) {
        log.info("Activating menu with id: {}", id);
        Optional<Menu> menu = menuService.getMenuById(id);
        if (menu.isPresent()) {
            Menu updatedMenu = menu.get();
            // Access status through inheritance (assuming Audit has getStatus)
            updatedMenu.setStatus(Status.ACTIVE);
            menuService.updateMenu(updatedMenu, id);
            return ResponseEntity.ok(updatedMenu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(path = "/{id}/deactivate")
    public ResponseEntity<Menu> deactivateMenu(@PathVariable ObjectId id) {
        log.info("Deactivating menu with id: {}", id);
        Optional<Menu> menu = menuService.getMenuById(id);
        if (menu.isPresent()) {
            Menu updatedMenu = menu.get();
            updatedMenu.setStatus(Status.INACTIVE);
            menuService.updateMenu(updatedMenu, id);
            return ResponseEntity.ok(updatedMenu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}