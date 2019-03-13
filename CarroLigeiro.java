
/**
 * Write a description of class CarroLigeiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarroLigeiro extends Taxi
{
   public CarroLigeiro(){
       super();
    }
    
   public CarroLigeiro(double velMKm, double precoKm, double fiabilidade, String matricula, Motorista motorista, String idTaxi, Coordenadas taxPos){
       super(velMKm, precoKm, fiabilidade, matricula, motorista, idTaxi, taxPos);
   }
    
   public CarroLigeiro(CarroLigeiro cl){
       super(cl);
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
   
   public CarroLigeiro clone(){
       return new CarroLigeiro(this);
   }
}
