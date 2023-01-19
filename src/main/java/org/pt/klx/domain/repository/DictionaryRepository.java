package org.pt.klx.domain.repository;

import java.util.List;
import org.pt.klx.domain.entities.DictionaryEntity;

public interface DictionaryRepository {

  public List<DictionaryEntity> findTranslation(String words);
}
