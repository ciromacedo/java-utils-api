package org.macedo.utils.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public abstract class BaseController<T> {


    protected ResponseEntity<T> responderOk(T body) {
        return ResponseEntity.ok(body);
    }


    protected ResponseEntity<T> responderCriado(String path, Long id, T body, UriComponentsBuilder uriBuilder) {
        URI uri = uriBuilder.path(path).buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(body);
    }

    protected ResponseEntity<Void> responderNoContent() {
        return ResponseEntity.noContent().build();
    }
}
