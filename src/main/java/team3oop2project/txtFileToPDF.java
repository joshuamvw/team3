package team3oop2project;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class txtFileToPDF {

    public static void convertTextToPdf(String txtFile, String pdfFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(txtFile));
             PDDocument pdf = new PDDocument()) {

            PDPage page = new PDPage();
            PDPageTree pages = pdf.getPages();
            pages.add(page);

            PDPageContentStream contentStream = new PDPageContentStream(pdf, page);

            PDFont font = PDFont.TIMES_ROMAN;

            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(50, 700);

            String line;
            while ((line = reader.readLine()) != null) {
                contentStream.showText(line);
                contentStream.newLine();
            }

            contentStream.close();

            pdf.save(pdfFile);
        }
    }
}



/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class txtFileToPDF {
    
    String txtFile;
    String pdfFile = "FeedbackFile";

    public static void convertTextToPdf(String txtFile, String pdfFile) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(txtFile));
            PDDocument pdf = new PDDocument()) {

            PDPage page = new PDPage();
            PDPageTree pages = pdf.getPages();
            pages.add(page);

            PDPageContentStream contentStream = new PDPageContentStream(pdf, page);
            
            PDFont font = PDType1Font.TIMES_ROMAN;

            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(50, 700);

            String line;
            while ((line = reader.readLine()) != null) {
                contentStream.showText(line);
                contentStream.newLine();
            }
            

            contentStream.close();
            

            pdf.save(pdfFile);
        }
    }
}*/