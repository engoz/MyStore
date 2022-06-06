package com.eng.app.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "petclinic")
public class PetClinicProperties {

    private long period;
    private boolean displayOwnersWithPets = false;
    private List<String> adminRoles = new ArrayList<>();
    private FileTransfer fileTransfer = new FileTransfer();

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public List<String> getAdminRoles() {
        return adminRoles;
    }

    public void setAdminRoles(List<String> adminRoles) {
        this.adminRoles = adminRoles;
    }

    public FileTransfer getFileTransfer() {
        return fileTransfer;
    }

    public void setFileTransfer(FileTransfer fileTransfer) {
        this.fileTransfer = fileTransfer;
    }

    public boolean isDisplayOwnersWithPets() {
        return displayOwnersWithPets;
    }

    public void setDisplayOwnersWithPets(boolean displayOwnersWithPets) {
        this.displayOwnersWithPets = displayOwnersWithPets;
    }

    public class FileTransfer {
        private boolean enabled;
        private String downloadPath;
        private String uploadPath;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDownloadPath() {
            return downloadPath;
        }

        public void setDownloadPath(String downloadPath) {
            this.downloadPath = downloadPath;
        }

        public String getUploadPath() {
            return uploadPath;
        }

        public void setUploadPath(String uploadPath) {
            this.uploadPath = uploadPath;
        }
    }
}
