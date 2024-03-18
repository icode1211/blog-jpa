package com.estsoft.blogjpa.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FilterTestController {
    @GetMapping("/filter/test")
    public void test(HttpServletRequest request) {
        String traceId = (String) request.getAttribute("traceId");
        log.info(traceId);
    }
}
