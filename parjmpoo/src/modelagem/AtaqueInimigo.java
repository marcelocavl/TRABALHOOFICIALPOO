package modelagem;

//Bibliotecas
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class AtaqueInimigo {
    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisible;
    private static int VELOCIDADE = 8;
    private ImageIcon referencia =  new ImageIcon("imagens//ataqueInimigoRosa.png");

    public AtaqueInimigo(int x, int y) {
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    public void dadosImagem() {
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void movimenta(String tipo) {
        if (tipo == "rosa") {
            referencia = new ImageIcon("imagens//ataqueInimigoRosa.png");
            this.y += VELOCIDADE;
        }
        if (tipo == "verde"){
            referencia = new ImageIcon("imagens//ataqueInimigoVerde.png");
            this.x += VELOCIDADE - 2;
            this.y += 2;
            
        }
        if(tipo == "laranjaD"){
            referencia = new ImageIcon("imagens//ataqueInimigoLaranjaD.png");
            this.x += VELOCIDADE - 2;
            this.y -=  2;
        }
        if(tipo == "laranjaE"){
            referencia = new ImageIcon("imagens//ataqueInimigoLaranjaE.png");
            this.x -= VELOCIDADE - 2;
            this.y -= 2;
        }

    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public Rectangle getLimites() {
        return new Rectangle(x, y, largura, altura);
    }
}
