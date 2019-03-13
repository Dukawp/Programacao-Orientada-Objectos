import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;

public class Menu {

    
    private static UMeR umer = TEST_UMER.povoar();
    public static void main(String[] args) throws ClassNotFoundException , IOException, ClassCastException{
            Scanner in = new Scanner(System.in);
            Scanner in2 = new Scanner(System.in);
            //initApp();
            boolean quit = false;
            String menuItem;
            do {
                  menuPrincipal();
                  System.out.print("Escolha  a opçao desejada: ");
                  menuItem = in.nextLine();
                  switch (menuItem) { 
                          case "1":   
                                login();
                                break;
                          case "2":      
                                registar();
                                break;

                          case "0":
                                quit = true;
                                break;
                          case "3":
                                System.out.println("Nome com que pretende gravar: ");
                                String opt = in2.nextLine();
                                umer.escreveObjUmer(opt);
  
                                System.out.print('\u000C');
                                System.out.println("Gravado com sucesso\n");
                                System.out.println("Pressione uma tecla para continuar!");
                                try
                                {
                                    System.in.read();
                                }  
                                catch(Exception en)
                                {}
                                break;
                          case "4":    
                                System.out.println("Nome do UmeR que pretende carregar: ");
                                opt = in2.nextLine();
                                //umer.carregaObjUmer(opt);
                                initApp(opt);
                                System.out.print('\u000C');
                                System.out.println("Carregado com sucesso\n");
                                System.out.println("Pressione uma tecla para continuar!");
                                try
                                {
                                    System.in.read();
                                }  
                                catch(Exception en)
                                {}
                                break;
                          case "5":
                                menuExtras();
                                break;
                          default:       
                                System.out.println("Escolha invalida.");
                  }
                }
            while (!quit);
            System.out.println("Cya");
            
    }
    public static void menuPrincipal(){
          System.out.print('\u000C');
          System.out.println(header());
          System.out.println("\t\t\tMENU PRINCIPAL");
          System.out.println("1* Login");
          System.out.println("2* Registar");
          System.out.println("3* Guardar estado inicial");
          System.out.println("4* Carregar estado");
          System.out.println("5* Extras");
          System.out.println("0* SAIR");
          
    }
        
    public static void menuExtras(){    
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        int numero;
        String idTaxi;
        GregorianCalendar inicio = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        boolean quit=false;
        do {
          System.out.print('\u000C');
          System.out.println("\tUMeR - Extras");
          System.out.println("1* Total facturado por uma viatura");
          System.out.println("2* 10 clientes que mais gastam");
          System.out.println("3* 5 motoristas que apresentam mais desvios");
          System.out.println("4* Ver numero de registos");
          System.out.println("0* Voltar atras");
        
         
             String menuItem = in2.nextLine();
                 switch (menuItem) {
                 case "0":
                     quit=true;
                     menuPrincipal();
                     break;
                 case "1":
                     System.out.println("Indique a primeira data:");
                     System.out.println("Ano:"); int ano = Integer.parseInt(in.nextLine());
                     System.out.println("Mês:"); int mes = Integer.parseInt(in.nextLine());
                     System.out.println("Dia:"); int dia = Integer.parseInt(in.nextLine());
                     System.out.println("Horas:"); int hora = Integer.parseInt(in.nextLine());
                     System.out.println("Minutos:"); int minuto = Integer.parseInt(in.nextLine());
                     inicio = new GregorianCalendar(ano,mes,dia,hora,minuto);
                     System.out.println("Indique a segunda data:");
                     System.out.println("Ano:"); ano = Integer.parseInt(in.nextLine());
                     System.out.println("Mês:"); mes = Integer.parseInt(in.nextLine());
                     System.out.println("Dia:"); dia = Integer.parseInt(in.nextLine());
                     System.out.println("Horas:"); hora = Integer.parseInt(in.nextLine());
                     System.out.println("Minutos:"); minuto = Integer.parseInt(in.nextLine());
                     fim = new GregorianCalendar(ano,mes,dia,hora,minuto);
                     System.out.println("Indique o ID do taxi");
                     idTaxi = in.nextLine();
                     double total = umer.totalFacturado(idTaxi,inicio,fim);
                     System.out.println("Total:");
                     System.out.println(total);
                     System.out.println("Pressione uma tecla para continuar!");
                     try
                     {
                         System.in.read();
                     }  
                     catch(Exception en){}
                     break;   
                 case "2":
                     System.out.println("Indique o numero de clientes que quer");
                     numero = in.nextInt();
                     imprimirClientesMaisGastam(numero);
                     break;
                 case "3":
                     System.out.println("Indique o numero de motoristas que quer");
                     numero = in.nextInt();
                     imprimirdesvios(numero);
                     break;
                 case "4":
                     System.out.println("Numero de clientes inscritos: ");
                     System.out.println(umer.getNCliente());
                     System.out.println("Numero de motoristas inscritos: ");
                     System.out.println(umer.getNMotorista());
                     System.out.println("Numero de carros ligeiros: ");
                     System.out.println(umer.getNCarroLig());
                     System.out.println("Numero de carrinhas 9 lugares: ");
                     System.out.println(umer.getNCarrinha());
                     System.out.println("Numero de motas: ");
                     System.out.println(umer.getNMota());
                     System.out.println("Pressione uma tecla para continuar!");
                     try
                     {
                        System.in.read();
                     } 
                     catch(Exception en)
                     {}
                 default:       
                       System.out.println("Escolha uma opção válida!");
                 }
         }while(!quit);
          
    }
    
