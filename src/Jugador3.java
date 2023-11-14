import java.util.logging.Level;
import java.util.logging.Logger;

public class Jugador3 extends Thread {
    Ventana p;
    public int contador = 0;
    int dado = 0;
    int tiro = 0;
    private boolean mantieneCiclo=true;
    private boolean ejecutaCodigo=true;
    

    public Jugador3(Ventana p) {
        this.p = p;
    }

    @Override
    public void run() {
        boolean encendido=true;
        while (mantieneCiclo) {
            try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Jugador3.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(ejecutaCodigo){
                if (contador == 0) {
                  tiro++;
                 tirada();
                 if(tiro==3)
                     break;
              
                    p.jTextPane3.setText(p.jTextPane3.getText() + "Tirada " + tiro + " : " + dado + "\n");
                 
                }
                
             }           
        }
    }
    public boolean estaTerminando(){
        return mantieneCiclo;
    }
    public void terminar(){
        mantieneCiclo=false;
    }
    public void tirada() {
        dado = tirarDado();
    }

    public int tirarDado() {
        dado = (int) (Math.random() * 6) + 1;
        return dado;
    }
}