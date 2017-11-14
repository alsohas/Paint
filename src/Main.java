import java.awt.EventQueue;

/**
 * @author Abdullah Islam
 * @version 2/9/16
 * This runs the GUI.
 */
public final class Main {

    /**
     * Inhibits instantiation of main class.
     */
    private Main() {
        throw new IllegalStateException();
    }

    /**
     * @param theArgs For command prompt.
     * Instatiates the GUI.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Paint();
            }
        });
    }
}

