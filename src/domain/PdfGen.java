/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package domain;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDCIDFontType2;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;

import java.io.IOException;



public class PdfGen {
    static String sellername ="Garage Michel";
    static String selleraddress="22, rue de la Paix";
    static String sellercity = "00000 Ville, Pays";
    static String sellerphone = "+33 5 12 34 56 78";
    static String customername="Michel Dupont";
    static String customeraddress="31, Rue de la Paix";
    static String customercity = "00000 Ville, Pays";
    static int siret=123456789;
    static int phone=123456789;


    static String dateSale="01/01/2020";
    static String dateExpiry="01/02/2020";
    static String invoiceId="123456";

    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        try {
            // Créez une page dans le document
            PDPage page = new PDPage();
            document.addPage(page);
            // Créez un contexte de dessin pour la page
            PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true);
            try {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 15);
                contentStream.newLineAtOffset(50, 733);
                contentStream.showText(sellername);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(50, 733);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText(selleraddress);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText(sellercity);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Téléphone :"+ sellerphone);
                contentStream.newLineAtOffset(0, -70);
                contentStream.showText("Client :");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText(customername);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText(customeraddress);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText(customercity);
                contentStream.endText();


            } finally {
                // Fermez le contexte de dessin
                contentStream.close();
            }

            // Enregistrez le document PDF
            document.save("document.pdf");
        } finally {
            // Fermez le document
            document.close();
        }


    }
}
