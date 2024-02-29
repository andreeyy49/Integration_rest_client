package com.example.integrationclient_5_2.controller;

import com.example.integrationclient_5_2.clients.OkHttpClientSender;
import com.example.integrationclient_5_2.clients.OpenFeignClient;
import com.example.integrationclient_5_2.clients.RestTemplateClient;
import com.example.integrationclient_5_2.clients.WebClientSender;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/client/file")
@RequiredArgsConstructor
public class FileClientController {

    private final OpenFeignClient client;

    @PostMapping("/upload")
    private ResponseEntity<String> uploadFile(@RequestPart MultipartFile file) {
        client.uploadFile(file);

        return ResponseEntity.ok("File was upload");
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource resource = client.downloadFile(filename);

        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
        headers.setContentType(MediaType.TEXT_PLAIN);

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
