import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

class Cell extends JLabel {
    private static final int CELL_H = 35, CELL_W = 35;
    private boolean isGiven;

    Cell(int value) {
        super(value == 0 ? "" : String.valueOf(value));
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(CELL_H, CELL_W));
        setOpaque(true);
        this.isGiven = value != 0;
        setBorderColor();
    }

    public void setValue(int value) {
        setText(value == 0 ? "" : String.valueOf(value));
        if (!isGiven) {
            setBorderColor();
        }
    }

    private void setBorderColor() {
        if (isGiven) {
            setBorder(BorderFactory.createLineBorder(Color.BLUE));
        } else if (getText().equals("")) {
            setBorder(BorderFactory.createLineBorder(Color.RED));
        } else {
            setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }
    }
}
