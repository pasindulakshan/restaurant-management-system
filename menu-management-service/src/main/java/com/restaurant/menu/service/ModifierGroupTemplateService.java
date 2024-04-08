package com.restaurant.menu.service;

import com.restaurant.menu.models.ModifierGroupTemplate;
import com.restaurant.menu.repository.ModifierGroupTemplateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ModifierGroupTemplateService {

  private final ModifierGroupTemplateRepository modifierGroupTemplateRepository;

  public ModifierGroupTemplate createModifierGroupTemplate(ModifierGroupTemplate modifierGroupTemplate) {
      return modifierGroupTemplateRepository.save(modifierGroupTemplate);
  }
}