    public static void registar(){
        String menuItem,menu1;
        String email, password, nome, morada,l, disponivel;
        double cordX, cordY;
        Coordenadas tempC = new Coordenadas();
        GregorianCalendar dataNascimento;
        Utilizador temp = null;
        boolean quit = false;
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        System.out.print('\u000C');
        System.out.println("\tUMeR");
        System.out.println("\tNovo Registo");
        do {
            System.out.println("Escolha o tipo de registo");
            System.out.println("1* Cliente");
            System.out.println("2* Motorista");
            menuItem = in2.nextLine();
            switch (menuItem) {
                    case "1": 
                          System.out.println("Escolheu Cliente");
                          temp = new Cliente();
                          System.out.println("");
                          System.out.println("");
                          System.out.println("Indique as Coordenadas !");
                          System.out.println("Coordenada x:");
                          cordX = Double.parseDouble(in.nextLine());
                          System.out.println("Coordenada y:");
                          cordY = Double.parseDouble(in.nextLine());
                          tempC.setCoord(cordX,cordY);
                          ((Cliente)temp).setPosicao(tempC);
                          quit = true;
                          break;
                    case "2":
                          System.out.println("Escolheu Motorista");
                          temp = new Motorista();
                          System.out.println("Disponibilidade para começar viagem?");
                          disponivel = in3.nextLine();
                          if(disponivel.equals("sim")){
                              ((Motorista)temp).setDisponivel(true);
                          }
                          else {
                              ((Motorista)temp).setDisponivel(false);
                          }
                          ((Motorista)temp).setDesvio(0);
                          quit = true;
                          break;
                    default:       
                          System.out.println("Escolha uma opção válida!");
            }
  
      } while (!quit);

        System.out.println("Insira o seu email:");
        email = in.nextLine();    
        temp.setEmail(email);
        System.out.println("Insira a sua password:");
        password = in.nextLine();    
        temp.setPassword(password);
        System.out.println("Insira o seu nome:");
        nome = in.nextLine();    
        temp.setNome(nome);
        System.out.println("Insira sua morada:");
        morada = in.nextLine();    
        temp.setMorada(morada);
        System.out.println("Insira data de nascimento:");
        System.out.println("Dia:"); int dia = Integer.parseInt(in.nextLine());
        System.out.println("Mês:"); int mes = Integer.parseInt(in.nextLine());
        System.out.println("Ano:"); int ano = Integer.parseInt(in.nextLine());
        dataNascimento = new GregorianCalendar(dia,mes,ano);
        temp.setdataNasc(dataNascimento);
        
        try {
            umer.registarUtilizador(temp);
            System.out.print('\u000C');
              System.out.println("\tRegisto concluido");
              System.out.println("Pressione uma tecla para continuar!");
              try
              {
                  System.in.read();
              }  
              catch(Exception en)
              {}
        } catch (ExisteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print('\u000C');
              System.out.println("\tRegisto Falahado");
              System.out.println("Pressione uma tecla para continuar");
              try
              {
                  System.in.read();
              }  
              catch(Exception ea)
              {
              }
        }
    }
    
