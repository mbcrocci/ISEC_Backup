import java.util.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author Jos�
 * Teste de Programa��o Distribu�da - 21/11/2011
 * Vers�o 1
 */
public class DistributedFactorial
{
    public static final String BCAST_ADDR = "255.255.255.255";
    public static final String COOPERATION_REQUEST = "JOIN";
    public static final int TIMEOUT = 1000; //msec.

    protected int number;
    protected boolean calculated;
    protected double result;  //Do tipo double por uma questao de capacidade    
    protected int UDPPort; 
    protected ServerSocket TCPSocket;
    protected List<Socket> workers;

        
    public DistributedFactorial(int number, int UDPPort, int TCPPort){
    
        // TODO - TODOS os atributos devem ser iniciados
        //...
    }
    
    @Override
    public void run()
    {
        //TODO - Verifica se o m�todo j� foi invocado...
        
        try{
            
            requestWorkers();
            acceptWorkers();
            
            //TODO
            //...
            
            startWorkers(); 
            waitPartialResults();
            
        }catch(Exception e){
            // TODO
            //...
        }        
        
        //TODO
        //...
    }

    public double getResult(){
        if(!calculated)
            return -1;
        
        return result;
    }

    public boolean isCalculated(){
        return calculated;
    }
    
    protected void requestWorkers() throws SocketException, IOException
    {      
        //TODO -	envia a mensagem COOPERATION_REQUEST+" "+TCPPort para BCAST_ADDR
        //		sem recorrer � serializa��o de objectos.
        //...
    }       
    
    protected void acceptWorkers() throws IOException
    {
        //TODO - Aguarda os pedidos de liga��o TCP em TCPPort.
        //...
        
        System.out.println("Numero de workers: " + getNumWorkers());
    }
                         
    protected int getNumWorkers(){ return workers.size(); }       
    
    protected void startWorkers() throws IOException
    {
        int i;
        ObjectOutputStream out;
        
        //TODO -    Envia o n�mero pretendido, o n�mero total de workers 
	//          e o �ndice (os �ndices come�am em 1) a cada worker.
        //...
    }
        
    protected void waitPartialResults() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in;
        
        //TODO -	No final, se tudo correu bem, result dever� ter o valor do 
	//		factorial pretendido.
	//...
        
    }
    
    protected void removeWorkers()
    {
        while(getNumWorkers() > 0){
            //TODO -	Fecha o socket associado ao primeiro worker na lista
            //          e retira-o.
            //...
        }
    }
                  
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        int TCPPort, UDPPort;
        int number;
        double result;
        
        if(args.length != 3){
            System.out.println("Sintaxe: java DistributedFactorial <value> <portoUDP> <portoTCP>");
            System.exit(1);
        }
        
        number = Integer.parseInt(args[0]);
        UDPPort = Integer.parseInt(args[1]);
        TCPPort = Integer.parseInt(args[2]);
                       
        DistributedFactorial factorial = new DistributedFactorial(number,UDPPort, TCPPort);
        
        //TODO - Inicia o processo de c�lculo distribu�do.
        //...

        //TODO - aguarda pela conclus�o da determina��o do valor do factorial.
        //...
   
        result = factorial.getResult();
        
        System.out.println();
        System.out.println("Factorial de " + number + " = " + result);        
    }
}
