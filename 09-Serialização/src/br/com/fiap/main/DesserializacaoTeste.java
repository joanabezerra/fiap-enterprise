package br.com.fiap.main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import br.com.fiap.bean.Aluno;

public class DesserializacaoTeste {

	public static void main(String[] args) throws Exception{
		
		// Ler o arquivo e recuperar o objeto aluno
		FileInputStream file = new FileInputStream("seila.txt");
		ObjectInputStream input = new ObjectInputStream(file);
		
		Aluno aluno = (Aluno) input.readObject();
		
		System.out.println("Nome: " + aluno.getNome());
		System.out.println("RM: " + aluno.getRm());
		System.out.println("Formado: " + (aluno.isFormato() ? "Sim" : "Não"));
		
		input.close();
		file.close();
		
	}
	
}
