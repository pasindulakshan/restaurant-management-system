package com.restaurant.menu.controller;

import com.restaurant.menu.models.ModifierGroupTemplate;
import com.restaurant.menu.service.ModifierGroupTemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/modifier-group-templates")
@RequiredArgsConstructor
@Log4j2
public class ModifierGroupTemplateController {

  private final ModifierGroupTemplateService modifierGroupTemplateService;

  @PostMapping
  public ResponseEntity<ModifierGroupTemplate> createModifierGroupTemplate(@RequestBody ModifierGroupTemplate modifierGroupTemplate) {
    log.info("Creating modifier group template: {}", modifierGroupTemplate);
    return ResponseEntity.status(HttpStatus.CREATED).body(modifierGroupTemplateService.createModifierGroupTemplate(modifierGroupTemplate));
  }
}
