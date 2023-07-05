package org.example.controllers;

import org.example.entities.Document;
import org.example.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/documents")
    public class DocumentController {
        private DocumentService documentService;

        @Autowired
        public DocumentController(DocumentService documentService) {
            this.documentService = documentService;
        }

        @PostMapping
        public ResponseEntity<Document> createDocument(@RequestBody Document document) {
            Document createdDocument = documentService.createDocument(document);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
            Document document = documentService.getDocumentById(id);
            return ResponseEntity.ok(document);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
            documentService.deleteDocument(id);
            return ResponseEntity.noContent().build();
        }

        // Autres endpoints pour la gestion des documents
    }



