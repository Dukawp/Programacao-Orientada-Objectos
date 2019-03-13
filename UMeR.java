import java.util.*;
/*import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;*/
import java.io.*;
/**
 * Write a description of class UMeR here.
 * 
 * @author Duarte Freitas
 * @version V2.0
 */
public class UMeR implements Serializable
{
    /**Utilizadores com id(Integer) mais a informaçao deles*/
    private Map<String, Utilizador> utilizadores; 
    private Map<String, Taxi> taxis;
    private Utilizador sessao=null;
    private List<Taxi> listaespera; 
    private List<Taxi> listadisp; 
    private List<Taxi> listaind; 
    private TreeSet<Motorista> maisdesvios;
    private int nCarroLig, nCarrinha, nMota, nCliente, nMotorista; 
    //Comparator<Cliente> total = new ComparatorGasto();
     
    public UMeR(){
        this.utilizadores = new HashMap<String, Utilizador>();
        this.taxis = new HashMap<String, Taxi>();
        this.listaespera = new ArrayList<Taxi>();
        this.listadisp = new ArrayList<Taxi>();
        this.listaind = new ArrayList<Taxi>();
    }
    
    public UMeR(HashMap<String, Utilizador> utilizadores, HashMap<String, Taxi> taxis, ArrayList<Taxi> listaespera, ArrayList<Taxi> listadisp, ArrayList<Taxi> listaind,int nCarroLig, int nCarrinha, int nMota, int nCliente, int nMotorista){
        this.utilizadores = utilizadores;
        this.taxis = taxis;
        this.listaespera = listaespera;
        this.listadisp = listadisp;
        this.listaind = listaind;
        this.nCliente = nCliente;
        this.nMotorista = nMotorista;
        this.nCarroLig = nCarroLig;
        this.nCarrinha = nCarrinha;
        this.nMota = nMota; 
        for(Map.Entry<String, Utilizador> e: utilizadores.entrySet()){
            this.utilizadores.put(e.getKey(), e.getValue().clone());
        }
        
        for(Map.Entry<String, Taxi> e: taxis.entrySet()){
            this.taxis.put(e.getKey(), e.getValue().clone());
        }
    }
    
    public UMeR(UMeR Umer){
        utilizadores = Umer.getUtilizadores();
        taxis = Umer.getTaxis();
        listaespera = Umer.getListaespera();
        listadisp = Umer.getListaDisp();
        listaind = Umer.getListaInd();
    }
    
    public Map<String, Utilizador> getUtilizadores() {return utilizadores;}
    public Map<String, Taxi> getTaxis() {return taxis;}
    public List<Taxi> getListaespera() {return listaespera;}

    public int getNCarroLig(){
        return nCarroLig;
    }
    
    public int getNCarrinha(){
        return nCarrinha;
    }
    
    public int getNMota(){
        return nMota;
    }
    
    public int getNCliente(){
        return nCliente;
    }
    
    public int getNMotorista(){
        return nMotorista;
    }
    
    public List<Taxi> getListaDisp() {
       ArrayList<Taxi> ldisp = new ArrayList<Taxi>();
        //ArrayList<Taxi> ltax = new ArrayList<Taxi>(taxis.values());
       for(Taxi t : taxis.values()){  
               if(t.getMotorista().getDisponivel()){
                ldisp.add(t.clone());
               }
       }
      
       return ldisp;
        
    }
    
    public List<Taxi> getListaCarroLig() {
       ArrayList<Taxi> lcar = new ArrayList<Taxi>();
        //ArrayList<Taxi> ltax = new ArrayList<Taxi>(taxis.values());
       for(Taxi t : taxis.values()){  
               if(t instanceof CarroLigeiro ){//t.getClass().equals("CarroLigeiro")
                lcar.add(t.clone());
               }
       }
      
       return lcar;
    }
    
     public List<Taxi> getListaCarrinha() {
        ArrayList<Taxi> lc9 = new ArrayList<Taxi>();
        //ArrayList<Taxi> ltax = new ArrayList<Taxi>(taxis.values());
       for(Taxi t : taxis.values()){  
               if(t instanceof Carrinha ){//t.getClass().equals("CarroLigeiro")
                lc9.add(t.clone());
               }
       }
      
       return lc9;
    }
    
    public List<Taxi> getListaMota() {
        ArrayList<Taxi> lmotas = new ArrayList<Taxi>();
        //ArrayList<Taxi> ltax = new ArrayList<Taxi>(taxis.values());
       for(Taxi t : taxis.values()){  
               if(t instanceof Mota ){//t.getClass().equals("CarroLigeiro")
                lmotas.add(t.clone());
               }
       }
      
       return lmotas;
    }
    
    
    public List<Taxi> getListaInd() {
       ArrayList<Taxi> lind = new ArrayList<Taxi>();
        //ArrayList<Taxi> ltax = new ArrayList<Taxi>(taxis.values());
       for(Taxi t : taxis.values()){  
           
               if(!t.getMotorista().getDisponivel()){
                lind.add(t.clone());
               }
            
       }
      
       return lind;
        
    }
    
