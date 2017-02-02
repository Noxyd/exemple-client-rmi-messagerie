package principal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Client_Communicator_Impl extends UnicastRemoteObject implements Client_Communicator {
	
	//1� On donne un pseudo au client de mani�re � pouvoir l'identifier
	private String pseudo;
	
	//2� Le pseudo est initialis� dans le constructeur
	public Client_Communicator_Impl(String p) throws RemoteException{
		super();
		this.pseudo = p;
	}
	
	//3� Il faut une m�thode pour r�cup�rer le pseudo
	public String get_pseudo()throws RemoteException{
		return this.pseudo;
	}
	
	//4� Une m�thode "Remote" permet au serveur de r�aliser des affichages sur le client
	public void envoyer_message(String message)throws RemoteException{
		System.out.println(message);
	}
}
