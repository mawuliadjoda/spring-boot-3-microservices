package com.adjoda.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
public class ErrorMessage {
    private Date timestamp;
    private String message;
}
