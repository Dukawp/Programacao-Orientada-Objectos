import java.util.Comparator;
import java.io.Serializable;

public class ComparatorDesvio implements Comparator<Motorista>, Serializable
{
    public int compare( Motorista m1, Motorista m2){
        int x1 = m1.getDesvio();
        int x2 = m2.getDesvio();
        
        if(x1 == x2) return 0;
        if(x1 > x2) return -1;
        if(x1 < x2) return 1;
        return 0;
        
    }
}