    public static void login(){
        String email, password;
        System.out.println("INTRODUZA E-MAIL:");
        Scanner mail = new Scanner(System.in); 
        email = mail.nextLine();
        System.out.println("PASSWORD:");
        Scanner pass = new Scanner(System.in);
        password = pass.nextLine();
            
        try {
            umer.efetuarLogin(email, password);
            System.out.print('\u000C');
              System.out.println("\tLogin com sucesso");
              System.out.println("Pressione uma tecla para continuar!");
              try
              {
                  System.in.read();
              }  
              catch(Exception en)
              {}
              if (umer.isCliente())
                  menuCliente();
              else if (umer.isMotorista())
                  menuMotorista();
        } catch (ErroContaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print('\u000C');
              System.out.println("Pressione uma tecla para continuar");
              try
              {
                  System.in.read();
              }  
              catch(Exception ea)
              {}  
        }
        
    }
    public static void menuCliente(){
        Scanner in = new Scanner(System.in);
        GregorianCalendar inicio = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        boolean quit=false;
        do {
         System.out.print('\u000C');
         System.out.println("\tUMeR - Menu Cliente");
         System.out.println("1* Consultar viagens");
         System.out.println("2* Consultar viagens entre datas");
         System.out.println("3* Consultar coordenadas");
         System.out.println("4* Ver lista de taxis");
         System.out.println("5* Iniciar Viagem");
         System.out.println("0* TERMINAR SESSÃO");
         System.out.println("Opcao:");
         
        
         
             String menuItem = in.nextLine();
                 switch (menuItem) {
                 case "0":
                     umer.logout();
                     quit=true;
                     menuPrincipal();
                     break;
                 case "1":
                     imprimeListaViagens();
                     break;
                 case "2":
                     System.out.println("Indique a primeira data:");
                     System.out.println("Ano:"); int ano = Integer.parseInt(in.nextLine());
                     System.out.println("Mês:"); int mes = Integer.parseInt(in.nextLine());
                     System.out.println("Dia:"); int dia = Integer.parseInt(in.nextLine());
                     System.out.println("Horas:"); int hora = Integer.parseInt(in.nextLine());
                     System.out.println("Minutos:"); int minuto = Integer.parseInt(in.nextLine());
                     inicio = new GregorianCalendar(ano,mes,dia,hora,minuto);
                     System.out.println("Indique a segunda data:");
                     System.out.println("Ano:"); ano = Integer.parseInt(in.nextLine());
                     System.out.println("Mês:"); mes = Integer.parseInt(in.nextLine());
                     System.out.println("Dia:"); dia = Integer.parseInt(in.nextLine());
                     System.out.println("Horas:"); hora = Integer.parseInt(in.nextLine());
                     System.out.println("Minutos:"); minuto = Integer.parseInt(in.nextLine());
                     fim = new GregorianCalendar(ano,mes,dia,hora,minuto);
                     imprimeListaViagensEntreDatas(inicio,fim);
                     break;   
                 case "3":
                     imprimePos();
                     break;                        
                 case "4":
                     menuVerTaxis();
                     break;
                 case "5":
                     iniciarViagem();
                     break;
                 default:       
                       System.out.println("Escolha uma opção válida!");
                 }
         }while(!quit);
          
    }
    
