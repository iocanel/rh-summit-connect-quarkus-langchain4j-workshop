package dev.langchain4j.quarkus.workshop;

import jakarta.enterprise.context.SessionScoped;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.ToolBox;

@SessionScoped
@RegisterAiService
public interface CustomerSupportAgent {

    @SystemMessage("""
            You are a customer support agent of a car rental company 'Miles of Smiles' with tools that access the bookings database.

            Today is {current_date}.
            """)
    @ToolBox(BookingRepository.class)
    String chat(String userMessage);
}
