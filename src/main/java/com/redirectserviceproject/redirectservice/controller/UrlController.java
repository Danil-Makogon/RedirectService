package com.redirectserviceproject.redirectservice.controller;

import com.redirectserviceproject.redirectservice.exceptions.NotFoundException;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("redirectService")
public class UrlController {
    private int counter = 4;
    private List<Map<String,String>> urls = new ArrayList<Map<String, String>>(){{
        add(new HashMap<String, String>() {{put("id", "1"); put("url", "https://en.wikipedia.org/wiki/English_Wikipedia");}});
        add(new HashMap<String, String>() {{put("id", "2"); put("url", "https://habr.com/ru/flows/develop/news/");}});
        add(new HashMap<String, String>() {{put("id", "3"); put("url", "https://spring.io/guides/tutorials/rest/");}});
    }};

    @GetMapping
    public List<Map<String,String>> list(){
        return urls;
    }

    @GetMapping("{id}")
    public Map<String,String> getUrl(@PathVariable String id){
        return urls.stream()
                .filter(url -> url.get(id).equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String,String> url){
        url.put("id",String.valueOf(counter++));
        urls.add(url);
        return url;
    }
}



