
package modelagem;

//bibliotecas
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Seta {
    private int x, y; // posição da nave
    
    private Image imagem; // imagem da nave
    private int altura, largura; // tamanho da imagem da nave
    private int start=0;
    private boolean isVisivel;

    // Construtor para que ao ser inicializado o player esteja no centro da tela e a
    // lista de tiros seja inicializada
    public Seta() {
        this.x = 430;
        this.y = 450;
        isVisivel = true;

    }
    public int getStart() {
    	return this.start;
    }
    // Pegando todos os dados da imagem do player
    public void load() {
        ImageIcon referencia = new ImageIcon("imgs2\\mouseNave.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

   
    public void entrarJogo(){
    	start=1;
    }

   


    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

      System.out.print("telcadododood");

        if (codigo == KeyEvent.VK_UP) {
        	System.out.println("subiu");
         this.y=450;
        }
        if (codigo == KeyEvent.VK_DOWN) {
        	System.out.println("desceu");
        	this.y=550;
        }
        if(codigo==KeyEvent.VK_ENTER && this.y==450) {
        	entrarJogo();
        }
        if(codigo==KeyEvent.VK_ENTER && this.y==550) {
        	
        }

       
    }
    public void keyReleased(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

      System.out.print("telcadododood");

        if (codigo == KeyEvent.VK_UP) {
        	System.out.print("subiu");
         this.y=0;
        }
        if (codigo == KeyEvent.VK_DOWN) {
        	System.out.print("desceu");
        	this.y=0;
        }

       
    }
        
//    // Método para verificar quando a' tecla foi solta, ou o player continuaria
//    // seguindo infinitamente nas direções que foram inicialmente escolhidas
//    public void keyReleased(KeyEvent tecla) {
//        int codigo = tecla.getKeyCode();
//
//        if (codigo == KeyEvent.VK_UP) {
//            dy = 0;
//        }
//
//        if (codigo == KeyEvent.VK_DOWN) {
//            dy = 0;
//        }
//
//        if (codigo == KeyEvent.VK_LEFT) {
//            dx = 0;
//        }
//
//        if (codigo == KeyEvent.VK_RIGHT) {
//            dx = 0;
//        }

   

    // Getters and Setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

   

   

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

	

    
}
