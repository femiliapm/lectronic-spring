package com.lectronicApp.model.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError<T> {
  private Integer status;
  private LocalDateTime timestamp;
  private String message;
  private T errors;

  public ResponseError(Integer status, LocalDateTime timestamp, String message) {
    this.status = status;
    this.timestamp = timestamp;
    this.message = message;
  }
}
