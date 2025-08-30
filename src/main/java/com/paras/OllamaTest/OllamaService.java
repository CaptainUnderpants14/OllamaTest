package com.paras.OllamaTest;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OllamaService {

    @Autowired
    private OllamaChatModel ollamaChatModel;

    public String getResponse(String prompt) {
        return ollamaChatModel.call(prompt);
    }
}
