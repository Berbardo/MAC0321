import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//PDFBox
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

public class CriadorDePDF {
	PDDocument pdf;

	CriadorDePDF() {
		pdf = new PDDocument();
	}
	
	void criaPDF() {		
		try {
			pdf.save("./receitas/Receituario.pdf");
			
			PDDocumentInformation info = pdf.getDocumentInformation();
			info.setTitle("Receituario Galactico");
			
			PDPage capa = new PDPage();
			pdf.addPage(capa);
			PDRectangle mediaBox = capa.getMediaBox();
			
			PDPageContentStream contentStream = new PDPageContentStream(pdf, capa);
			
			PDType0Font font = PDType0Font.load(pdf, new File("C:/Windows/Fonts/arial.ttf"));
			
			float titleWidth = font.getStringWidth("Receituario") / 1000 * 36;
			float startX = (mediaBox.getWidth() - titleWidth) / 2;
			float startY = mediaBox.getHeight() /2;
			
			contentStream.beginText();
			contentStream.setFont(font, 36);
			contentStream.setLeading(50f);
			contentStream.newLineAtOffset(startX, startY);
			contentStream.showText("Receituario");
			contentStream.newLine();
			contentStream.showText("Galactico");
			contentStream.endText();
			contentStream.close();
			
			pdf.save("./receitas/Receituario.pdf");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	void adicionaReceitaPDF(String caminho) {
		try {
			char[] arquivo = new char[8192];
			InputStreamReader leitor = new InputStreamReader(new FileInputStream(caminho), "UTF8");
			leitor.read(arquivo);
			String texto = new String(arquivo);
		
			PDPage receita = new PDPage();
		
			pdf.addPage(receita);
			
			PDPageContentStream titleStream = new PDPageContentStream(pdf, receita);
			
			titleStream.beginText();			
			String titulo = caminho.substring(caminho.lastIndexOf('\\') + 1, caminho.lastIndexOf('.')).toUpperCase();
			PDType0Font font = PDType0Font.load(pdf, new File("C:/Windows/Fonts/arial.ttf"));
			titleStream.setFont(font, 25);
			PDRectangle mediaBox = receita.getMediaBox();
			float titleWidth = font.getStringWidth(titulo) / 1000 * 25;
			float startX = (mediaBox.getWidth() - titleWidth) / 2;
			titleStream.newLineAtOffset(startX, 725);
			titleStream.showText(titulo);
			titleStream.endText();
			titleStream.close();
		
			PDPageContentStream contentStream = new PDPageContentStream(pdf, receita, PDPageContentStream.AppendMode.APPEND, true);
			
			contentStream.beginText();
			
			contentStream.setFont(font, 11 );
			contentStream.setLeading(14.5f);
			contentStream.newLineAtOffset(25, 670);
			
			String[] linhas = texto.split(System.getProperty("line.separator"));
			for(String linha: linhas) {
				linha = removeCaracteres(linha);
				// Line Break
				while (linha.length() > 100) {
					contentStream.showText(linha.substring(0, linha.lastIndexOf(' ', 110)));
					linha = linha.substring(linha.lastIndexOf(' ', 110));
					contentStream.newLine();
				}
				contentStream.showText(linha);
				contentStream.newLine();
			}
			contentStream.endText();
			
			contentStream.close();
			
			pdf.save("./receitas/Receituario.pdf");
			
			leitor.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	void terminaPDF() {
		try {
			pdf.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
    public static String removeCaracteres(String texto) {
        StringBuilder novo = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            if (WinAnsiEncoding.INSTANCE.contains(texto.charAt(i))) {
            	novo.append(texto.charAt(i));
            }
        }
        return novo.toString();
    }
}
