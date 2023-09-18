package ar.modularsoft.redsys.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadPDFAsStream {
    public static void main(String[] args) {
        String pdfPath = "path_to_your_pdf.pdf";
        int chunkSize = 1000;  // Adjust the chunk size as needed

        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            Iterator<String> iterator = new ChunkIterator(pdfTextStripper, document, chunkSize);

            while (iterator.hasNext()) {
                String chunk = iterator.next();
                System.out.println(chunk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ChunkIterator implements Iterator<String> {
    private PDFTextStripper textStripper;
    private PDDocument document;
    private int chunkSize;
    private int currentPage = 0;
    private boolean hasMoreChunks = true;

    public ChunkIterator(PDFTextStripper textStripper, PDDocument document, int chunkSize) {
        this.textStripper = textStripper;
        this.document = document;
        this.chunkSize = chunkSize;
    }

    @Override
    public boolean hasNext() {
        return hasMoreChunks;
    }

    @Override
    public String next() {
        try {
            textStripper.setStartPage(currentPage + 1);
            textStripper.setEndPage(currentPage + 1);
            String chunk = textStripper.getText(document).trim();
            currentPage++;
            if (chunk.isEmpty()) {
                hasMoreChunks = false;
            }
            return chunk;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
