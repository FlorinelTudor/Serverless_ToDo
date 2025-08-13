package handlers;

import java.util.Map;
import java.util.UUID;

public class handlers_CreateTodoHandler_Version2 {
    private final String TODO_TABLE = System.getenv("TODO_TABLE");
    private final String QUEUE_URL = System.getenv("QUEUE_URL");

    public handlers_ApiGatewayResponse_Version2 handleRequest(Map<String, Object> event) {
        try {
            String body = (String) event.get("body");
            // Simple JSON parsing - assuming body is like {"task":"value"}
            String task = extractTaskFromBody(body);

            String id = UUID.randomUUID().toString();
            String createdAt = java.time.Instant.now().toString();

            // TODO: Add DynamoDB and SQS operations when dependencies are available
            System.out.println("Creating todo: " + task + " with id: " + id);

            return handlers_ApiGatewayResponse_Version2.builder()
                    .setStatusCode(201)
                    .setRawBody("{\"id\":\"" + id + "\",\"task\":\"" + task + "\",\"status\":\"PENDING\"}")
                    .build();
        } catch (Exception e) {
            return handlers_ApiGatewayResponse_Version2.builder()
                    .setStatusCode(500)
                    .setRawBody("Error: " + e.getMessage())
                    .build();
        }
    }

    private String extractTaskFromBody(String body) {
        // Simple extraction - assumes {"task":"value"}
        if (body != null && body.contains("task")) {
            int start = body.indexOf(":") + 2;
            int end = body.lastIndexOf("\"");
            if (start > 1 && end > start) {
                return body.substring(start, end);
            }
        }
        return "default task";
    }
}