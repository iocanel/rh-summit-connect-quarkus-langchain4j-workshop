package dev.langchain4j.quarkus.workshop;

import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterAiService
public interface CustomerSupportAgent {

    String chat(String userMessage);
}
