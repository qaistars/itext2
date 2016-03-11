package com.lowagie.text.pdf;

import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;

public class MetaDataTest {

    @Test
    public void testProducer() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();

        PdfWriter.getInstance(document, baos);
        document.open();
        document.add(new Paragraph("Hello World"));
        document.close();
        
        PdfReader r = new PdfReader(baos.toByteArray());

        // with this special version, metadata is not generated by default
        Assert.assertNull(r.getInfo().get("Producer"));
    }
    


}
