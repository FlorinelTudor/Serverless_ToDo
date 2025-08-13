package handlers;

import java.util.List;
import java.util.Map;

public class handlers_ProcessTodoHandler_Version2 {
    private final String TODO_TABLE = System.getenv("TODO_TABLE");

    public String handleRequest(List<Map<String, Object>> messages) {
        for (Map<String, Object> message : messages) {
            try {
                String body = (String) message.get("body");
                String id = extractIdFromBody(body);
                
                // TODO: Add DynamoDB update operation when dependencies are available
                System.out.println("Processing todo with id: " + id + " - marking as COMPLETED");
                
            } catch (Exception e) {
                System.err.println("Error processing message: " + e.getMessage());
            }
        }
        return "OK";
    }
    
    private String extractIdFromBody(String body) {
        // Simple extraction - assumes {"id":"value"}
        if (body != null && body.contains("id")) {
            int start = body.indexOf(":") + 2;
            int end = body.indexOf(",") > 0 ? body.indexOf(",") - 1 : body.lastIndexOf("\"")-1;
            if (start > 1 && end > start) {
                return body.substring(start, end+1);
            }
        }
        return "unknown";
    }
}