package com.eng.app.files;

import com.eng.app.files.inf.FileTransferInf;
import com.eng.app.props.PetClinicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileTransferManagement implements FileTransferInf {
    @Autowired
    PetClinicProperties petClinicProperties;

    @Override
    public void download() {
        System.out.println(petClinicProperties.getFileTransfer().getDownloadPath());
    }

    @Override
    public void upload() {
        System.out.println(petClinicProperties.getFileTransfer().getUploadPath());
    }

}