    public void registarUtilizador(Utilizador utilizador)throws ExisteException{
        /*for(Utilizador u : utilizadores.values()){
            if(u.getEmail().equals(utilizador.getEmail())){
                throw new ExisteException("Este Email já esta registado!!");
            }
        }*/
        if(this.utilizadores.containsKey(utilizador.getEmail())){
                throw new ExisteException("Este Email já esta registado!!");
            }
        
        switch(utilizador.getClass().getName()){
            
            case "Cliente":
                utilizador.setId("CN"+Integer.toString(nCliente));
                this.utilizadores.put(utilizador.getEmail(), utilizador.clone());
                nCliente++;
                break;
               
                        
            case "Motorista":
                utilizador.setId("MN"+Integer.toString(nMotorista));
                this.utilizadores.put(utilizador.getEmail(), utilizador.clone());
                nMotorista++;
                break;
               }
    }
    
    
    public boolean isMotorista(){
        if (sessao==null)
            return false;
        
        return this.sessao.getClass().getName().equals("Motorista");
    }
    
    public boolean isCliente(){
        if (sessao==null)
            return false;
        
        return this.sessao.getClass().getName().equals("Cliente");
    } 
    
    public void registarTaxi(Taxi auto)throws SemAutorizacaoException, ExisteException{
       if(!isMotorista()){
           throw new SemAutorizacaoException("Não é motorista");
       }
       else{
                          
            /*for(Taxi t : taxis.values()){
                if(t.getMatricula().equals(auto.getMatricula())){ 
                    throw new ExisteException("Esta matricula já esta registada");
                }
            }*/
            if(this.taxis.containsKey(auto.getMatricula())){
                  throw new ExisteException("Esta matricula já esta registada");
                }
                
            Motorista m = ((Motorista)sessao).clone();
            auto.setMotorista(m);
            
            switch(auto.getClass().getName()){
                case "CarroLigeiro":
                    auto.setIdTaxi("CL"+ Integer.toString(nCarroLig));
                    //auto.setMotorista(sessao);
                    this.taxis.put(auto.getMatricula(), auto.clone());
                    nCarroLig++;
                    break;
                                     
                case "Carrinha":
                    auto.setIdTaxi("C"+ Integer.toString(nCarrinha));
                    this.taxis.put(auto.getMatricula(), auto.clone());
                    nCarrinha++;
                    break;
                        
                                    
                case "Mota":
                    auto.setIdTaxi("M"+ Integer.toString(nMota));
                    this.taxis.put(auto.getMatricula(), auto.clone());
                    nMota++;
                    break;
            }
       }
                
    }
        
    public void efetuarLogin(String email, String password)throws ErroContaException{
        if(sessao == null){
            if(!this.utilizadores.containsKey(email)){
                throw new ErroContaException("Não existe conta com esse email");
            }
            else {
                for(Map.Entry<String, Utilizador> e : utilizadores.entrySet()){
                    if(e.getKey().equals(email) && !e.getValue().getPassword().equals(password)){
                        throw new ErroContaException("Password errada!");
                    }
                    else {
                        sessao = this.utilizadores.get(email).clone();
                    }
                }
            }
        }
        else{
            throw new  ErroContaException("Já tem uma sessão inciada!");
        }
    }
    
    public void logout(){
        sessao=null;
    }
    
    public Utilizador getSessao(){
        return sessao;
    }
    
    public void indicaCord(Coordenadas c)throws SemAutorizacaoException{
        if(!isCliente()){
            throw new SemAutorizacaoException("Não é cliente");
        }
        else{
            //((Cliente)this.utilizadores.get(sessao.getEmail())).setPosicao(c);
            for(Utilizador u : utilizadores.values()){
                if(u.getId().equals(sessao.getId())){//&& (u instanceof Cliente)){
                    ((Cliente)u).setPosicao(c);
                }
            }
        }
    }
   
    public Taxi taxiMaisProximo(Coordenadas c1){
        double conta = 1000000;
        Taxi t1 = null;
        
        for(Taxi t : taxis.values()){       
            if(conta > c1.distancia(t.getTaxPos())){ 
                conta=c1.distancia(t.getTaxPos());
                t1 = t;
            }
        }
        
        return t1;
    }
   
    public double distanciaCT(Taxi taxi, Coordenadas c1){
        return c1.distancia(taxi.getTaxPos());
    }
    
    public int distanciaTotal(Taxi taxi, Coordenadas cf,Coordenadas c1){
        return (int)distanciaCT(taxi,c1) + (int)c1.distancia(cf);
    }
    
    public double tempoParaChegar(Taxi taxi, Coordenadas c1){
        return distanciaCT(taxi,c1)/taxi.getVelMKm();
    }  
    
