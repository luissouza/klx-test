package org.pt.klx.data.datasources.impl;

import java.util.List;
import org.pt.klx.data.datasources.DictionaryDataSource;
import org.pt.klx.data.datasources.JpaDictionaryRepository;
import org.pt.klx.data.dto.mapper.DictionaryEntityMapper;
import org.pt.klx.domain.entities.DictionaryEntity;
import org.springframework.stereotype.Component;

@Component
public class DictionaryDataSourceImpl implements DictionaryDataSource {

  final JpaDictionaryRepository jpaDictionaryRepository;

  public DictionaryDataSourceImpl(final JpaDictionaryRepository jpaDictionaryRepository) {
    this.jpaDictionaryRepository = jpaDictionaryRepository;
  }

  @Override
  public List<DictionaryEntity> findTranslation(final String words) {
    return DictionaryEntityMapper.convertModelToEntity(jpaDictionaryRepository.findTranslation(words));
  }

}
