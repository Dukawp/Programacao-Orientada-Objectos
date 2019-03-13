import java.util.Comparator;
import java.io.Serializable;

public class ComparatorGasto implements Comparator<Cliente>, Serializable
{
    public int compare( Cliente c1, Cliente c2){
        double x1 = c1.getGasto();
        double x2 = c2.getGasto();
        
        if(x1 == x2 ) return 0;
        if(x1 > x2) return -1;
        if(x1 < x2) return 1;
        return 0;
        
    }
}