    public double tempoParaChegarReal(Taxi taxi, double transito, Coordenadas c1){
        return (distanciaCT(taxi,c1)/ taxi.getVelMKm()) * taxi.geraFiabilidade() * transito;
    } 
    
    public double tempoFinal(Taxi taxi, Coordenadas fim, Coordenadas c1){
        double df = c1.distancia(fim);
        return df / taxi.getVelMKm();
    }
    
     public double tempoFinalReal(Taxi taxi, Coordenadas fim, Coordenadas c1, double transito){
        double df = c1.distancia(fim);
        return (df / taxi.getVelMKm()) * taxi.geraFiabilidade() * transito;
    }
    
    public Coordenadas getPosSessao(){
        return ((Cliente)sessao).getPosicao();
    }
    
    public void adicionaViagem(Viagem viagem){
        ((Cliente)sessao).addViagem(viagem);
    }
    
    public void adicionaViagemM(Viagem viagem, Motorista motorista){
        motorista.addViagem(viagem);
    }
    
    public Taxi taxiSessao(){
        Motorista m = (Motorista)sessao.clone();
        for(Taxi t : taxis.values()){
            if(t.getMotorista().getEmail().equals(m.getEmail())){
                return t.clone();
            }
        }
        return null;
    }
   
    
    /**
     * Metodo que guarda o estado do umer
     */
    public void escreveObjUmer( String s1 ) throws FileNotFoundException, IOException{
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(s1));
      oos.writeObject(this);
      oos.flush(); 
      oos.close();
    }
    
    /**
     * Metodo que le o estado do umer
     */   
    public static UMeR carregaObjUmer(String file) throws IOException,ClassNotFoundException{
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
           UMeR umer =  (UMeR)ois.readObject();
           ois.close();
           return umer;
           
    }
    
    public boolean jatemTaxi(){
        Motorista m = (Motorista)getSessao();
        for(Taxi t : taxis.values()){
            if(t.getMotorista().getEmail().equals(m.getEmail())){
                return true;
            }
        }
        return false;
    }
    
    public Taxi getTaxi(String matricula) {
        if(taxis.containsKey(matricula)){
            return taxis.get(matricula);
        }
        return null;
    }
    
    public void trocarTaxi(Taxi taxi)throws SemAutorizacaoException, ExisteException{
        Motorista m = (Motorista)getSessao();
        for(Taxi t : taxis.values()){
            if(t.getMotorista().equals(m)){
                taxis.remove(t.getMatricula());
            }
        }
        taxi.setMotorista(m);
        registarTaxi(taxi);
    }
    
    public TreeSet<Cliente> listaClientesMaisGastam(){
        TreeSet<Cliente> lgastos = new TreeSet<Cliente>(new ComparatorGasto());
        Cliente c = null;
        
        for(Utilizador u: utilizadores.values()){
            if(u instanceof Cliente){
             c = (Cliente)u;
             lgastos.add(c);
            }
        }
        return lgastos;
    }
    
    public ArrayList<Viagem> viagensEntreDatas(GregorianCalendar inicio, GregorianCalendar fim){
        Utilizador u = getSessao();
        if(u instanceof Cliente){
            Cliente c = (Cliente)u;
            ArrayList<Viagem> viagens = c.getViagens();
            ArrayList<Viagem> lviagens = new ArrayList<Viagem>();
            for(Viagem v : viagens){
                GregorianCalendar dtv = v.getDataViagem();
                if((dtv.after(inicio)) && (dtv.before(fim))){
                    lviagens.add(v.clone());
                }
            }
            return lviagens;
        }
        
        else {
            Motorista m = (Motorista)getSessao();
            ArrayList<Viagem> viagens = m.getViagens();
            ArrayList<Viagem> lviagens = new ArrayList<Viagem>();
            for(Viagem v : viagens){
                GregorianCalendar dtv = v.getDataViagem();
                if((dtv.after(inicio)) && (dtv.before(fim))){
                    lviagens.add(v.clone());
                }
            }
            return lviagens;
        }
      
    }
    
    public double totalFacturado(String idTaxi, GregorianCalendar inicio,GregorianCalendar fim){
         double total = 0;
         Motorista m = (Motorista)getSessao();
         ArrayList<Viagem> viagens = m.getViagens();
         for (Viagem v : viagens)
         {
             if(v.getIdTaxi().equals(idTaxi)){
                 if((v.getDataViagem().after(inicio)) && (v.getDataViagem().before(fim))){
                     total += v.getCusto();
                 }
             }
         }
         return total;
    }
    
    public TreeSet<Motorista> getMaisDesvios(){
        TreeSet<Motorista> maisdesvios = new TreeSet<Motorista>(new ComparatorDesvio());
        for(Taxi t : taxis.values()){
            Motorista m = t.getMotorista();
            maisdesvios.add(m.clone());
        }
        return maisdesvios;
    }
}