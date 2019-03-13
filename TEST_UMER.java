import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class TEST_UMER {
    public static UMeR povoar(){
 
        
        int nCarroLig, nCarrinha, nMota, nCliente, nMotorista; 
        
        /**
         * Coordenadas
         */
        
        Coordenadas co1 = new Coordenadas(0,1);
        Coordenadas co2 = new Coordenadas(0,5);
        Coordenadas co3 = new Coordenadas(1,2);
        Coordenadas co4 = new Coordenadas(2,0);
        Coordenadas co5 = new Coordenadas(3,2);
        Coordenadas co6 = new Coordenadas(10,10);
        Coordenadas co7 = new Coordenadas(15,18);
        Coordenadas co8 = new Coordenadas(20,7);
        Coordenadas co9 = new Coordenadas(16,12);
        Coordenadas co10 = new Coordenadas(20,30);
        
        /**
         * utilizadores
         * Motorista(String id, String email, String nome, String password, String morada, GregorianCalendar dataNasc, int grauC, double classificacao, ArrayList<Viagem> viagens, int kms, boolean disponivel, int desvio)
         * Cliente(String id, String email, String nome, String password, String morada, GregorianCalendar dataNasc, ArrayList<Viagem> viagens, Coordenadas posicao, double gasto)
           */
        
        
        Motorista m1 = new Motorista("m1","c@","Carlos","pm1","morada3",new GregorianCalendar(1,1,1993),80,4.2,new ArrayList<Viagem>(),8200,true,232);
        Motorista m2 = new Motorista("m2","duarte@","Duarte","jose","morada4",new GregorianCalendar(27,1,1992),90,4.8,new ArrayList<Viagem>(),9000,true,32);     
        Motorista m3 = new Motorista("m3","z@","Diogo","pm3","morada5",new GregorianCalendar(24,3,1995),60,4.9,new ArrayList<Viagem>(),3700,false,430);
        Motorista m4 = new Motorista("m4","f@","Domingos","pass6","morada6",new GregorianCalendar(1,3,1995),60,4.7,new ArrayList<Viagem>(),3500,false,40);
        Motorista m5 = new Motorista("m5","s@","Joana","pass7","morada7",new GregorianCalendar(21,10,1985),70,4.5,new ArrayList<Viagem>(),9000,true,103);
        Motorista m6 = new Motorista("m6","m@","Maria","pass8","morada8",new GregorianCalendar(15,2,1992),90,4.8,new ArrayList<Viagem>(),9000,true,23); 
        Motorista m7 = new Motorista("m7","x@","Joao","pm7","morada5",new GregorianCalendar(23,3,1976),60,4.9,new ArrayList<Viagem>(),3700,false,84); 
        Motorista m8 = new Motorista("m8","v@","Pedro","pm8","morada5",new GregorianCalendar(17,8,1997),60,4.9,new ArrayList<Viagem>(),3700,false,144); 
        Motorista m9 = new Motorista("m9","n@","Mafalda","pm9","morada5",new GregorianCalendar(23,10,1989),60,4.9,new ArrayList<Viagem>(),3700,false,124); 
        Motorista m10 = new Motorista("m10","o@","Leonor","pm10","morada5",new GregorianCalendar(8,11,1987),60,4.9,new ArrayList<Viagem>(),3700,false,164); 
        
        HashMap<String, Utilizador> listu = new HashMap<String, Utilizador>();
        

        
        listu.put((m1).getEmail(), (m1).clone());
        listu.put((m2).getEmail(), (m2).clone());
        listu.put((m3).getEmail(), (m3).clone());
        listu.put((m4).getEmail(), (m4).clone());
        listu.put((m5).getEmail(), (m5).clone());
        listu.put((m6).getEmail(), (m6).clone());
        listu.put((m7).getEmail(), (m7).clone());
        listu.put((m8).getEmail(), (m8).clone());
        listu.put((m9).getEmail(), (m9).clone());
        listu.put((m10).getEmail(), (m10).clone());
        
        nCliente = 10;
        nMotorista = 10;
        
        /**
         * Taxis
         */
        
        HashMap<String, Taxi> listt = new HashMap<String, Taxi>();
        
        CarroLigeiro cl1 = new CarroLigeiro(60,1.5,0.8,"00-aa-00",m1,"cl1",co2);
        CarroLigeiro cl2 = new CarroLigeiro(65,1.25,0.5,"00-aa-03",m2,"cl2",co4);
        CarroLigeiro cl3 = new CarroLigeiro(55,1.75,1.2,"00-aa-04",m5,"cl3",co5);
        CarroLigeiro cl4 = new CarroLigeiro(65,0.8,1,"00-aa-05",m8,"cl4",co8);
        CarroLigeiro cl5 = new CarroLigeiro(62,2,0.9,"00-aa-09",m10,"cl5",co1);
        
        Carrinha c91 = new Carrinha(45,2.5,1,"00-aa-01",m6,"c91",co6);
        Carrinha c92 = new Carrinha(50,3,1,"00-aa-02",m7,"c92",co7);
        Carrinha c93 = new Carrinha(55,2.25,2,"00-aa-08",m9,"c92",co10);
        
        Mota mt1 = new Mota(80,3,1,"00-aa-06",m3,"mt1",co3);
        Mota mt2 = new Mota(70,3,1,"00-aa-07",m4,"mt2",co9);
        
        listt.put(cl1.getIdTaxi(), cl1.clone());
        listt.put(cl2.getIdTaxi(), cl2.clone());
        listt.put(cl3.getIdTaxi(), cl3.clone());
        listt.put(cl4.getIdTaxi(), cl4.clone());
        listt.put(cl5.getIdTaxi(), cl5.clone());
        
        listt.put(c91.getIdTaxi(), c91.clone());
        listt.put(c92.getIdTaxi(), c92.clone());
        listt.put(c93.getIdTaxi(), c93.clone());
        
        listt.put(mt1.getIdTaxi(), mt1.clone());
        listt.put(mt2.getIdTaxi(), mt2.clone());
        
        nCarroLig = 5;
        nCarrinha = 3;
        nMota = 2;
        
        /**           
         * 
         *  Viagem
         * Viagem(double tempoViagem, Coordenadas inicio, Coordenadas fim, double kmsP, Motorista motorista, String idTaxi, double custo, GregorianCalendar dataViagem)
           */
        GregorianCalendar data1 = new GregorianCalendar(2017,4,30,14,30);
        GregorianCalendar data2 = new GregorianCalendar(2017,5,2,17,30);
        GregorianCalendar data3 = new GregorianCalendar(2017,5,3,19,31);
        GregorianCalendar data4 = new GregorianCalendar(2017,5,3,19,40);
        GregorianCalendar data5 = new GregorianCalendar(2017,5,3,19,45);
        GregorianCalendar data6 = new GregorianCalendar(2017,5,3,20,40);
        GregorianCalendar data7 = new GregorianCalendar(2017,5,3,21,30);
        GregorianCalendar data8 = new GregorianCalendar(2017,5,3,23,20);
        
        ArrayList<Viagem> listaV = new ArrayList<Viagem>();  
        ArrayList<Viagem> listaV1 = new ArrayList<Viagem>();
        ArrayList<Viagem> listaV2 = new ArrayList<Viagem>(); 
        ArrayList<Viagem> listaV3 = new ArrayList<Viagem>();
        ArrayList<Viagem> listaV4 = new ArrayList<Viagem>();
        ArrayList<Viagem> listaV5 = new ArrayList<Viagem>();
          
        Viagem v1 = new Viagem(12,co3,co2,3.4,m2,"cl2",4,data1);
        Viagem v2 = new Viagem(13,co5,co1,4.6,m3,"c93",5,data2);
        Viagem v3 = new Viagem(14,co4,co5,2.6,m2,"mt2",3,data5);
        Viagem v4 = new Viagem(15,co2,co4,1.7,m2,"cl4",2,data4);
        Viagem v5 = new Viagem(16,co1,co3,3.8,m3,"c92",7,data7);
        Viagem v6 = new Viagem(10,co10,co5,6.8,m5,"cl3",12,data8);
        
        listaV.add(v1);
        listaV.add(v2);
        listaV.add(v5);
        
        listaV1.add(v3);
        listaV1.add(v4);
        listaV1.add(v5);
          
        listaV2.add(v2);
        listaV2.add(v5);
        
        listaV3.add(v6);
        listaV3.add(v2);
        listaV3.add(v1);
        
        listaV4.add(v5);
        listaV4.add(v3);
        listaV4.add(v1);
        
        listaV5.add(v3);
        listaV5.add(v1);
        listaV5.add(v4);
 
        
        m2.setViagem(listaV5);
        m3.setViagem(listaV2);
        /**
         * 
         * Clientes
         * 
           */
        Cliente c1 = new Cliente("c0","a@","Ana","pass1","morada1",new GregorianCalendar(1,1,1992),listaV,co1,100);
        Cliente c2 = new Cliente("c1","b@","Jorge","pass2","morada2",new GregorianCalendar(2,2,1992),listaV1,co2,50);
        Cliente c3 = new Cliente("c2","Tiago@","Tiago","chocolate","fafe",new GregorianCalendar(1,1,1954),listaV2,co3,100);
        Cliente c4 = new Cliente("c3","Miguel@","Miguel","leite","joane",new GregorianCalendar(1,2,1949),listaV3,co4,50);
        Cliente c5 = new Cliente("c4","Antonio@","Antonio","vermelho","ermesinde",new GregorianCalendar(2,10,1965),listaV4,co5,100);
        Cliente c6 = new Cliente("c5","Mario@","Mario","azul","mindelo",new GregorianCalendar(12,12,1979),listaV5,co6,50);
        Cliente c7 = new Cliente("c7","g@","Ivo","pass7","morada7",new GregorianCalendar(3,8,1991),null,co4,10);
        Cliente c8 = new Cliente("c8","h@","Rita","pass8","morada8",new GregorianCalendar(4,5,1994),null,co3,100);
        Cliente c9 = new Cliente("c9","i@","Vitor","pass9","morada9",new GregorianCalendar(6,2,1996),null,co5,80);
        Cliente c10 = new Cliente("c10","j@","Carlos","pass10","morada10",new GregorianCalendar(1,2,1992),null,co6,120);
          
        listu.put((c1).getEmail(), (c1).clone());
        listu.put((c2).getEmail(), (c2).clone());
        listu.put((c3).getEmail(), (c3).clone());
        listu.put((c4).getEmail(), (c4).clone());
        listu.put((c5).getEmail(), (c5).clone());
        listu.put((c6).getEmail(), (c6).clone());
        listu.put((c7).getEmail(), (c7).clone());
        listu.put((c8).getEmail(), (c8).clone());
        listu.put((c9).getEmail(), (c9).clone());
        listu.put((c10).getEmail(), (c10).clone());
        
        /**
         * 
         * Lista Carros Ligeiros
         * 
           */
        ArrayList<Taxi> lcar = new ArrayList<Taxi>();
        lcar.add(cl1);
          
        
        /**
         * 
         * Lista Carrinhas
         * 
           */  
        ArrayList<Taxi> lc9 = new ArrayList<Taxi>();
        lc9.add(c91);
        
        
          /**
         * 
         * Lista Motas
         * 
           */  
        ArrayList<Taxi> lmotas = new ArrayList<Taxi>();
        lmotas.add(mt1);
        
        
        /**
         * 
         * Lista taxis disponiveis
         * 
           */
        ArrayList<Taxi> ldisp = new ArrayList<Taxi>();
        ldisp.add(cl1);
        ldisp.add(c91);
        
        
         /**
         * 
         * Lista taxis disponiveis
         * 
           */
        ArrayList<Taxi> lind = new ArrayList<Taxi>();
        lind.add(mt1);
        
        ArrayList<Taxi> lespera = new ArrayList<Taxi>();
        UMeR umer = new UMeR(listu, listt, lespera, ldisp, lind, nCarroLig, nCarrinha, nMota, nCliente,nMotorista);
        return umer;
        
    }
    
}