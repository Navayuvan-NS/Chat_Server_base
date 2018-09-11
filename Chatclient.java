import java.io.*;
import java.net.*;

public class Chatclient {
    public static void main(String[] args) {
       try{
           System.out.println("Starting client....");
           System.out.println("Client Started Successfully....");
           System.out.println("Type your message here...\n--------------------------");
           //System.out.println("");
           Socket s = new Socket("127.0.0.1",1201);
           //Socket s = ss.accept();
           
           DataInputStream din = new DataInputStream(s.getInputStream());
           DataOutputStream dout = new DataOutputStream(s.getOutputStream());
           
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
           String msgin = "",msgout="";
           
           while(!msgin.equals("end")){
               System.out.print("Client :");
               msgout = br.readLine();
               dout.writeUTF(msgout);
               msgin = din.readUTF();
               System.out.println("Server :" + msgin);
               //dout.flush();
           }
       }
       catch(IOException e){   
           System.out.println("Error in server...!!!"); 
        }
    }
    
    
}