    public static void menuMotorista(){
        Scanner in = new Scanner(System.in);
        GregorianCalendar inicio = new GregorianCalendar();
        GregorianCalendar fim = new GregorianCalendar();
        boolean quit=false;
        Taxi t = umer.taxiSessao();
        if(!umer.jatemTaxi()){
        do {
            System.out.print('\u000C');
            System.out.println("\tUMeR - Menu Motorista");
            System.out.println("1* Registar Taxi");
            System.out.println("0* TERMINAR SESSÃO");
            System.out.println("Opção:");
         
        
         
             String menuItem = in.nextLine();
                 switch (menuItem) {
                 case "0":
                     umer.logout();
                     quit=true;
                     break;
                 case "1":
                     registarTaxi();
                     quit=true;
                     break;                
                 default:       
                     System.out.println("Escolha uma opção válida!");
                 }
         }while(!quit);
        }
        else{
        do {
            System.out.print('\u000C');
            System.out.println("\tUMeR - Menu Motorista");
            System.out.println("1* Ver dados taxi");
            System.out.println("2* Consultar taxi posição");
            System.out.println("3* Consultar viagens");
            System.out.println("4* Consultar viagens entre datas");
            System.out.println("5* Trocar taxi");
            System.out.println("0* TERMINAR SESSÃO");
            System.out.println("Opção:");
         
        
         
             String menuItem = in.nextLine();
                 switch (menuItem) {
                 case "0":
                     umer.logout();
                     quit=true;
                     break;
                 case "1":
                     t = umer.taxiSessao();
                     System.out.println(t);
                     System.out.println("Pressione uma tecla para continuar!");
                     try
                          {
                              System.in.read();
                          }  
                          catch(Exception en)
                          {}
                     break;
                 case "2":
                     System.out.println("Posição do taxi: ");
                     System.out.println(t.getTaxPos());
                     System.out.println("Pressione uma tecla para continuar!");
                     try
                          {
                              System.in.read();
                          }  
                          catch(Exception en)
                          {}
                     break;
                 case "3":
                     imprimeListaViagensM();
                     break;
                 case "4":
                     System.out.println("Indique a primeira data:");
                     System.out.println("Ano:"); int ano = Integer.parseInt(in.nextLine());
                     System.out.println("Mês:"); int mes = Integer.parseInt(in.nextLine());
                     System.out.println("Dia:"); int dia = Integer.parseInt(in.nextLine());
                     System.out.println("Horas:"); int hora = Integer.parseInt(in.nextLine());
                     System.out.println("Minutos:"); int minuto = Integer.parseInt(in.nextLine());
                     inicio = new GregorianCalendar(ano,mes,dia,hora,minuto);
                     System.out.println("Indique a segunda data:");
                     System.out.println("Ano:"); ano = Integer.parseInt(in.nextLine());
                     System.out.println("Mês:"); mes = Integer.parseInt(in.nextLine());
                     System.out.println("Dia:"); dia = Integer.parseInt(in.nextLine());
                     System.out.println("Horas:"); hora = Integer.parseInt(in.nextLine());
                     System.out.println("Minutos:"); minuto = Integer.parseInt(in.nextLine());
                     fim = new GregorianCalendar(ano,mes,dia,hora,minuto);
                     imprimeListaViagensEntreDatas(inicio,fim);
                     break;  
                 case "5":
                     registarTaxi();
                     quit=true;
                     break;   
                 default:       
                     System.out.println("Escolha uma opção válida!");
                 }
         }while(!quit);
        }
    }
    
