import java.io.*;
import java.net.*;

public class Chatserver {
    public static void main(String[] args) {
       try{
           System.out.println("Starting Server....");
           System.out.println("Server Started succesfully.....");
           System.out.println("Type your message here...");
           System.out.println("--------------------------");
           ServerSocket ss = new ServerSocket(1201);
           Socket s = ss.accept();

           DataInputStream din = new DataInputStream(s.getInputStream());
           DataOutputStream dout = new DataOutputStream(s.getOutputStream());
           
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
           String msgin = "",msgout="";
           
           while(!msgin.equals("end")){
               msgin = din.readUTF();
               System.out.println("Client :" + msgin);
               System.out.print("Server :");
               msgout = br.readLine();
               dout.writeUTF(msgout);
               dout.flush();
           }
       }
       catch(Exception e){   
           System.out.println("Error in client...!!!"); 
        }
    }
}