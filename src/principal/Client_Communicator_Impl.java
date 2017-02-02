package principal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Client_Communicator_Impl extends UnicastRemoteObject implements Client_Communicator {
	
	//1° On donne un pseudo au client de manière à pouvoir l'identifier
	private String pseudo;
	
	//2° Le pseudo est initialisé dans le constructeur
	public Client_Communicator_Impl(String p) throws RemoteException{
		super();
		this.pseudo = p;
	}
	
	//3° Il faut une méthode pour récupérer le pseudo
	public String get_pseudo()throws RemoteException{
		return this.pseudo;
	}
	
	//4° Une méthode "Remote" permet au serveur de réaliser des affichages sur le client
	public void envoyer_message(String message)throws RemoteException{
		System.out.println(message);
	}
}
