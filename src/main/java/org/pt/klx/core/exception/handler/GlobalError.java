package org.pt.klx.core.exception.handler;

public class GlobalError {

  private String message;
  private String errorReason;

  public GlobalError() {
  }

  public GlobalError(final String message, final String errorReason) {
    this.message = message;
    this.errorReason = errorReason;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public void setErrorReason(final String errorReason) {
    this.errorReason = errorReason;
  }

  public String getMessage() {
    return message;
  }

  public String getErrorReason() {
    return errorReason;
  }

}
