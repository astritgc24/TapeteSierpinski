
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * Tapete de Sierpinski - Adaptación como aplicación de escritorio con Swing.
 * Dibuja un Tapete de Sierpinski basado en un cuadrado inicial.
 * 
 * @author José Juan Aliaga
 */
public class TapeteSierpinski extends JPanel {

    // Nivel de recursividad
    int nivel_de_recursividad = 4;

    // Método paint para dibujar
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Llamada recursiva para dibujar el tapete
        drawSierpinski(g, nivel_de_recursividad, 50, 50, 300, 300);
    }

    // Método recursivo para dibujar el Tapete de Sierpinski
    private void drawSierpinski(Graphics g, int nivel, int x, int y, int width, int height) {
        if (nivel == 0) {
            // Dibujar el cuadrado lleno si el nivel de recursividad es 0
            g.fillRect(x, y, width, height);
        } else {
            // Tamaño de los cuadrados más pequeños
            int newWidth = width / 3;
            int newHeight = height / 3;

            // Dibujar 8 cuadrados, omitiendo el del centro
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Omitir el cuadrado central
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    // Dibujar los cuadrados recursivamente
                    drawSierpinski(g, nivel - 1, x + i * newWidth, y + j * newHeight, newWidth, newHeight);
                }
            }
        }
    }

    // Método principal para ejecutar la aplicación como JFrame
    public static void main(String[] args) {
        // Crear un nuevo frame
        JFrame frame = new JFrame("Tapete de Sierpinski");
        TapeteSierpinski panel = new TapeteSierpinski();

        // Configurar el frame
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); // Añadir el panel de dibujo al frame
        frame.setVisible(true); // Mostrar el frame
    }
}