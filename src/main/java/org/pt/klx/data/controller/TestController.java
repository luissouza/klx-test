package org.pt.klx.data.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.websocket.server.PathParam;
import org.pt.klx.data.dto.request.ValidateJsonParams;
import org.pt.klx.domain.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TestController {

  private final TestService testService;

  public TestController(final TestService testService) {
    this.testService = testService;
  }

  @Tag(name = "TestController")
  @Operation(summary = "Translate words")
  @RequestMapping(value = "translate", method = RequestMethod.GET, headers = "Accept=application/json")
  public ResponseEntity<?> findTranslation(@PathParam("words") final String words) {
    return new ResponseEntity<>(testService.findTranslation(words), HttpStatus.OK);
  }

  @Tag(name = "TestController")
  @Operation(summary = "Validate Jsob")
  @RequestMapping(value = "validate/json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> validateJson(@RequestBody final ValidateJsonParams body) {
    return new ResponseEntity<>(testService.validateJson(body), HttpStatus.OK);
  }

}
