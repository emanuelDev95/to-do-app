package com.egvc.task.dtos.responses;

import java.util.Date;

public record ErrorMessageResponse(Integer value,
                                   Date date,
                                   String message) {

}
