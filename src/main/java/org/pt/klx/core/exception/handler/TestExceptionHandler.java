package org.pt.klx.core.exception.handler;

import org.pt.klx.core.exception.TranslateException;
import org.pt.klx.core.exception.ValidateJsonException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class TestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TranslateException.class)
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public @ResponseBody GlobalError translateException(final TranslateException exception) {

    final GlobalError error = new GlobalError();
    error.setMessage(exception.getMessage());
    error.setErrorReason(exception.getErrorReason());
    return error;
  }

  @ExceptionHandler(ValidateJsonException.class)
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public @ResponseBody GlobalError validateJsonException(final ValidateJsonException exception) {

    final GlobalError error = new GlobalError();
    error.setMessage(exception.getMessage());
    error.setErrorReason(exception.getErrorReason());
    return error;
  }

}
