import java.util.Map;
import java.util.*;
/**
 * Write a description of class Motorista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Motorista extends Utilizador
{
    /**Grau de cumprimento de horário (0-100) */
    private int grauC;
    /**Classificação do Motorista*/
    private double classificacao;
    /**Historico  das Viagens*/
    private ArrayList<Viagem> viagens;
    /**Numero kms realizados na UMeR*/
    private int kms;
    /**Informação sobre disponibilidade para viagem*/
    private boolean disponivel;
    /**Numero desvios*/
    private int desvio;
    
    private int contaClassificacao;
    private int contaGrauC;
    
    /**
     * Construtor de um Utilizador
     * @param grauC              Grau cumprimento de horario
     * @param classificacao      Classificacao do Motorista
     * @param kms                Kms feitos pelo Motorista
     * @param disponivel         Disponibilidade do Motorista
     * 
     */
    
    public Motorista(){
        super();
        this.grauC = 0;
        this.classificacao = 0;
        this.viagens = new ArrayList<Viagem>();
        this.kms = 0;
        this.disponivel = false;
        this.desvio = 0;
    }
    
    public Motorista(String id, String email, String nome, String password, String morada, GregorianCalendar dataNasc, int grauC, double classificacao, ArrayList<Viagem> viagens, int kms, boolean disponivel, int desvio){
        super(id, email, nome, password, morada, dataNasc);
        this.grauC = grauC;
        this.classificacao = classificacao;
        this.viagens = viagens;
        this.kms = kms;
        this.disponivel = disponivel;
        this.desvio = desvio;
    }
    
    public Motorista(Motorista m){
        super(m);
        this.grauC = m.getGrauC();
        this.classificacao = m.getClassificacao();
        this.viagens = m.getViagens(); 
        this.kms = m.getKms();
        this.disponivel = m.getDisponivel();
        this.desvio = m.getDesvio();
    }
    
    /**Gets e Sets*/
    public int getGrauC(){
        return grauC;
    }
    
    public double getClassificacao(){
        return classificacao;
    }
    
    public ArrayList<Viagem> getViagens(){
        //ArrayList<Viagem> viagens = new ArrayList<>();
        return viagens;
    }
    
    public int getKms(){
        return kms;
    }
    
    public boolean getDisponivel(){
        return disponivel;
    }
    
    public int getDesvio(){
        return desvio;
    }
    
    public void setGrauC(int grauC){
        this.grauC = (this.grauC * contaGrauC + grauC) / (contaGrauC+1);
        contaGrauC++;
    }
    
    public void setClassificacao(double classificacao){
        this.classificacao = (this.classificacao * contaClassificacao + classificacao) / (contaClassificacao+1);
        contaClassificacao++;
    }
    
    public void setKms(int kms){
        this.kms += kms;
    }
    
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    
    public void setDesvio(int desvio){
        this.desvio += desvio;
    }
    
    public void setViagem(ArrayList<Viagem> viagens){
        this.viagens = viagens; 
    }
    
    public void addViagem(Viagem viagem){
        this.viagens.add(viagem.clone());
    }
    
     public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Motorista m = (Motorista) obj;
        if(super.equals(m) && super.equals(obj) &&
        this.grauC == m.getGrauC()
        && this.classificacao == m.getClassificacao() 
        && this.kms == m.getKms() 
        && this.disponivel == m.getDisponivel()) 
        {return true;}
        return false;
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
        sb.append("Grau cumprimento horario: ");
        sb.append(getGrauC());
        sb.append("\n");
        sb.append("Classificação: ");
        sb.append(getClassificacao());
        sb.append("\n");
        sb.append("Numero kms feitos: ");
        sb.append(getKms());
        sb.append("\n");
        sb.append("Disponibilidade: ");
        sb.append(getDisponivel());
        sb.append("\n");
        sb.append("Numero de desvios: ");
        sb.append(getDesvio());
        sb.append("\n");
        sb.append("\n");
        sb.append("\t\t\tViagens: ");
        sb.append(getViagens());

        
        return sb.toString();
    }
    
    public Motorista clone(){
        return new Motorista(this);
    }
}
