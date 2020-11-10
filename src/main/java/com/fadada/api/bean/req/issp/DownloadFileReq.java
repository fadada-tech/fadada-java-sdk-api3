package com.fadada.api.bean.req.issp;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

import java.util.List;


@ParamsVerif

public class DownloadFileReq extends BaseBean {
    @ParamsVerif(minLength = 1)
    private List<FileInfo> fileInfos;

    @ParamsVerif
    public static class FileInfo {
        /**
         * 文件uuid
         */
        @ParamsVerif(checkNotEmpty = true)
        private String fileUuid;
        /**
         * 1文件，2附件
         */
        @ParamsVerif(intContains = {1, 2})
        private Integer fileType;

        @ParamsVerif(checkNotEmpty = true)
        private String fileName;

        public String getFileUuid() {
            return fileUuid;
        }

        public void setFileUuid(String fileUuid) {
            this.fileUuid = fileUuid;
        }

        public Integer getFileType() {
            return fileType;
        }

        public void setFileType(Integer fileType) {
            this.fileType = fileType;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }

    public List<FileInfo> getFileInfos() {
        return fileInfos;
    }

    public void setFileInfos(List<FileInfo> fileInfos) {
        this.fileInfos = fileInfos;
    }
}
