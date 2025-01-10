package dev.langchain4j.quarkus.workshop;

import jakarta.enterprise.context.SessionScoped;

import dev.langchain4j.service.SystemMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.ToolBox;
import io.quarkiverse.langchain4j.guardrails.InputGuardrails;

@SessionScoped
@RegisterAiService
public interface CustomerSupportAgent {

    @SystemMessage("""
            You are a customer support agent of a car rental company 'Miles of Smiles'.
            Today is {current_date}.
            """)
    @InputGuardrails(PromptInjectionGuard.class)
    @ToolBox(BookingRepository.class)
    String chat(String userMessage);
}
