# Craft intelligent application with Quarkus/LangChain4j on OpenShift/AI

Welcome to the Craft intelligent application with Quarkus/LangChain4j on OpenShift/AI! 
This workshop is designed to help you get started with AI-Infused applications using Quarkus and LangChain4j.
It is based on https://cescoffier.github.io/quarkus-langchain4j-workshop/ but is adjusted so that it works with models served by OpenShift AI.

You are going to learn about:

- How to integrate LLMs (Language Models) in your Quarkus application
- How to build a chatbot using Quarkus
- How to configure and how to pass prompts to the LLM
- How to build agentic systems
- How to build simple and advanced RAG (Retrieval-Augmented Generation) patterns

![Quarkus LangChain4j Workshop](images/global-architecture.png)


## Workshop Structure

During this workshop we will create an LLM-powered customer support agent chatbot for a car rental company.
The workshop is divided into 8 steps.
Each step builds on the previous one, adding new features and functionality.

We start from the base functionality (step 1) and add features in the subsequent steps.
The result after each step is located in a separate directory (`step-XX`).
The final solution is in the `step-07` directory.

We recommend to start by checking out the _main_ branch and then opening the project from `step-01` in your IDE and using that directory throughout the workshop.
The other option is to make a copy of it.
If you later need to reset to a particular step, either overwrite your working directory with the directory for the step you want to reset to, or, in your IDE, open the project from the step directory you want to reset to.

## Let's get started!

Go to the [requirements](./requirements.md) page to prepare for the workshop.
Once ready, you can start with [Step 1](./step-01.md).
