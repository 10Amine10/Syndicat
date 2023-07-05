package org.example.mappers;

import org.example.entities.Document;
import org.example.models.DocumentDto;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {
    public DocumentDto toDtop(Document document) {
        DocumentDto documentDto = new DocumentDto();
        document.setId(document.getId());
        documentDto.setNom(document.getNom());
        documentDto.setDescription(document.getDescription());
        documentDto.setDateCreation(document.getDateCreation());
        return documentDto;

    }
    public Document toEntity(DocumentDto documentDto) {
        Document document = new Document();
        document.setId(documentDto.getId());
        document.setNom(documentDto.getNom());
        document.setDescription(document.getDescription());
        document.setDateCreation(document.getDateCreation());
    return document;
    }

}
