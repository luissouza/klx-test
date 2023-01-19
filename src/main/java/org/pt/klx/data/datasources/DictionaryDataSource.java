package org.pt.klx.data.datasources;

import java.util.List;
import org.pt.klx.domain.entities.DictionaryEntity;

public interface DictionaryDataSource {

  public List<DictionaryEntity> findTranslation(String words);

}

