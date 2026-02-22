package com.example.demo.service;

import com.vladsch.flexmark.docx.converter.DocxRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.ext.tables.TablesExtension; // <--- IMPORT THIS
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays; // <--- IMPORT THIS

public class MarkdownToWordConverter {

    public static void main(String[] args) {
        String markdownFilePath = "C:/Karthik/LEARNING/Design Patterns/Design_patterns.md";

        Path inputPath = Paths.get(markdownFilePath);
        String outputFileName = inputPath.getFileName().toString().replace(".md", ".docx");
        Path outputPath = inputPath.getParent().resolve(outputFileName);

        System.out.println("Input Markdown file: " + inputPath);
        System.out.println("Output Word file:    " + outputPath);

        try {
            // --- CONFIGURE THE PARSER AND RENDERER ---
            MutableDataSet options = new MutableDataSet();
            
            // --- THIS IS THE CRUCIAL CHANGE ---
            // Tell the parser to recognize GitHub-style tables
            options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
            // --- END OF CHANGE ---

            Parser parser = Parser.builder(options).build();
            DocxRenderer renderer = DocxRenderer.builder(options).build();

            System.out.println("\nReading and parsing Markdown file...");
            String markdownContent = new String(Files.readAllBytes(inputPath));
            Node document = parser.parse(markdownContent);
            
            System.out.println("Creating an in-memory Word document...");
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

            System.out.println("Rendering content into the document...");
            renderer.render(document, wordMLPackage);

            System.out.println("Saving the document to disk...");
            wordMLPackage.save(outputPath.toFile());

            System.out.println("\nConversion successful!");
            System.out.println("File saved to: " + outputPath);

        } catch (IOException | Docx4JException e) {
            System.err.println("\n--- An error occurred ---");
            e.printStackTrace();
        }
    }
}
