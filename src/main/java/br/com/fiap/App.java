package br.com.fiap;

import br.com.fiap.entity.Acessorio;
import br.com.fiap.entity.Associar;
import br.com.fiap.entity.Carro;
import br.com.fiap.entity.Modelo;
import br.com.fiap.service.impl.AcessorioServiceImpl;
import br.com.fiap.service.impl.AssociarServiceImpl;
import br.com.fiap.service.impl.CarroServiceImpl;
import br.com.fiap.service.impl.ModeloServiceImpl;

public class App {

	public static void main(String[] args) {
		
		CarroServiceImpl carroService = CarroServiceImpl.getInstance();
		ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		AssociarServiceImpl associarService = AssociarServiceImpl.getInstance();
		
		Modelo modelo = new Modelo("Goal QUADRADRO");
		modeloService.inserir(modelo);
		
		Acessorio acessorio1 = new Acessorio("Ar Condicionado");
		Acessorio acessorio2 = new Acessorio("SOM MUITO ALTO");
		
		acessorioService.inserir(acessorio1);
		acessorioService.inserir(acessorio2);
		
		Carro carro = new Carro ("ABC1234", "AMARELO CLARAO", "4320982321");
		carroService.inserir(carro);
		
		Associar associar1 = new Associar(carro, modelo, acessorio1);
		Associar associar2 = new Associar(carro, modelo, acessorio2);
		associarService.inserir(associar1);
		associarService.inserir(associar2);
		
		associarService.listar().forEach(System.out::println);
		}
}