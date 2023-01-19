package org.pt.klx.data.dto.mapper;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.pt.klx.data.model.Dictionary;
import org.pt.klx.domain.entities.DictionaryEntity;

public interface DictionaryEntityMapper {

  static List<DictionaryEntity> convertModelToEntity(final Iterable<Dictionary> recordEntities) {

    final ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    modelMapper.createTypeMap(Dictionary.class, DictionaryEntity.class).addMappings(mapper -> {
      mapper.map(src -> src.getId(), DictionaryEntity::setId);
      mapper.map(src -> src.getPalavraOriginal(), DictionaryEntity::setPalavraOriginal);
      mapper.map(src -> src.getPalavraTraduzida(), DictionaryEntity::setPalavraTraduzida);
    });

    return modelMapper.map(recordEntities, new TypeToken<List<DictionaryEntity>>() {
    }.getType());
  }

}
