import java.net.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


---------------------------------------------------------------
// Interface para os usuarios
public abstract class Usuario {

	private String papel;

	public String getName(){
		return papel;
	}

	public void setName(String papel){
		this.papel = papel;
	}
	
	public void abrir(){
		System.out.println("Você abriu login de "+getName());
	}

}

//Implementação de tipos de usuarios
public class Administrador extends Usuario{
	
	public Administrador(){
		setName("Administrador");
	}
	
}

public class Visitante extends Usuario{
	
	public Visitante(){
		setName("Visitante");
	}
	
}

public class Beneficiario extends Usuario{
	
	public Beneficiario(){
		setName("Beneficiario");
	}
	
}

// Método comum que utiliza o Factory Method
public class UsuarioFactory {
	
	public Usuario efetuarlogin(String tipo){		
		Usuario user = null;	

		if(tipo.equals("A")){
			return new Administrador();
		}else if(tipo.equals("V")){
			return new Visitante();
        }else if(tipo.equals("B")){
            return new Beneficiario
		}else 
		return null;
	}
	
}

import java.util.Scanner;
public class Cliente{
	public static void main (String[] args){
		Scanner ler = new Scanner(System.in);
		
		UsuarioFactory uf = new UsuarioFactory();
		Usuario usuario = null;

		System.out.println("Qual usuario você deseja logar? (A/ V/ B)");
		if(ler.hasNextLine()){
			String tipo = ler.nextLine();
			usuario = uf.efetuarloginlogin(tipo);
		}

		if(usuario != null){
			executar(usuario);
		} else System.out.println("Digite A ou V ou B...");
	}

	public static void executar(Usuario user){
		user.abrir();
	}	

}
