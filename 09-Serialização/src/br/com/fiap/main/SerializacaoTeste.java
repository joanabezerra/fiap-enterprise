package br.com.fiap.main;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import br.com.fiap.bean.Aluno;

public class SerializacaoTeste {

	
	public static void main(String[] args) throws Exception {
		
		// Escrever um objeto e um arquivo
		FileOutputStream file = new FileOutputStream("seila.txt");
		ObjectOutputStream output = new ObjectOutputStream(file);
		
		Aluno aluno = new Aluno("Sêrgio", 81516, true);
		
		output.writeObject(aluno);
		System.out.println("Serializando o objeto aluno.");
		
		output.close();
		file.close();
		
	}
	
}
