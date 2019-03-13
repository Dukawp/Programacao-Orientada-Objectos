import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * Write a description of class Viagem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Viagem implements Serializable
{
    /**Duraçao da viagem (ex 1h30min = 1.5)*/
    private double tempoViagem;
    /**Coordenada do começo da viagem*/
    private Coordenadas inicio;
    /**Coordenada do fim da viagem*/
    private Coordenadas fim;
    /**Kms percorridos*/
    private double kmsP;
    /**Motorista de cada viagem*/
    private Motorista motorista;
    /**ID do Taxi*/
    private String idTaxi;
    /**Custo da viagem*/
    private double custo;
    /**Data da viagem*/
    private GregorianCalendar dataViagem;
    
    
    public Viagem(){
        this.tempoViagem = 0;
        this.inicio = new Coordenadas();
        this.fim = new Coordenadas();
        this.kmsP = 0;
        this.motorista = new Motorista();
        this.idTaxi = "n/a";
        this.custo = 0;
        this.dataViagem = new GregorianCalendar();
    }
    
    public Viagem(double tempoViagem, Coordenadas inicio, Coordenadas fim, double kmsP, Motorista motorista, String idTaxi, double custo, GregorianCalendar dataViagem){
        this.tempoViagem = tempoViagem;
        this.inicio = inicio;
        this.fim = fim;
        this.kmsP = kmsP;
        this.motorista = motorista;
        this.idTaxi = idTaxi;
        this.custo = custo;
        this.dataViagem = dataViagem;//new GregorianCalendar(dataViagem.YEAR, dataViagem.MONTH, dataViagem.DAY_OF_MONTH, dataViagem.HOUR, dataViagem.MINUTE);
    }
    
    public Viagem(Viagem v){
        this.tempoViagem = v.getTempoViagem();
        this.inicio = v.getInicio();
        this.fim = v.getFim();
        this.kmsP = v.getKmsP();
        this.motorista = v.getMotorista();
        this.idTaxi = v.getIdTaxi();
        this.custo = v.getCusto();
        this.dataViagem = v.getDataViagem();
    }
    
    public double getTempoViagem(){
        return tempoViagem;
    }
    
    public double getKmsP(){
        return kmsP;
    }
    public Motorista getMotorista(){
        return motorista;
    }
    
    public String getIdTaxi(){
        return idTaxi;
    }
    
    public double getCusto(){
        return custo;
    }
    
    public GregorianCalendar getDataViagem(){
        return new GregorianCalendar(dataViagem.YEAR, dataViagem.MONTH, dataViagem.DAY_OF_MONTH, dataViagem.HOUR, dataViagem.MINUTE);
    }
    
    public void setIdTaxi(String idTaxi){
        this.idTaxi = idTaxi;
    }
    
    public void setMotorista(Motorista motorista){
        this.motorista = motorista;
    }
    
    public void setCusto(double custo){
        this.custo = custo;
    }
    
    public void setTempoViagem(double tempoViagem){
        this.tempoViagem = tempoViagem;
    }

    public void setInicio(Coordenadas inicio){
        this.inicio = inicio;
    }
    
    public void setFim(Coordenadas fim){
        this.fim = fim;
    }
    
    public void setKmsp(double kmsP){
        this.kmsP = kmsP;
    }
    public Coordenadas getInicio(){
        return inicio.clone();
    }
    
    public Coordenadas getFim(){
        return fim.clone();
    }
 
    public void setDataViagem(GregorianCalendar dataViagem) {
        this.dataViagem = new GregorianCalendar(dataViagem.YEAR, dataViagem.MONTH, dataViagem.DAY_OF_MONTH, dataViagem.HOUR, dataViagem.MINUTE);
    }
    
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Viagem v = (Viagem) obj;
        if(this.inicio.equals(v.getInicio())
        && this.fim.equals(v.getFim())
        && this.kmsP == v.getKmsP()){
            return true;
        }
        return false;
    }

     public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\tViagem: ");
        sb.append("\nData da Viagem: ");
            sb.append(dataViagem.get(GregorianCalendar.YEAR));
            sb.append("/");
            sb.append(dataViagem.get(GregorianCalendar.MONTH));
            sb.append("/");
            sb.append(dataViagem.get(GregorianCalendar.DAY_OF_MONTH));
            sb.append("   -   ");
            sb.append(dataViagem.get(GregorianCalendar.HOUR));
            sb.append(":");
            sb.append(dataViagem.get(GregorianCalendar.MINUTE));
            sb.append("\n");
        sb.append("Tempo da viagem: ");
            sb.append(getTempoViagem());
            sb.append("\n");

        /*sb.append("Inicio da viagem: ");
            sb.append(getInicio());
            sb.append("\n");
        sb.append("Fim da viagem: ");
            sb.append(getFim());
            sb.append("\n");*/
        sb.append("Kms percorridos: ");
            sb.append(getKmsP());
            sb.append("\n");
        sb.append("Motorista: ");
            sb.append(getMotorista().getNome());
            sb.append("\n");
        sb.append("ID taxi: ");
            sb.append(getIdTaxi());
            sb.append("\n");
        sb.append("Custo da viagem: ");
            sb.append(getCusto());
            sb.append("\n");
        
        return sb.toString();
    }
    public Viagem clone(){
        return new Viagem(this);
    }
    
}