    public static void registarTaxi(){
        String menuItem;
        String matricula;
        double cordX, cordY;
        Coordenadas tempC = new Coordenadas();
        double velMKm, precoKm;
        Taxi temp = null;
        boolean quit = false;
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.print('\u000C');
        System.out.println("\tUMeR");
        System.out.println("\tNovo Taxi");   
       
        do {
            System.out.println("Escolha o tipo de Imovel");
            System.out.println("1* Carro Ligeiro");
            System.out.println("2* Carrinha 9 Lugares");
            System.out.println("3* Mota");
            menuItem = in2.nextLine();
            switch (menuItem) {
                    case "1": 
                          System.out.println("Escolheu Carro Ligeiro");
                          temp = new CarroLigeiro();
                                                   
                          quit = true;
                          break;
                    case "2":
                    
                          System.out.println("Escolheu Carrinha 9 Lugares");
                          temp = new Carrinha();
                          
                          quit = true;
                          break;
                          
                    case "3":
                          System.out.println("Escolheu Mota");
                          temp = new Mota();
                          
                          quit = true;
                          break;    
                          
                          default:       
                          System.out.println("Escolha uma opção válida!");
            }
  
      } while (!quit);
       System.out.println("");
       System.out.println("Indique as Coordenadas !");
       System.out.println("Coordenada x:");
       cordX = Double.parseDouble(in.nextLine());
       System.out.println("Coordenada y:");
       cordY = Double.parseDouble(in.nextLine());
       tempC.setCoord(cordX,cordY);
       temp.setTaxPos(tempC);
       
       System.out.println("Insira velocidade media por km");
       velMKm = Double.parseDouble(in.nextLine());
       temp.setVelMKm(velMKm);
       
       System.out.println("Preço por km:");
       precoKm = Double.parseDouble(in.nextLine());
       temp.setPrecoKm(precoKm);
       System.out.println("Matricula:");
       matricula = in.nextLine();
       temp.setMatricula(matricula);
        try {
            umer.trocarTaxi(temp);
            System.out.print('\u000C');
            System.out.println("\tRegisto concluido");
            System.out.println("Pressione uma tecla para continuar!");
              try
              {
                  System.in.read();
              }  
              catch(Exception en){}
            menuMotorista();
            } 
            catch (ExisteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print('\u000C');
              System.out.println("\tRegisto Falahado! Taxi já esta registado");
              System.out.println("Pressione uma tecla para continuar");
              try
              {
                  System.in.read();
              }  
              catch(Exception ea){}
            menuMotorista();
            }
            catch (SemAutorizacaoException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              System.out.print('\u000C');
              System.out.println("\tNao é um motorista");
              System.out.println("Pressione uma tecla para continuar");
              try
              {
                  System.in.read();
              }  
              catch(Exception ea){}
              //umer.logout();
      }
    }
      
