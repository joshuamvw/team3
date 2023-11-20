package team3oop2project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

/**
 * The purpose of this class is to facilitate the conversion of a text file to a PDF
 * @author shainahK
 * @version 1.0.0
 */
public class TxtFileToPDF {


/**
 * This is the method responsible for the conversion from text to PDF. 
 * @param txtFilePath path to the text file you want to act as the source
 * @param pdfPath path to the PDF file you want to create
 * @throws IOException error thrown if the source text file is not found
 */
    public void convertTextToPdf(String txtFilePath, String pdfPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
             PDDocument pdf = new PDDocument()) {

            PDPage page = new PDPage();
            pdf.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(pdf, page);
            
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
            // No need to specify the font, it will use the default font
            
            
            contentStream.beginText();
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(50, 700);

            String line;
            while ((line = reader.readLine()) != null) {
                contentStream.showText(line);
                
                contentStream.newLine();
            }

            contentStream.endText();
            contentStream.close();

            String pdfFile = pdfPath;

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