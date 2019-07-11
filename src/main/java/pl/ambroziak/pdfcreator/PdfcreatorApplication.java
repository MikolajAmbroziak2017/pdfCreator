package pl.ambroziak.pdfcreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfcreatorApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PdfcreatorApplication.class, args);
        test();
    }
    public static void test() throws Exception {
        // TEST DATA
        String dataXmlPath = "C:\\Users\\DELL\\Desktop\\Projekt_pdf\\test.xml";
        String xslFilePath = "C:\\Users\\DELL\\Desktop\\Projekt_pdf\\test.xsl";
        String path = "C:\\Users\\DELL\\Desktop\\Projekt_pdf\\";
        PDFCreator pdfCreator = new PDFCreator();
        pdfCreator.convertToPDF(dataXmlPath, xslFilePath, path);
    }
}
