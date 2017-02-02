package principal;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

//Client
public class Main {

	public static void main(String[] args) {
		
		String 	pseudo,
				message;
		Scanner sc = new Scanner(System.in);
		
		//1� On saisie un pseudo au client
		System.out.println("Saisir un pseudo :");
		pseudo = sc.nextLine();
		
		try {
			
			//2� On cr�e l'objet client en lui donnant un pseudo
			Client_Communicator_Impl client = new Client_Communicator_Impl(pseudo);
			
			//3� On r�cup�re la r�f�rence vers le serveur dans le registre RMI
			Server_Communicator serveur = (Server_Communicator)Naming.lookup("server-1");
			
			//4� Le client doit �tre inscrit sur le serveur (pr�sent dans sa liste de clients)
			serveur.inscription(client);
			
			//On ne veut pas que le serveur se ferme apr�s l'envoi d'un message
			while(true){
				
				//Le client saisie son message
				System.out.println("Saisir un message : ");
				message = sc.nextLine();
				
				//5� On utilise la m�thode d'envoi � tous du serveur pour envoyer son message
				serveur.envoyer_a_tous(pseudo, message);
				
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

}
