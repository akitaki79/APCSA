import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ScalableAmericanFlag extends JFrame {
    private FlagPanel flagPanel;

    public ScalableAmericanFlag() {
        flagPanel = new FlagPanel();
        add(flagPanel);

        setTitle("Scalable American Flag");
        setSize(760, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                flagPanel.adjustFlagDimensions();
                flagPanel.repaint();
            }
        });
    }

    class FlagPanel extends JPanel {
        private double flagWidth;
        private double flagHeight;

        public FlagPanel() {
            adjustFlagDimensions();
        }

        public void adjustFlagDimensions() {
            double frameRatio = (double) getWidth() / getHeight();
            if (frameRatio > 1.9) {
                flagHeight = getHeight();
                flagWidth = flagHeight * 1.9;
            } else {
                flagWidth = getWidth();
                flagHeight = flagWidth / 1.9;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawFlag(g);
        }

        private void drawFlag(Graphics g) {
            int stripeHeight = (int) (flagHeight / 13);

            for (int i = 0; i < 13; i++) {
                Color color = (i % 2 == 0) ? Color.RED : Color.WHITE;
                g.setColor(color);
                g.fillRect(0, (int) (i * stripeHeight), (int) flagWidth, stripeHeight);
            }

            int unionWidth = (int) (0.76 * flagHeight);
            int unionHeight = stripeHeight * 7;
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, unionWidth, unionHeight);

            int starDiameter = (int) (0.0616 * flagHeight);
            int starRadius = starDiameter / 2;

            double horizontalSpacing = 2 * 0.063 * flagHeight;
            double verticalSpacing = 0.054 * flagHeight;

            int startStarX = (int) (0.063 * flagHeight);
            int startStarY = (int) (0.054 * flagHeight);

            int rows = 9; 
            int offset = 0;
            for (int i = 0; i < rows; i++) {
                int stars = 6 - (i % 2); 
                for (int j = 0; j < stars; j++) {
                    int starX = startStarX + (int) (j * horizontalSpacing) + offset; 
                    int starY = startStarY + (int) (i * verticalSpacing);
                    drawStar(g, starX, starY, starRadius);
                }
                offset = (offset == 0) ? (int) (horizontalSpacing / 2) : 0; 
            }
        }

        private void drawStar(Graphics g, int x, int y, int radius) {
            int[] xPoints = new int[10];
            int[] yPoints = new int[10];
            double startAngle = Math.PI / 10;
            double angleStep = Math.PI / 5;

            for (int i = 0; i < 10; i++) {
                double currentRadius = (i % 2 == 0) ? radius : radius * Math.cos(Math.toRadians(72)) / Math.cos(Math.toRadians(36));
                xPoints[i] = x + (int) (Math.cos(startAngle - angleStep * i) * currentRadius);
                yPoints[i] = y - (int) (Math.sin(startAngle - angleStep * i) * currentRadius);
            }

            g.setColor(Color.WHITE);
            g.fillPolygon(xPoints, yPoints, 10);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScalableAmericanFlag frame = new ScalableAmericanFlag();
            frame.setVisible(true);
        });
    }
}