    public static void iniciarViagem(){
        String menuItem, matricula;
        double cordX, cordY, tempoViagem, tempoPrevisto, classificacao, kms, transito;
        Coordenadas tempC = new Coordenadas();
        Coordenadas tempCF = new Coordenadas();
        Viagem viagem = new Viagem();
        boolean quit = false, cancelar = false;
        Taxi taxi = null;
        Motorista m = null;
        Random gerador = new Random();
        transito = 0.5 + (1.5-0.5) * gerador.nextDouble();
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.print('\u000C');
        System.out.println("\tUMeR");
        System.out.println("\tIniciar Viagem");
        do {
            System.out.print('\u000C');
            System.out.println("Preencha todas as opções antes de avançar!");
            System.out.println("1* Indicar coordenadas");
            System.out.println("2* Solicitar taxi mais proximo");
            System.out.println("3* Solicitar um taxi especifico");
            System.out.println("4* Ver valor estimado para a viagem e custos");
            System.out.println("5* Começar a viagem");
            System.out.println("0* Cancelar viagem");
            System.out.println("Opcão:");
            menuItem = in2.nextLine();
            switch (menuItem) {
                    case "1": 
                          System.out.print('\u000C');
                          System.out.println("Indicar Coordenadas de partida:");
                          System.out.println("Coordenada x:");
                          cordX = Double.parseDouble(in.nextLine());
                          System.out.println("Coordenada y:");
                          cordY = Double.parseDouble(in.nextLine());
                          
                          tempC.setCoord(cordX,cordY);

                          
                          System.out.println("Indicar Coordenadas do destino:");
                          System.out.println("Coordenada x:");
                          cordX = Double.parseDouble(in.nextLine());
                          System.out.println("Coordenada y:");
                          cordY = Double.parseDouble(in.nextLine());
                          
                          tempCF.setCoord(cordX,cordY);
                          
                          
                          break;
                          
                    case "2":
                          System.out.print('\u000C');
                          taxi = umer.taxiMaisProximo(tempC);
                          m = taxi.getMotorista();
                          System.out.println("Taxi mais proximo");
                          viagem.setMotorista(m);
                          viagem.setIdTaxi(taxi.getIdTaxi());
                          System.out.println("**Taxi**");
                          System.out.println(taxi.getClass());
                          System.out.println("Matricula: ");
                          System.out.println(taxi.getMatricula());
                          System.out.println("Coordenadas : ");
                          System.out.println(taxi.getTaxPos());
                          System.out.println("Condutor: ");
                          System.out.println(taxi.getMotorista().getNome());
                          System.out.println("Pressione uma tecla para continuar!");
                          try
                          {
                              System.in.read();
                          }  
                          catch(Exception en)
                          {}
                          break;
                    case "3":
                          System.out.println("Indique a matricula: ");
                          matricula = in.nextLine();
                          taxi = umer.getTaxi(matricula);
                          System.out.println("Pressione uma tecla para continuar!");
                          try
                          {
                              System.in.read();
                          }  
                          catch(Exception en)
                          {}
                          break;
                    case "4":
                          tempoPrevisto = umer.tempoFinal(taxi,tempCF,tempC);
                          viagem.setTempoViagem(tempoPrevisto);
                          kms = (umer.distanciaTotal(taxi, tempCF,tempC) - umer.distanciaCT(taxi,tempC));
                          viagem.setKmsp(kms);
                          viagem.setCusto(kms* taxi.getPrecoKm());
                          System.out.print('\u000C');
                          System.out.println("Tempo previsto: ");
                          System.out.println(viagem.getTempoViagem());
                          System.out.println("Kms a percorrer: ");
                          System.out.println(viagem.getKmsP());
                          System.out.println("Custo: ");
                          System.out.println(viagem.getCusto());
                          System.out.println("Pressione uma tecla para continuar!");
                          try
                          {
                              System.in.read();
                          }  
                          catch(Exception en)
                          {}
                          break;
                          
                    case "5":
                          
                          quit=true;
                          break;
                          
                    case "6": 
                          imprimeMota();
                          break;
                          
                    case "7":
                          imprimeCarroLig();
                          break;
                    case "8":
                          imprimeTaxisDisponiveis();
                          break;
                        
                    case "0":
                          menuCliente();
                          cancelar = true;
                          quit=true;
                          break;
                          
                    default:       
                          System.out.println("Escolha uma opção válida!");
            }
  
      } while (!quit);
      //try{
          if(!cancelar){
            kms = (umer.distanciaTotal(taxi, tempCF,tempC) - umer.distanciaCT(taxi,tempC));
            viagem.setKmsp(kms);
            viagem.setCusto(kms* taxi.getPrecoKm());
                 
            GregorianCalendar now = new GregorianCalendar();

            viagem.setDataViagem(now);
            m = taxi.getMotorista();
            System.out.print('\u000C');
            tempoPrevisto = umer.tempoFinal(taxi,tempCF,tempC);
            tempoViagem = umer.tempoFinalReal(taxi,tempCF,tempC,transito);
            viagem.setTempoViagem(tempoViagem);  
            viagem.setInicio(tempC);
            viagem.setFim(tempCF);
            System.out.println("Tempo final da viagem:");
            System.out.println(viagem.getTempoViagem());
            if(tempoViagem<=tempoPrevisto){
                System.out.println("Viagem dentro do previsto com custo de: "+ viagem.getCusto());
                taxi.getMotorista().setGrauC(100);
            }
            else{
                System.out.println("Devido ao atrasado o custo da viagem é:");
                viagem.setCusto((taxi.getFiabilidade() * viagem.getCusto())/2);
                System.out.println(viagem.getCusto());
                taxi.getMotorista().setDesvio(1);
                taxi.getMotorista().setGrauC(0);
            }
              
            System.out.println("Avalie o Motorista (0-5)");
            classificacao = Double.parseDouble(in.nextLine());
            m.setClassificacao(classificacao);
            m.setKms(umer.distanciaTotal(taxi,tempCF,tempC)); 
            taxi.setTaxPos(tempCF);
            Cliente cliente = (Cliente)umer.getSessao().clone();
            cliente.addViagem(viagem.clone());
            m.addViagem(viagem.clone());
            System.out.print('\u000C');
              System.out.println("\tViagem registada");
              System.out.println("Pressione uma tecla para continuar!");
              try
              {
                  System.in.read();
              }  
              catch(Exception en)
              {}
            }
       //
        /*catch (SemAutorizacaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.print('\u000C');
              System.out.println("\tViagem nao esta registada");
              System.out.println("Pressione uma tecla para continuar");
              try
              {
                  System.in.read();
              }  
              catch(Exception ea)
              {}
        }*/

    }
    
