import static java . lang . Math . abs ;
import java.io.Serializable;
public class Coordenadas implements Serializable{
    
    // Variáveis de Instância
    private double x , y ;

    // Construtores usuais
    public Coordenadas ( double x , double y ) { this.x = x ; this.y = y ; }
    public Coordenadas() { this (0.0 , 0.0) ; } 
    public Coordenadas ( Coordenadas p ) { x = p . getX () ; y = p . getY () ; }

    // Métodos de Instância
    public double getX () { return x; }
    public double getY () { return y; }

    /** incremento das coordenadas */
    public void incCoord ( double dx , double dy ) {
        x += dx ; y += dy ;
    }
    
    public void setCoord (double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /** decremento das coordenadas */
    public void decCoord ( double dx , double dy ) {
        x -= dx ; y -= dy ;
    }
    /** soma as coordenadas do ponto parâmetro ao ponto receptor */
    public void somaPonto ( Coordenadas p ) {
        x += p. getX () ; y += p. getY () ;
    }

    /** soma os valores parâmetro e devolve um novo ponto */
    public Coordenadas somaPonto ( double dx , double dy ) {
        return new Coordenadas ( x + dx , y + dy ) ;
    }

    /** determina se um ponto é simétrico ( dista do eixo dos XX o
    mesmo que do eixo dos YY */
     public boolean simetrico () {
     return abs ( x ) == abs ( y ) ;
     }
     
    /** verifica se ambas as coordenadas são positivas */
     public boolean coordPos () {
     return x > 0 && y > 0;
     }
    
     // Métodos complementares usuais
     /** verifica se os 2 pontos são iguais */
    public boolean equals(Coordenadas p) {
    return ( p == null ) ? false : x == p . getX () && y == p . getY () ;
    }
    
    /** Converte para uma representação textual */
    public String toString () {
    return new String ("Coordenadas = " + x + ", " + y ) ;
    }
    
    public double distancia(Coordenadas c){
       double xx = (java.lang.Math.pow((c.getX() - this.x),2));
       double yy = (java.lang.Math.pow((c.getY() - this.y),2));
       
       return java.lang.Math.sqrt(xx + yy);
    }
    
    
    /** Cria uma cópia do ponto receptor ( receptor = this ) */
    public Coordenadas clone () {
    return new Coordenadas ( this ) ;
    }
} 
    
     
     
 
 