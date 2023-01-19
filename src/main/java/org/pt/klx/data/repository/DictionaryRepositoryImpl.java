package org.pt.klx.data.repository;

import java.util.List;
import org.pt.klx.data.datasources.DictionaryDataSource;
import org.pt.klx.domain.entities.DictionaryEntity;
import org.pt.klx.domain.repository.DictionaryRepository;
import org.springframework.stereotype.Component;

@Component
public class DictionaryRepositoryImpl implements DictionaryRepository {

  private final DictionaryDataSource flightsRecordsDataSource;

  public DictionaryRepositoryImpl(final DictionaryDataSource dictionaryDataSource) {
    this.flightsRecordsDataSource = dictionaryDataSource;
  }

  @Override
  public List<DictionaryEntity> findTranslation(final String words) {
    return this.flightsRecordsDataSource.findTranslation(words);
  }

}
