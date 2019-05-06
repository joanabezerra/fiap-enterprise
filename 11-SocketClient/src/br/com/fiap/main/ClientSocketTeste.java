package br.com.fiap.main;

import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.fiap.bean.Filme;
import br.com.fiap.bean.Genero;

public class ClientSocketTeste {
	
	public static void main(String[] args) throws Exception{
		
		// Criar um objeto e serializar na rede
		
		Filme filme = new Filme("Harry Potter", 190, Genero.AVENTURA);
		
		Socket socket = new Socket("localHost", 1234);
		
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		
		System.out.println("Serializando o filme.");
		output.writeObject(filme);
		
		output.close();
		socket.close();
		
	}

}
