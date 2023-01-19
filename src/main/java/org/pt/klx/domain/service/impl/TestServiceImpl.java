package org.pt.klx.domain.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.pt.klx.core.exception.TranslateException;
import org.pt.klx.core.exception.ValidateJsonException;
import org.pt.klx.data.dto.request.ValidateJsonParams;
import org.pt.klx.domain.entities.DictionaryEntity;
import org.pt.klx.domain.repository.DictionaryRepository;
import org.pt.klx.domain.service.TestService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestServiceImpl implements TestService {

  private final DictionaryRepository dicionarioRepo;

  public TestServiceImpl(final DictionaryRepository flightsRecordsRepo) {
    this.dicionarioRepo = flightsRecordsRepo;
  }

  @Override
  public Optional<?> findTranslation(final String words) {

    try {

      log.info("findTranslation - Method findTranslation Started: {} ", words);

      final List<DictionaryEntity> res = this.dicionarioRepo.findTranslation(words.replaceAll("\\s+", "|"));
      final StringBuilder builder = new StringBuilder();
      res.forEach((val) -> builder.append(val.getPalavraTraduzida()).append(" "));

      return Optional.of(builder.toString());

    } catch (final Exception e) {
      throw new TranslateException();
    }
  }

  @Override
  public Optional<?> validateJson(final ValidateJsonParams body) {

    try {

      log.info("validateJson - Method validateJson Started: {} ", body.toJson());

      final Character[] openBrackets = {'[', '{'};
      final Character[] closeBrackets = {']', '}'};
      final Map<String, String> response = new HashMap<>();

      Arrays.stream(body.getJsonList()).forEach((json) -> {

        final AtomicBoolean isValidJson = new AtomicBoolean(true);
        final Character[] jsonChars = json.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        IntStream.range(0, openBrackets.length).forEach(index -> {
          if (checkChar(jsonChars, openBrackets[index]) != checkChar(jsonChars, closeBrackets[index])) {
            isValidJson.set(false);
          }
        });
        response.put(json, isValidJson.get() ? "JSON Valid" : "JSON Invalid");
      });

      return Optional.of(response);

    } catch (final Exception e) {
      throw new ValidateJsonException();
    }
  }

  public static int checkChar(final Character[] tokenOfCharacter, final Character bracketType) {

    final AtomicInteger count = new AtomicInteger();

    Arrays.stream(tokenOfCharacter).forEach((character) -> {
      if (character == bracketType) {
        count.addAndGet(1);
      }
    });

    return count.get();
  }

}