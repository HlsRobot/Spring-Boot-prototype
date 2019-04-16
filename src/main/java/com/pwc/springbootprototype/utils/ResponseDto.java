package com.pwc.springbootprototype.utils;

import java.util.Map;

public class ResponseDto {
    private int httpStatus;
    private Object body;
    private Map<String, String> violations;

    public ResponseDto(final int httpStatus, final Object body, final Map<String, String> violations) {
        this.httpStatus = httpStatus;
        this.body = body;
        this.violations = violations;
    }

    public ResponseDto() {
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }

    public Object getBody() {
        return this.body;
    }

    public Map<String, String> getViolations() {
        return this.violations;
    }

    public static class Builder {
        private int httpStatus;
        private Object body;
        private Map<String, String> violations;

        public Builder httpStatus(final int httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public Builder body(final Object body) {
            this.body = body;
            return this;
        }

        public Builder violations(final Map<String, String> violations) {
            this.violations = violations;
            return this;
        }

        public ResponseDto build() {
            return new ResponseDto(this.httpStatus, this.body, this.violations);
        }
    }
}
