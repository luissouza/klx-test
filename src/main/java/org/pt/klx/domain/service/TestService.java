package org.pt.klx.domain.service;

import java.util.Optional;
import org.pt.klx.data.dto.request.ValidateJsonParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface TestService {

  Logger log = LoggerFactory.getLogger(TestService.class);

  Optional<?> findTranslation(String words);

  Optional<?> validateJson(ValidateJsonParams body);
}
