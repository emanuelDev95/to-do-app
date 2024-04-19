package com.egvc.task.dtos;

import java.util.Date;

public record ErrorMessageResponse(Integer value,
                                   Date date,
                                   String message) {

}
