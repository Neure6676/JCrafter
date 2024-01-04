package net.zhenyuan.enums;

import lombok.Getter;

public enum BizCodeEnum {
    /**
     * file related
     */
    FILE_REMOTE_DOWNLOAD_FAILED(220404,"Failed to download remote files"),
    FILE_REMOTE_READ_FAILED(220403,"Failed to read remote files"),
    FILE_REMOTE_UPLOAD_FAILED(220407,"Failed to upload remote files"),
    FILE_REMOTE_UPLOAD_IS_EMPTY(220408,"Empty file"),
    FILE_PRE_SIGNED_FAILED(220409,"Failed to generate temp URL"),
    FILE_CREATE_TEMP_FAILED(220411,"Failed to generate temp file"),

    /**
     * stress test related
     */
    STRESS_MODULE_ID_NOT_EXIST(260001,"Model ID doesn't exist"),
    STRESS_CASE_ID_NOT_EXIST(260002,"Use case ID doesn't exist"),
    STRESS_UNSUPPORTED(260005,"Unsupported type"),
    STRESS_ASSERTION_UNSUPPORTED_ACTION(260007, "Unsupported assertion"),
    STRESS_ASSERTION_UNSUPPORTED_FROM(260008, "Unsupported assertion source");

    @Getter
    private String message;

    @Getter
    private int code;

    private BizCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }
}
