package org.javasoft.searchapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchAPIException extends RuntimeException{

    private ErrorDTO errorDTO;

    public SearchAPIException(String errorType , String errorName){
        errorDTO = new ErrorDTO();
        errorDTO.setErrorType(errorType);
        errorDTO.setErrorMessage(errorName);
    }
}
