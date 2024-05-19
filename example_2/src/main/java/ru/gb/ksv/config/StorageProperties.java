package ru.gb.ksv.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@ConfigurationProperties("storage")
@Getter
@Setter
public class StorageProperties {
    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";
}
