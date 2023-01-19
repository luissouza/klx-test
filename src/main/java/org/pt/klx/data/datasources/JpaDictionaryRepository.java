package org.pt.klx.data.datasources;

import org.pt.klx.data.model.Dictionary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDictionaryRepository extends CrudRepository<Dictionary, Integer> {

  @Query(value = "select * from public.dicionario WHERE palavra_original SIMILAR TO :words", nativeQuery = true)
  Iterable<Dictionary> findTranslation(@Param("words") Object words);

}
