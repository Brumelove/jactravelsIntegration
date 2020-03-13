package com.travelbeta.jactravels.service.search_api.entity;

import com.travelbeta.jactravels.service.enums.FileTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data @EqualsAndHashCode(callSuper = false)
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "Image")
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