    public static void menuVerTaxis(){
        Scanner in = new Scanner(System.in);
        boolean quit=false;
        do {
         System.out.print('\u000C');
         System.out.println("\tUMeR - Menu listas de Taxis");
         System.out.println("1* Ver taxis disponiveis");
         System.out.println("2* Ver taxis indisponiveis");
         System.out.println("3* Ver carros ligeiros");
         System.out.println("4* Ver carrinhas");
         System.out.println("5* Ver motas");
         System.out.println("0* Voltar atras");
         System.out.println("Opcao:");
         
        
         
             String menuItem = in.nextLine();
                 switch (menuItem) {
                 case "0":
                     quit=true;
                     menuCliente();
                     break;
                 case "1":
                     imprimeTaxisDisponiveis(); 
                     break;
                 case "2":
                     imprimeTaxisNDisponiveis();
                     break;
                 case "3":
                     imprimeCarroLig();
                     break;
                 case "4":
                     imprimeCarrinha();
                     break;
                 case "5":
                     imprimeMota();
                     break;    
                 default:       
                       System.out.println("Escolha uma opção válida!");
                 }
         }while(!quit);
          
    }
    
    
    public static void imprimePos(){
        System.out.println("");
        System.out.println("Posicao onde esta: ");
        Coordenadas c = umer.getPosSessao();
        System.out.println(c.toString());
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void imprimeTaxisDisponiveis(){
        List<Taxi> tax = umer.getListaDisp();
        System.out.println("Lista taxis disponiveis"); 
        System.out.println("TOTAL DE TAXIS: " + tax.size() );
        for(Taxi t : tax){
            System.out.println(t.toString());
        }
        System.out.println("Pressione uma tecla para continuar!");
        try{
            System.in.read();
        } 
        catch(Exception en){en.printStackTrace();} 
    }

    public static void imprimirClientesMaisGastam(int numero){
        TreeSet<Cliente> tsc = umer.listaClientesMaisGastam();
        int i = 0;
        for(Cliente c: tsc){
            if(i < numero){
                i++;
                System.out.println(c.toString());
            }
        }
        
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void imprimeListaViagens(){
        List<Viagem> vs = ((Cliente)umer.getSessao()).getViagens();
        System.out.println("Lista Viagens");  
        System.out.println("TOTAL DE VIAGENS: " + vs.size() );
        for(Viagem v : vs){
            System.out.println(v.toString());
        }
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void imprimirdesvios(int numeroM){
        TreeSet<Motorista> tsm = umer.getMaisDesvios();
        int i=0;
        for(Motorista m : tsm){
            if(i < numeroM){
                i++;
                System.out.println(m.toString());
            }
        }
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void imprimeListaViagensEntreDatas(GregorianCalendar inicio, GregorianCalendar fim){
        ArrayList<Viagem> vs = umer.viagensEntreDatas(inicio, fim);
        System.out.println("Lista Viagens");  
        System.out.println("TOTAL DE VIAGENS: " + vs.size() );
        for(Viagem v : vs){
            System.out.println(v.toString());
        }
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void imprimeListaViagensM(){
        List<Viagem> vs = ((Motorista)umer.getSessao()).getViagens();
        System.out.println("Lista Viagens");  
        System.out.println("TOTAL DE VIAGENS: " + vs.size() );
        for(Viagem v : vs){
            System.out.println(v.toString());
        }
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void imprimeTaxisNDisponiveis(){
        List<Taxi> tax;
        System.out.println("Lista Taxis indisponiveis");
        tax = umer.getListaInd();
        System.out.println("TOTAL DE TAXIS: " + tax.size() );
        for(Taxi t : tax){
            System.out.println(t.toString());
        }
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void imprimeCarroLig(){
        List<Taxi> tax;
        System.out.println("Lista Carro ligeiro");
        tax = umer.getListaCarroLig();
        System.out.println("TOTAL DE TAXIS: " + tax.size() );
        for(Taxi t : tax){
            System.out.println(t.toString());
        }
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void imprimeCarrinha(){
        List<Taxi> tax;
        System.out.println("Lista carrinhas");
        tax = umer.getListaCarrinha();
        System.out.println("TOTAL DE TAXIS: " + tax.size() );
        for(Taxi t : tax){
            System.out.println(t.toString());
        }
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void imprimeMota(){
        List<Taxi> tax;
        System.out.println("Lista mota");
        tax = umer.getListaMota();
        System.out.println("TOTAL DE TAXIS: " + tax.size() );
        for(Taxi t :tax){
            System.out.println(t.toString());
        }
        System.out.println("Pressione uma tecla para continuar!");
        try
        {
            System.in.read();
        } 
        catch(Exception en)
        {}
    }
    
    public static void initApp(String s1){
        try{
              umer = umer.carregaObjUmer(s1);
            }
            catch (IOException e) {
            umer = new UMeR();
            System.out.println("Não consegui ler os dados!\nErro de leitura.");
        } 
        catch (ClassNotFoundException e) {
            umer = new UMeR();
            System.out.println("Não consegui ler os dados!\nFicheiro com formato desconhecido.");
        }
        catch (ClassCastException e) {
            umer = new UMeR();
            System.out.println("Não consegui ler os dados!\nErro de formato.");        
        }
     
    }
    
    public static String header(){
        StringBuilder s = new StringBuilder();
        /*
        s.append("       __  __     __    __     ______     ______    \n");
        s.append("      /\ \/\ \   /\ "-./  \   /\  ___\   /\  == \   \n");
        s.append("      \ \ \_\ \  \ \ \-./\ \  \ \  __\   \ \  __<   \n");
        s.append("       \ \_____\  \ \_\ \ \_\  \ \_____\  \ \_\ \_\ \n");
        s.append("        \/_____/   \/_/  \/_/   \/_____/   \/_/ /_/ \n");
        */
          
        s.append("              :::    :::   :::   :::   :::::::::: :::::::::    \n");
        s.append("             :+:    :+:  :+:+: :+:+:  :+:        :+:    :+:    \n");
        s.append("            +:+    +:+ +:+ +:+:+ +:+ +:+        +:+    +:+     \n");
        s.append("           +#+    +:+ +#+  +:+  +#+ +#++:++#   +#++:++#:       \n");
        s.append("          +#+    +#+ +#+       +#+ +#+        +#+    +#+       \n");
        s.append("         #+#    #+# #+#       #+# #+#        #+#    #+#        \n");
        s.append("         ########  ###       ### ########## ###    ###      \n");
         
        return s.toString();
     }
            
    
}