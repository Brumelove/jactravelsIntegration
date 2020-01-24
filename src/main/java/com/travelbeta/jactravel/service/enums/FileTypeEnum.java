package com.travelbeta.jactravel.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor
public enum FileTypeEnum {

    BMP("BMP"),

    PNG("PNG"),

    JPEG("JPEG"),

    GIF("GIF"),

    JPG("JPG");

    @Getter
    private String fileType;

    public static FileTypeEnum getFileTypeEnum(String fileType){
        return Stream.of(FileTypeEnum.values())
                .filter(fileTypeEnum -> fileTypeEnum.getFileType().equalsIgnoreCase(fileType))
                .findFirst()
                .get();
    }
}
