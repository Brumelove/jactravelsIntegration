package com.travelbeta.jacktravels.service.searchapi.entity;

import lombok.Data;
import com.travelbeta.jacktravels.service.searchapi.enums.FileTypeEnum;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "image")
public class ImageEntity extends AbstractPersistable<Long> {

    private String name;

    private byte[] data;

    private Long sizeInKb;

    private String externalReferencePath;

    @Enumerated(EnumType.STRING)
    private FileTypeEnum type;

    private byte[] thumbnail;

    private String fileName;

    private String imageURL;

    private Long legacyRecordId;
}
