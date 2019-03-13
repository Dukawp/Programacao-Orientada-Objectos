import java.util.Random;
import java.io.Serializable;
/**
 * Write a description of class Taxi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Taxi implements Serializable
{
    /**Velocidade media por Km*/
    private double velMKm;
    /**Preço base por Km*/
    private double precoKm;
    /**Factor de fiabilidade*/
    private double fiabilidade;
    /**Matricula do taxi*/
    private String matricula;
    /**Nome do motorista*/
    private Motorista motorista;   
    /**Matricula do taxi*/
    private String idTaxi;
    /**Posicao do Taxi*/
    private Coordenadas taxPos;

    Random gerador = new Random();
    
    
    public Taxi(){
        this.velMKm = 0;
        this.precoKm = 0;
        this.fiabilidade = 0;
        this.matricula = "";
        this.motorista = new Motorista();
        this.idTaxi = "";
        this.taxPos = new Coordenadas();
    }
    
    public Taxi(double velMKms, double precoKm, double fiabilidade, String matricula, Motorista motorista, String idTaxi, Coordenadas taxPos){
        this.velMKm = velMKms;
        this.precoKm = precoKm;
        this.fiabilidade = fiabilidade;
        this.matricula = matricula;
        this.motorista = motorista;
        this.idTaxi = idTaxi;
        this.taxPos = taxPos;
    }
    
    public Taxi(Taxi t){
        this.velMKm = t.getVelMKm();
        this.precoKm = t.getPrecoKm();
        this.fiabilidade = t.getFiabilidade();
        this.matricula = t.getMatricula();
        this.motorista= t.getMotorista();
        this.idTaxi = t.getIdTaxi();
        this.taxPos = t.getTaxPos();

    }
    
    /**Gets e Sets*/
    
    public double getVelMKm(){
        return velMKm;
    }
    
    public double getFiabilidade(){
        return fiabilidade;
    }
   
    public double getPrecoKm(){
        return precoKm;
    }
    
    public String getMatricula(){
        return matricula;
    }
    
    public Motorista getMotorista(){
        return motorista;
    }
    
    public String getIdTaxi(){
        return idTaxi;
    }
    
    public Coordenadas getTaxPos(){
        return taxPos;
    }
    
    public void setVelMKm(double velMKm){
        this.velMKm = velMKm;
    }
     
    public double geraFiabilidade(){
        return this.fiabilidade = 0.5 + (1.5-0.5) * gerador.nextDouble();
    }
  
    public void setPrecoKm(double precoKm){
        this.precoKm = precoKm;
    }
     
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public void setMotorista(Motorista motorista){
        this.motorista = motorista;
    }
    
    public void setIdTaxi(String idTaxi){
        this.idTaxi = idTaxi;
    }
    
    public void setTaxPos(Coordenadas taxPos){
        this.taxPos = taxPos;
    }
    
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass()))return false;
        Taxi t = (Taxi) obj;
        if(this.matricula.equals(t.getMatricula()))
        {return true;}
        return false;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Velocidade media por km: ");
        sb.append(getVelMKm());
        sb.append("\n");
        sb.append("Preço por km: ");
        sb.append(getPrecoKm());
        sb.append("\n");
        sb.append("Fiabilidade: ");
        sb.append(getFiabilidade());
        sb.append("\n");
        sb.append("Matricula: ");
        sb.append(getMatricula());
        sb.append("\n");
        sb.append("ID do taxi: ");
        sb.append(getIdTaxi());
        sb.append("\n");
        sb.append("\n");
        sb.append(getTaxPos());
        sb.append("\n");
        
        sb.append("\n");
        sb.append("\t\t\t**Motorista** ");
        sb.append("\n");
        sb.append(getMotorista());
        sb.append("\n");

 
        
        return sb.toString();
    }
    
    /*
    public Taxi clone(){
        return new Taxi(this);
    }
    */
    @Override
    protected abstract Taxi clone();
    
    
    
    
    
    
}
