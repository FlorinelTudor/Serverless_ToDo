package handlers;

import java.util.Collections;
import java.util.Map;

public class handlers_ApiGatewayResponse_Version2 {
    private int statusCode;
    private String body;
    private Map<String, String> headers;

    public handlers_ApiGatewayResponse_Version2() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int statusCode = 200;
        private String body = "";
        private Map<String, String> headers = Collections.singletonMap("Content-Type", "application/json");

        public Builder setStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder setRawBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setObjectBody(Object obj) {
            this.body = obj != null ? obj.toString() : "{}";
            return this;
        }

        public Builder setHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public handlers_ApiGatewayResponse_Version2 build() {
            handlers_ApiGatewayResponse_Version2 r = new handlers_ApiGatewayResponse_Version2();
            r.statusCode = this.statusCode;
            r.body = this.body;
            r.headers = this.headers;
            return r;
        }
    }

    // Getters (for Lambda serialization)
    public int getStatusCode() { return statusCode; }
    public String getBody() { return body; }
    public Map<String, String> getHeaders() { return headers; }
}