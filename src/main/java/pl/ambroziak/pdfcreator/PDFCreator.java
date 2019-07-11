package pl.ambroziak.pdfcreator;
/**
 *   <dependency>
 *             <groupId>org.apache</groupId>
 *             <artifactId>fop</artifactId>
 *             <version>${version.filenet}</version>
 *             <scope>system</scope>
 *             <systemPath>${basedir}/libs/fop.jar</systemPath>
 *         </dependency>
 */

import org.apache.fop.apps.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class PDFCreator {
    public void convertToPDF(String dataXml, String viewXsl,String path) throws IOException, FOPException, TransformerException {
        File xslFile = new File(viewXsl);
        StreamSource xmlSource = new StreamSource(new File(dataXml));
        FopFactory fopFactory=FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        int size=xmlSource.getSystemId().length()-4;
        OutputStream out = new FileOutputStream(xmlSource.getSystemId().substring(6,size)+".pdf");
        try {
            //MIME_PDF is a type of creating document "application/pdf"
            Fop fop = fopFactory.newFop("application/pdf", foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xslFile));
            Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }
}
