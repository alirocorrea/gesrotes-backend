package com.unicauca.gesrotes.service;

public interface StorageService {

    byte[] getFile(String uuid);

    String saveFile(byte[] contentFile);
}