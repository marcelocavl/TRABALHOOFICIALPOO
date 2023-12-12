package modelagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
    private List<EstrelaBranca> EstrelaBranca;
    private List<EstrelaRosa> EstrelaRosa;
    private List<EstrelaAmarela> EstrelaAmarela;
    private List<EstrelaAzul> EstrelaAzul;
    private Image fundoFase;
    private Timer timer;
    private boolean emJogo;
    private int vidaPlayer = 8;

    private Player player;
    private List<InimigoAzul> inimigoAzul;
    private List<InimigoVerde> inimigoVerde;
    private List<InimigoRosa> inimigoRosa;
    private List<InimigoLaranja> inimigoLaranja;
    private List<Meteoro> meteoros;
    private List<Asteroide> asteroides;

    private int abateInimigos = 0;
    private int pontuacaoTotal = 0;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon referencia = new ImageIcon("imagens//fundoJogo.png");
        fundoFase = referencia.getImage();
        emJogo = true;
        addKeyListener(new TecladoAdapter());
        timer = new Timer(10, this);
        timer.start();

        player = new Player();
        player.dadosImagem();

        inicializaEstrela();
        inicializaInimigosVerde();
        inicializaInimigosAzuis();
        inicializaInimigosRosa();
        inicializaInimigosLaranja();
        inicializaMeteoros();
        inicializaAsteroides();

    }
    
    public void inicializaInimigosAzuis() {
        int quantidade[] = new int[5];
        inimigoAzul = new ArrayList<InimigoAzul>();

        for (int i = 0; i < quantidade.length; i++) {
            int x = (int) (Math.random() * -1500 + 1400);
            int y = (int) (Math.random() * -3500);
            inimigoAzul.add(new InimigoAzul(x, y));
        }
    }

    public void inicializaInimigosLaranja() {
        int quantidade[] = new int[5];
        inimigoLaranja = new ArrayList<InimigoLaranja>();

        for (int i = 0; i < quantidade.length; i++) {
            int x = (int) (Math.random() * -1500 + 1400);
            int y = (int) (Math.random() * -3500);
            inimigoLaranja.add(new InimigoLaranja(x, y));
        }
    }

    public void inicializaInimigosVerde() {
        int quantidade[] = new int[5];
        inimigoVerde = new ArrayList<InimigoVerde>();

        for (int i = 0; i < quantidade.length; i++) {
            int x = (int) (Math.random() * -1500 + 1400);
            int y = (int) (Math.random() * -3500);
            inimigoVerde.add(new InimigoVerde(x, y));
        }
    }

    public void inicializaInimigosRosa() {
        int quantidade[] = new int[5];
        inimigoRosa = new ArrayList<InimigoRosa>();

        for (int i = 0; i < quantidade.length; i++) {
            int x = (int) (Math.random() * -1500 + 1400);
            int y = (int) (Math.random() * -3500);
            inimigoRosa.add(new InimigoRosa(x, y));
        }
    }

    public void inicializaMeteoros() {
        int quantidade[] = new int[5];
        meteoros = new ArrayList<Meteoro>();

        for (int i = 0; i < quantidade.length; i++) {
            int x = (int) (Math.random() * 900 + 1024);
            int y = (int) (Math.random() * -3500);
            meteoros.add(new Meteoro(x, y));
        }
    }

    public void inicializaAsteroides() {
        int quantidade[] = new int[8];
        asteroides = new ArrayList<Asteroide>();

        for (int i = 0; i < quantidade.length; i++) {
            int x = (int) (Math.random() * -1500 + 1000);
            int y = (int) (Math.random() * -3500);
            asteroides.add(new Asteroide(x, y));
        }
    }

    public void inicializaEstrela() {
        int quantidade[] = new int[20];
        EstrelaBranca = new ArrayList<EstrelaBranca>();
        EstrelaRosa = new ArrayList<EstrelaRosa>();
        EstrelaAmarela = new ArrayList<EstrelaAmarela>();
        EstrelaAzul = new ArrayList<EstrelaAzul>();

        for (int i = 0; i < (quantidade.length + 10); i++) {
            int x = (int) (Math.random() * -8000);
            int y = (int) (Math.random() * -4500);
            EstrelaBranca.add(new EstrelaBranca(x, y));
        }

        for (int i = 0; i < quantidade.length; i++) {
            int x = (int) (Math.random() * -8000);
            int y = (int) (Math.random() * -4500);
            EstrelaAzul.add(new EstrelaAzul(x, y));
        }

        for (int j = 0; j < (quantidade.length - 10); j++) {
            int x = (int) (Math.random() * -8000);
            int y = (int) (Math.random() * -4500);
            EstrelaRosa.add(new EstrelaRosa(x, y));
        }

        for (int j = 0; j < quantidade.length; j++) {
            int x = (int) (Math.random() * -8000);
            int y = (int) (Math.random() * -4500);
            EstrelaAmarela.add(new EstrelaAmarela(x, y));
        }
    }

    public int calculaPontuacao() {
        pontuacaoTotal += (abateInimigos * 100);
        return pontuacaoTotal;
    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if (emJogo) {

            graficos.drawImage(fundoFase, 0, 0, null);

            for (int p = 0; p < EstrelaBranca.size(); p++) {
                EstrelaBranca q = EstrelaBranca.get(p);
                q.movimenta();
                graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
            }

            for (int p = 0; p < EstrelaRosa.size(); p++) {
                EstrelaRosa q = EstrelaRosa.get(p);
                q.movimenta();
                graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
            }

            for (int p = 0; p < EstrelaAmarela.size(); p++) {
                EstrelaAmarela q = EstrelaAmarela.get(p);
                q.movimenta();
                graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
            }

            for (int p = 0; p < EstrelaAzul.size(); p++) {
                EstrelaAzul q = EstrelaAzul.get(p);
                q.movimenta();
                graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
            }

            graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

            List<AtaquePlayer> tiros = player.getTiros();

            for (int i = 0; i < tiros.size(); i++) {
                AtaquePlayer m = tiros.get(i);
                m.movimenta();
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
            }

            for (int i = 0; i < inimigoAzul.size(); i++) {
                InimigoAzul in = inimigoAzul.get(i);
                in.movimenta();
                ;
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }

            for (int i = 0; i < inimigoRosa.size(); i++) {
                InimigoRosa b = inimigoRosa.get(i);
                b.dadosImagem();
                b.movimenta();
                ;
                graficos.drawImage(b.getImagem(), b.getX(), b.getY(), this);
            }

            for (int i = 0; i < inimigoVerde.size(); i++) {
                InimigoVerde b = inimigoVerde.get(i);
                b.dadosImagem();
                b.movimenta();
                ;
                graficos.drawImage(b.getImagem(), b.getX(), b.getY(), this);
            }

            for (int i = 0; i < inimigoLaranja.size(); i++) {
                InimigoLaranja b = inimigoLaranja.get(i);
                b.dadosImagem();
                b.movimenta();
                ;
                graficos.drawImage(b.getImagem(), b.getX(), b.getY(), this);
            }

            for (int i = 0; i < meteoros.size(); i++) {
                Meteoro b = meteoros.get(i);
                b.dadosImagem();
                b.movimenta();
                ;
                graficos.drawImage(b.getImagem(), b.getX(), b.getY(), this);
            }

            for (int i = 0; i < asteroides.size(); i++) {
                Asteroide b = asteroides.get(i);
                b.dadosImagem();
                b.movimenta();
                ;
                graficos.drawImage(b.getImagem(), b.getX(), b.getY(), this);
            }
  

        } else {
            ImageIcon fimJogo = new ImageIcon("imagens//gameover.gif");
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }

        g.dispose();
    }

    // atualizar o estado dos objetos do jogo, verificar colisões e solicitar a
    // repintura da tela. É chamado periodicamente pelo Timer para criar uma
    // atualização contínua do jogo.
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(player.getComecaJogo()) {
    		
    		player.movimenta();
    	}

        for (int p = 0; p < EstrelaBranca.size(); p++) {
            EstrelaBranca on = EstrelaBranca.get(p);
            if (on.isVisible()) {
                on.movimenta();
            } else
                EstrelaBranca.remove(p);
        }

        for (int p = 0; p < EstrelaRosa.size(); p++) {
            EstrelaRosa on = EstrelaRosa.get(p);
            if (on.isVisible()) {
                on.movimenta();
            } else
                EstrelaRosa.remove(p);
        }

        for (int p = 0; p < EstrelaAmarela.size(); p++) {
            EstrelaAmarela on = EstrelaAmarela.get(p);
            if (on.isVisible()) {
                on.movimenta();
            } else
                EstrelaAmarela.remove(p);
        }

        for (int p = 0; p < EstrelaAzul.size(); p++) {
            EstrelaAzul on = EstrelaAzul.get(p);
            if (on.isVisible()) {
                on.movimenta();
            } else
                EstrelaAzul.remove(p);
        }

        List<AtaquePlayer> tiros = player.getTiros();

        for (int i = 0; i < tiros.size(); i++) {
            AtaquePlayer m = tiros.get(i);
            if (m.isVisible()) {
                m.movimenta();
            } else {
                tiros.remove(i);
            }
        }

        for (int i = 0; i < inimigoAzul.size(); i++) {
            InimigoAzul in = inimigoAzul.get(i);
            if (in.isVisible()) {
                in.movimenta();
            } else {
                inimigoAzul.remove(i);
            }
        }

        for (int i = 0; i < inimigoLaranja.size(); i++) {
            InimigoLaranja in = inimigoLaranja.get(i);
            if (in.isVisible()) {
                in.movimenta();
            } else {
                inimigoLaranja.remove(i);
            }
        }

        for (int i = 0; i < inimigoRosa.size(); i++) {
            InimigoRosa in = inimigoRosa.get(i);
            if (in.isVisible()) {
                in.movimenta();
            } else {
                inimigoRosa.remove(i);
            }
        }

        for (int i = 0; i < inimigoVerde.size(); i++) {
            InimigoVerde in = inimigoVerde.get(i);
            if (in.isVisible()) {
                in.movimenta();
            } else {
                inimigoVerde.remove(i);
            }
        }

        for (int i = 0; i < meteoros.size(); i++) {
            Meteoro in = meteoros.get(i);
            if (in.isVisible()) {
                in.movimenta();
            } else {
                meteoros.remove(i);
            }
        }

        for (int i = 0; i < asteroides.size(); i++) {
            Asteroide in = asteroides.get(i);
            if (in.isVisible()) {
                in.movimenta();
            } else {
                asteroides.remove(i);
            }
        }

        checarColisoes();
        repaint();

    }

    public void checarColisoes() {
        Rectangle formaNave = player.getLimites();
        Rectangle formainimigoAzul;
        Rectangle formaTiro;
        Rectangle formaInimigoRosa;
        Rectangle formaMeteoro;
        Rectangle formaAsteroides;
        Rectangle formaInimigoVerde;
        Rectangle formaInimigoLaranja;

        for (int i = 0; i < inimigoAzul.size(); i++) {
            InimigoAzul tempinimigoAzul = inimigoAzul.get(i);
            formainimigoAzul = tempinimigoAzul.getLimites();
            if (formaNave.intersects(formainimigoAzul)) {
                player.setVisivel(false);
                tempinimigoAzul.setVisible(false);
                vidaPlayer -= 1;
                if (vidaPlayer <= 0) {
                    emJogo = false;
                    System.out.println("num abates: " + abateInimigos);
                    System.out.println("Pontos: " + calculaPontuacao());
                }

            }
        }

        for (int i = 0; i < inimigoRosa.size(); i++) {
            InimigoRosa tempinimigoRosa = inimigoRosa.get(i);
            formaInimigoRosa = tempinimigoRosa.getLimites();
            if (formaNave.intersects(formaInimigoRosa)) {
                player.setVisivel(false);
                tempinimigoRosa.setVisible(false);
                vidaPlayer -= 1;
                if (vidaPlayer <= 0) {
                    emJogo = false;
                    System.out.println("num abates: " + abateInimigos);
                    System.out.println("Pontos: " + calculaPontuacao());
                }
            }
        }

        for (int i = 0; i < inimigoLaranja.size(); i++) {
            InimigoLaranja tempinimigoLaranja = inimigoLaranja.get(i);
            formaInimigoLaranja = tempinimigoLaranja.getLimites();
            if (formaNave.intersects(formaInimigoLaranja)) {
                player.setVisivel(false);
                tempinimigoLaranja.setVisible(false);
                vidaPlayer -= 1;
                if (vidaPlayer <= 0) {
                    emJogo = false;
                    System.out.println("num abates: " + abateInimigos);
                    System.out.println("Pontos: " + calculaPontuacao());
                }
            }
        }

        for (int i = 0; i < inimigoVerde.size(); i++) {
            InimigoVerde tempinimigoVerde = inimigoVerde.get(i);
            formaInimigoVerde = tempinimigoVerde.getLimites();
            if (formaNave.intersects(formaInimigoVerde)) {
                player.setVisivel(false);
                tempinimigoVerde.setVisible(false);
                vidaPlayer -= 1;
                player.sofrerDano();
                player.dadosImagem();
                if (vidaPlayer <= 0) {
                    emJogo = false;
                    System.out.println("num abates: " + abateInimigos);
                    System.out.println("Pontos: " + calculaPontuacao());
                }
            }
        }

        for (int i = 0; i < meteoros.size(); i++) {
            Meteoro tempMeteoro = meteoros.get(i);
            formaMeteoro = tempMeteoro.getLimites();
            if (formaNave.intersects(formaMeteoro)) {
                player.setVisivel(false);
                tempMeteoro.setVisible(false);
                vidaPlayer -= 2;
                if (vidaPlayer <= 0) {
                    emJogo = false;
                    System.out.println("num abates: " + abateInimigos);
                    System.out.println("Pontos: " + calculaPontuacao());
                }
            }
        }

        for (int i = 0; i < asteroides.size(); i++) {
            Asteroide tempAsteroide = asteroides.get(i);
            formaAsteroides = tempAsteroide.getLimites();
            if (formaNave.intersects(formaAsteroides)) {
                player.setVisivel(false);
                tempAsteroide.setVisible(false);
                vidaPlayer -= 2;
                if (vidaPlayer <= 0) {
                    emJogo = false;
                    System.out.println("num abates: " + abateInimigos);
                    System.out.println("Pontos: " + calculaPontuacao());
                }
            }
        }

        List<AtaquePlayer> ataques = player.getTiros();
        for (int j = 0; j < ataques.size(); j++) {
            AtaquePlayer tempTiro = ataques.get(j);
            formaTiro = tempTiro.getLimites();

            for (int i = 0; i < inimigoAzul.size(); i++) {
                InimigoAzul tempinimigoAzul = inimigoAzul.get(i);
                formainimigoAzul = tempinimigoAzul.getLimites();
                if (formaTiro.intersects(formainimigoAzul)) {
                    tempinimigoAzul.setVisible(false);
                    tempTiro.setVisible(false);
                    abateInimigos += 1;
                    calculaPontuacao();
                }
            }

            for (int i = 0; i < inimigoRosa.size(); i++) {
                InimigoRosa tempinimigoRosa = inimigoRosa.get(i);
                formaInimigoRosa = tempinimigoRosa.getLimites();
                if (formaTiro.intersects(formaInimigoRosa)) {
                    tempinimigoRosa.setVisible(false);
                    tempTiro.setVisible(false);
                    abateInimigos += 1;
                    calculaPontuacao();
                }
            }

            for (int i = 0; i < inimigoVerde.size(); i++) {
                InimigoVerde tempInimigoVerde = inimigoVerde.get(i);
                formaInimigoVerde = tempInimigoVerde.getLimites();
                if (formaTiro.intersects(formaInimigoVerde)) {
                    tempInimigoVerde.setVisible(false);
                    tempTiro.setVisible(false);
                    abateInimigos += 1;
                    calculaPontuacao();
                }
            }

            for (int i = 0; i < inimigoLaranja.size(); i++) {
                InimigoLaranja tempInimigoLaranja = inimigoLaranja.get(i);
                formaInimigoLaranja = tempInimigoLaranja.getLimites();
                if (formaTiro.intersects(formaInimigoLaranja)) {
                    tempInimigoLaranja.setVisible(false);
                    tempTiro.setVisible(false);
                    abateInimigos += 1;
                    calculaPontuacao();
                }
            }

        }
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }

    public int getPontos() {
        return this.pontuacaoTotal;
    }

}
