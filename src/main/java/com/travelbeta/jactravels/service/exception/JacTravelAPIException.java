package com.travelbeta.jactravels.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JacTravelAPIException extends RuntimeException{

    private ErrorDTO errorDTO;

    public JacTravelAPIException(String errorType , String errorName){
        errorDTO = new ErrorDTO();
        errorDTO.setErrorType(errorType);
        errorDTO.setErrorMessage(errorName);
    }
}
