
package co.edu.usa.semana3g26.Reportes;

/**
 *
 * @author ANDRES
 */
public class StatusReservas {
    
    private int completed;
    private int cancelled;

    public int getCompleted() {
        return completed;
    }

    public StatusReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    
}
