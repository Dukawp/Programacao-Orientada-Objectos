import java.util.*;
import java.io.Serializable;
/**
 * Write a description of class InfoGeral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Utilizador implements Serializable
{
    /**ID para facilitar identificaçao(Ex. C1 - Cliente 1 | M1 - Motorista 1)*/
    private String id;
    /**Endereço de email*/
    private String email;
    /**Nome do cliente/taxista*/
    private String nome;
    /**Password*/
    private String password;
    /**Morada do cliente/taxista*/
    private String morada;
    /**Data de nascimento*/
    private GregorianCalendar dataNasc;
    

    
    /**
     * Construtor de um Utilizador
     * @param id           Id do Utilizador
     * @param email        Email do Utilizador
     * @param nome         Nome do Utilizador
     * @param password     Password do Utilizador
     * @param morada       Morada do Utilizador
     * @param dataNasc     Data de nascimento do Utilizador
     */
    
    public Utilizador(){
        this.id = "";
        this.email = "";
        this.nome = "";
        this.password = "";
        this.morada = "";
        this.dataNasc = new GregorianCalendar();
    }
    
    public Utilizador(String id, String email, String nome, String password, String morada, GregorianCalendar dataNasc){
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.dataNasc = new GregorianCalendar(dataNasc.DAY_OF_MONTH, dataNasc.MONTH, dataNasc.YEAR);
    }
    
    public Utilizador(Utilizador c){
        this.id = c.getId();
        this.email = c.getEmail();
        this.nome = c.getNome();
        this.password = c.getPassword();
        this.morada = c.getMorada();
        this.dataNasc = c.getDataNasc();
    }
    
    /**Gets e Sets*/
    public String getId(){
        return id; 
    }
           
    public String getEmail(){
        return email;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getMorada(){
        return morada;
    }
    
    public GregorianCalendar getDataNasc(){
        return dataNasc;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setMorada(String morada){
        this.morada = morada;
    }
    
    public void setdataNasc(GregorianCalendar dataNasc) {
        this.dataNasc = dataNasc;
    }

     public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(dataNasc.get(GregorianCalendar.YEAR));
            sb.append("/");
            sb.append(dataNasc.get(GregorianCalendar.MONTH));
            sb.append("/");
            sb.append(dataNasc.get(GregorianCalendar.DAY_OF_MONTH));
            sb.append("   -   ");
            sb.append(dataNasc.get(GregorianCalendar.HOUR));
            sb.append(":");
            sb.append(dataNasc.get(GregorianCalendar.MINUTE));
            sb.append("\n");
        sb.append("ID utilizador: ");
            sb.append(getId());
            sb.append("");
        sb.append("Email: ");
            sb.append(getEmail());
            sb.append("");
        sb.append("Nome: ");
            sb.append(getNome());
            sb.append("");
        sb.append("Morada: ");
            sb.append(getMorada());
            sb.append("");
        
        return sb.toString();
    }
    
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Utilizador c = (Utilizador) obj;
        if(this.id.equals(c.getId())
        && this.email.equals(c.getEmail())
        && this.nome.equals(c.getNome()) 
        && this.password.equals(c.getPassword()) 
        && this.morada.equals(c.getMorada()) 
        && this.dataNasc.equals(c.getDataNasc())) 
        {return true;}
        return false;
    }
    
    /*
    public Utilizador clone(){
        return new Utilizador(this);
    }
    */
    @Override
    protected abstract Utilizador clone();

}
