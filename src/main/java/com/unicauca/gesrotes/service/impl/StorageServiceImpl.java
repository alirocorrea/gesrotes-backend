package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class StorageServiceImpl implements StorageService {

    @Value("${storage.url}")
    private String storageURL;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public byte[] getFile(final String uuid) {
        try {
            ResponseEntity<byte[]> response = requestGetFile(uuid);
            return response.getBody();
        } catch (Exception e) {
            return new byte[0];
        }
    }

    @Override
    public String saveFile(final byte[] contentFile) {
        try {
            final String uuid = UUID.randomUUID().toString();
            requestSaveFile(uuid, contentFile);
            return uuid;
        }catch (Exception e) {
            return null;
        }
    }

    private ResponseEntity<byte[]> requestGetFile(final String uuid) {
        final String url = this.storageURL.concat(uuid);
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                byte[].class
        );
	}

    private void requestSaveFile(final String uuid, final byte[] contentFile) {
        final String url = this.storageURL.concat(uuid);
        restTemplate.exchange(
            url,
            HttpMethod.PUT,
            new HttpEntity<>(contentFile),
            Void.class
        );
	}
}
