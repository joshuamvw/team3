import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import java.io.IOException;

public class WriteToPDF {
    public static void main(String[] args) {
        try {
            // Create a new document
            PDDocument document = new PDDocument();

            // Add a page to the document
            PDPage page = new PDPage();
            document.addPage(page);

            // Create a content stream for writing into the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set the font and font size
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // Set the starting position for the text
            float startX = 50;
            float startY = page.getMediaBox().getHeight() - 50;

            // Write some text into the page
            contentStream.beginText();
            contentStream.newLineAtOffset(startX, startY);
            contentStream.showText("Hello, PDFBox!");
            contentStream.endText();

            // Close the content stream
            contentStream.close();

            // Save the document to a file
            document.save("output.pdf");

            // Close the document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}