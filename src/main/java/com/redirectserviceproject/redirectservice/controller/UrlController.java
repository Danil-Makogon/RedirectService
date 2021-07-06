package com.redirectserviceproject.redirectservice.controller;

import com.redirectserviceproject.redirectservice.dto.LongUrlDto;
import com.redirectserviceproject.redirectservice.dto.ShortUrlDto;
import com.redirectserviceproject.redirectservice.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/urls")
    public ResponseEntity<ShortUrlDto> createShortUrlDto(@Valid @RequestBody LongUrlDto longUrlDto) {

        return new ResponseEntity<>(urlService.createShortUrlDto(longUrlDto), HttpStatus.OK);
    }

    @DeleteMapping("/urls/{id}")
    public String deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);

        return "Url with id " + id + " was deleted.";
    }
}
