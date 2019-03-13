import java.util.*;
/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente extends Utilizador
{
    /**Historico  das Viagens*/
    private ArrayList<Viagem> viagens;
    /**Coordenadas onde esta posicionado*/
    private Coordenadas posicao;
    private double gasto;
 
    
    /**O historico de viagens pode passar para o comum!!!!!!!!!!!*/
    
    public Cliente(){
        super();
        this.viagens = new ArrayList<Viagem>();
        this.posicao = new Coordenadas();
        this.gasto = 0;
    }
    
    public Cliente(String id, String email, String nome, String password, String morada, GregorianCalendar dataNasc, ArrayList<Viagem> viagens, Coordenadas posicao, double gasto){
        super(id, email, nome, password, morada, dataNasc);
        this.viagens = viagens;
        this.posicao = posicao;
        this.gasto = gasto;
    }
    
    public Cliente(Cliente c){
        super(c);
        this.viagens = c.getViagens();
        this.posicao = c.getPosicao();
        this.gasto = c.getGasto();
    }
    
    public ArrayList<Viagem> getViagens(){
        return viagens;
    }
        
    public Coordenadas getPosicao(){
        return posicao;
    }
    
    public double getGasto(){
        return gasto;
    }
    
     public void setGasto(double gasto){
        this.gasto += gasto;
    }
    
    public void setPosicao(Coordenadas posicao){
        this.posicao = posicao;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("ID utilizador: ");
        sb.append(getId());
        sb.append("\n");
        sb.append("Email: ");
        sb.append(getEmail());
        sb.append("\n");
        sb.append("Nome: ");
        sb.append(getNome());
        sb.append("\n");
        sb.append("Morada: ");
        sb.append(getMorada());
        sb.append("\n");
        sb.append("Coordenadas: ");
        sb.append(getPosicao());
        
        return sb.toString();
    }

    public void addViagem(Viagem viagem){
        this.viagens.add(viagem);
    }
    
    public Cliente clone(){
        return new Cliente(this);
    }
}

