package com.redirectserviceproject.redirectservice.service;

import com.redirectserviceproject.redirectservice.dto.LongUrlDto;
import com.redirectserviceproject.redirectservice.dto.ShortUrlDto;
import com.redirectserviceproject.redirectservice.entity.Url;
import java.util.List;

public interface UrlService {

    List<Url> getAllUrls();

    Url createUrl(LongUrlDto longUrlDto);

    Url getUrl(Long id);

    void deleteUrl(Long id);

    ShortUrlDto createShortUrlDto(LongUrlDto longUrlDto);

}
