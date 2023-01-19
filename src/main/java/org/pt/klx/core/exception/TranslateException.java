package org.pt.klx.core.exception;

import org.springframework.http.HttpStatus;

public class TranslateException extends RuntimeException {
  
  private final String message = HttpStatus.INTERNAL_SERVER_ERROR.toString();
  private final String errorReason = "Fail to translate words";

  public String getMessage() {
    return message;
  }

  public String getErrorReason() {
    return errorReason;
  }

}
