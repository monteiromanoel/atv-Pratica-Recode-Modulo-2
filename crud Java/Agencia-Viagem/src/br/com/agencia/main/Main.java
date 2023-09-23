package br.com.agencia.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.agencia.DAO.ClienteDAO;
import br.com.agencia.DAO.ReservaDAO;
import br.com.agencia.DAO.ViagemDAO;
import br.com.agencia.model.Cliente;
import br.com.agencia.model.Reserva;
import br.com.agencia.model.Viagem;

public class Main {
	
	public static void exibirMenu() {
        Scanner entrada = new Scanner(System.in);
        int escolha;


    	System.out.println("************************");
    	System.out.println("** AGÊNCIA DE VIAGENS **");
    	System.out.println("**** ACESSO CLIENTE ****");
    	System.out.println("************************");
        System.out.println("Selecione uma opção:");
        System.out.println("1. CADASTRO");
        System.out.println("2. LOGIN");
        System.out.println("3. VER PACOTES");
        System.out.println("4. VER PROMOÇÕES");
        
        System.out.println("");
        System.out.println("*** ACESSO ADMINISTRADOR ***");
        System.out.println("5. CLIENTES");
        System.out.println("6. VIAGENS");
        System.out.println("7. RESERVAS");
        System.out.println("0. SAIR");
        escolha = entrada.nextInt();

        switch (escolha) {
            case 1:
                menuCadastro();
                break;
            case 2:
                menuLogin();
                break;
            case 3:
                menuPacotes();
                break;
            case 4:
            	menuPromocoes();
                break;
            case 5: 
            	menuClientes();
            	break;
            case 6: 
            	menuViagens();
            	break;
            case 7: 
            	menuReservas();
            	break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        entrada.close();
    }
	
	public static void menuClientes() {
		Scanner entrada = new Scanner(System.in);
        int escolha;
        int escolha2 = 0;
        int escolha3 = 0;
        Cliente cliente = new Cliente();
        ClienteDAO clienteDao = new ClienteDAO();


    	System.out.println("************************");
    	System.out.println("** AGÊNCIA DE VIAGENS **");
    	System.out.println("***  ADMINISTRADOR  ***");
    	System.out.println("************************");
        System.out.println("Selecione uma opção:");
        System.out.println("1. VER CLIENTES");
        System.out.println("2. CADASTRAR CLIENTE");
        System.out.println("3. ATUALIZAR DADOS");
        System.out.println("4. DELETAR CLIENTE");
        System.out.println("0. SAIR");
        System.out.println("");
        
        escolha = entrada.nextInt();
        
        switch (escolha) {
            case 1:
            	System.out.println("CLIENTES CADASTRADOS NO SISTEMA");
            	System.out.println("");
                for(Cliente c:clienteDao.getClientes()) {
                	System.out.println("ID: " + c.getId());
		        	System.out.println("Nome: " + c.getNome());
		        	System.out.println("Email " + c.getEmail());
		        	System.out.println("Endereço: " + c.getLogradouro() + ", " + "CEP: " + c.getCep());
		        	System.out.println("Cidade: " + c.getCidade() + "/ " + c.getUf());
		        	String telefone = c.getTelefone();
		        	String telefoneFormatado = formatarTelefone(telefone);
		        	System.out.println("Telefone: " + telefoneFormatado);
		        	System.out.println("---------");
                }
                System.out.println("1. Voltar / 2. Voltar ao Menu Principal");
	        	escolha2 = entrada.nextInt();
	        	switch(escolha2) {
	        	case 1:
	        		menuClientes();
	        		break;
	        	case 2:
	        		exibirMenu();
	        		break;
	        	default:
	        		System.out.println("Opção Inválida");
	        	}
                break;
            case 2:
            		System.out.println("CADASTRAR NOVO CLIENTE");
                	System.out.println("");
                	String inputString = entrada.nextLine();
                    ClienteDAO clienteDao2 = new ClienteDAO();
                    Cliente cliente2 = new Cliente();
                    
                    System.out.println("Nome: ");
                    inputString = entrada.nextLine();
                    cliente2.setNome(inputString);
                    
                    System.out.println("Email: ");
                    inputString = entrada.nextLine();
                    cliente2.setEmail(inputString);
                    
                    System.out.println("Senha: ");
                    inputString = entrada.nextLine();
                    cliente2.setSenha(inputString);
                    
                    System.out.println("Logradouro: ");
                    inputString = entrada.nextLine();
                    cliente2.setLogradouro(inputString);
                    
                    System.out.println("CEP: ");
                    inputString = entrada.nextLine();
                    cliente2.setCep(inputString);
                    
                    System.out.println("Cidade: ");
                    inputString = entrada.nextLine();
                    cliente2.setCidade(inputString);
                    
                    System.out.println("UF: ");
                    inputString = entrada.nextLine();
                    cliente2.setUf(inputString);
                    
                    System.out.println("Telefone: ");
                    inputString = entrada.nextLine();
                    cliente2.setTelefone(inputString);
                    
                    System.out.println("Documento: ");
                    inputString = entrada.nextLine();
                    cliente2.setDocumento(inputString);
                    
                    System.out.println("Data de Nascimento (DD/MM/AAAA): ");
                    inputString = entrada.nextLine();
                    cliente2.setData_nasc(inputString);
                    
                    System.out.println("");
                    System.out.println("Confirme os dados: ");
                    System.out.println("");
                    System.out.println("Nome: " + cliente2.getNome());
                    System.out.println("Email: " + cliente2.getEmail());
                    System.out.println("Senha: " + cliente2.getSenha());
                    System.out.println("Endereço: " + cliente2.getLogradouro() + ", CEP: " + cliente2.getCep());
                    System.out.println("Cidade: " + cliente2.getCidade() + "/ " + cliente2.getUf());
                    String telefone = cliente2.getTelefone();
                    System.out.println("Telefone: " + telefone);
                    System.out.println("Documento: " + cliente2.getDocumento());
                    System.out.println("Data de Nasc: " + cliente2.getData_nasc());
                    
                    System.out.println("");
                    System.out.println("Salvar? 1. Sim / 2. Não");
                    escolha3 = entrada.nextInt();
                    switch(escolha3) {
                    case 1: 
                    	try {
                    		clienteDao2.cadastrarCliente(cliente2);
                    		System.out.println("Cliente salvo com sucesso!");
                    		System.out.println("");
                    		menuClientes();
                    	}catch(Exception e) {
                    		System.out.println("Houve algum problema");
                    	}
                    	break;
                    case 2:
                    	menuClientes();
                    	break;
                    default:
                    	System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
            case 3:
            	System.out.println("**** ATUALIZAR CADASTRO DO CLIENTE ***");
	    	    System.out.println("Caso algum dado não mudou, basta digita-lo novamente.");
		    	   try {
		    		   Cliente c1 = new Cliente();
		    		   
		    		   System.out.println("Insira o ID do usuário a atualizar: ");
		    		   int inputInt = entrada.nextInt();
		    		   System.out.println("");
		    		   
		    		   String inputString2 = entrada.nextLine();
		    		   
		    		   System.out.println("Insira o nome a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setNome(inputString2);
		    		   
		    		   System.out.println("Insira o email a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setEmail(inputString2);
		    		   
		    		   System.out.println("Insira a senha a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setSenha(inputString2);
		    		   
		    		   System.out.println("Insira o logradouro a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setLogradouro(inputString2);
		    		   
		    		   System.out.println("Insira o CEP a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setCep(inputString2);
		    		   
		    		   System.out.println("Insira a cidade a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setCidade(inputString2);
		    		   
		    		   System.out.println("Insira o estado (UF) a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setUf(inputString2);
		    		   
		    		   System.out.println("Insira um telefone a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setTelefone(inputString2);
		    		   
		    		   System.out.println("Insira um Documento (CPF) a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setDocumento(inputString2);
		    		   
		    		   System.out.println("Insira uma data de nascimento (DD/MM/AAAA) a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setData_nasc(inputString2);
		    		   
		    		   c1.setId(inputInt);
		    		   
		    		   System.out.println("");
	                    System.out.println("Confirme os dados: ");
	                    System.out.println("");
	                    System.out.println("Nome: " + c1.getNome());
	                    System.out.println("Email: " + c1.getEmail());
	                    System.out.println("Senha: " + c1.getSenha());
	                    System.out.println("Endereço: " + c1.getLogradouro() + ", CEP: " + c1.getCep());
	                    System.out.println("Cidade: " + c1.getCidade() + "/ " + c1.getUf());
	                    telefone = c1.getTelefone();
	                    System.out.println("Telefone: " + telefone);
	                    System.out.println("Documento: " + c1.getDocumento());
	                    System.out.println("Data de Nasc: " + c1.getData_nasc());
	                    
	                    System.out.println("");
	                    System.out.println("Salvar? 1. Sim / 2. Não");
	                    escolha3 = entrada.nextInt();
	                    switch(escolha3) {
	                    case 1: 
	                    	try {
	                    		clienteDao.atualizarPorId(c1);
	                    		System.out.println("Cliente atualizado com sucesso!");
	                    		System.out.println("");
	                    		menuClientes();
	                    	}catch(Exception e) {
	                    		System.out.println("Houve algum problema");
	                    	}
	                    	break;
	                    case 2:
	                    	menuClientes();
	                    	break;
	                    default:
	                    	System.out.println("Opção inválida. Tente novamente.");
	                    }
	                    break;
	   
		    	   } catch (Exception e) {
		    		   System.out.println("Algum dado com erro.");
		    	   }
                break;
            case 4:
            	System.out.println("**** EXCLUIR CADASTRO DO CLIENTE ***");
	    	    System.out.println("Lembre-se, não há volta na exclusão");
	    	    System.out.println("");
	    	    System.out.println("Informe o ID do cliente a excluir");
	    	    int inputInt = entrada.nextInt();
	    	    System.out.println("");
	    	    System.out.println("DADOS DO CLIENTE");
	    	    
	    	    for(Cliente c:clienteDao.getClienteById(inputInt)) {
                	System.out.println("ID: " + c.getId());
		        	System.out.println("Nome: " + c.getNome());
		        	System.out.println("Email " + c.getEmail());
		        	System.out.println("Endereço: " + c.getLogradouro() + ", " + "CEP: " + c.getCep());
		        	System.out.println("Cidade: " + c.getCidade() + "/ " + c.getUf());
		        	telefone = c.getTelefone();
		        	String telefoneFormatado = formatarTelefone(telefone);
		        	System.out.println("Telefone: " + telefoneFormatado);
		        	System.out.println("---------");
                }
	    	    
	    	    System.out.println("Excluir cliente? 1. Sim / 2. Não");
	    	    escolha3 = entrada.nextInt();
                switch(escolha3) {
                case 1: 
                	try {
                		clienteDao.deletarPorId(inputInt);
                		System.out.println("Cliente excluído com sucesso!");
                		System.out.println("");
                		menuClientes();
                	}catch(Exception e) {
                		System.out.println("Houve algum problema");
                	}
                	break;
                case 2:
                	menuClientes();
                	break;
                default:
                	System.out.println("Opção inválida. Tente novamente.");
                }
                break;
            case 0:
                exibirMenu();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        
	}
	
	
	public static void menuViagens() {
		Scanner entrada = new Scanner(System.in);
        int escolha;
        int escolha2 = 0;
        int escolha3 = 0;
        int escolha4=0;
        Viagem viagem= new Viagem();
        ViagemDAO viagemDao = new ViagemDAO();


    	System.out.println("************************");
    	System.out.println("** AGÊNCIA DE VIAGENS **");
    	System.out.println("***  ADMINISTRADOR  ***");
    	System.out.println("************************");
        System.out.println("Selecione uma opção:");
        System.out.println("1. VER VIAGENS");
        System.out.println("2. CADASTRAR VIAGEM");
        System.out.println("3. ATUALIZAR DADOS");
        System.out.println("4. DELETAR VIAGEM");
        System.out.println("0. SAIR");
        System.out.println("");
        
        escolha = entrada.nextInt();
        
        switch (escolha) {
            case 1:
            	System.out.println("VIAGENS CADASTRADOS NO SISTEMA");
            	System.out.println("");
                for(Viagem v:viagemDao.getViagens()) {
                	System.out.println("ID: " + v.getId());
		        	System.out.println("Destino: " + v.getDestino());
		        	System.out.println("Preço: R$" + v.getPreco());
		        	System.out.println("Data da Ída: " + v.getData_ida());
		        	System.out.println("Data da Volta: " + v.getData_volta());
		        	System.out.println("Descrição: " + v.getDescricao());
		        	System.out.println("Adicional: " + v.getAdicional());		        	
		        	System.out.println("Tipo do Pacote: " + v.getTipo_pacote());
		        	System.out.println("---------");
                }
                System.out.println("1. Voltar / 2. Voltar ao Menu Principal");
	        	escolha2 = entrada.nextInt();
	        	switch(escolha2) {
	        	case 1:
	        		menuViagens();
	        		break;
	        	case 2:
	        		exibirMenu();
	        		break;
	        	default:
	        		System.out.println("Opção Inválida");
	        	}
                break;
            case 2:
            		System.out.println("CADASTRAR NOVA VIAGEM");
                	System.out.println("");
                	String inputString4 = entrada.nextLine();
                    ViagemDAO viagemDao2 = new ViagemDAO();
                    Viagem viagem2 = new Viagem();
                    
                    System.out.println("Destino: ");
                    inputString4 = entrada.nextLine();
                    viagem2.setDestino(inputString4);
                    
                    System.out.println("Preço: ");
                    double inputDouble = entrada.nextDouble();
                    viagem2.setPreco(inputDouble);
                    entrada.nextLine();
                    
                    System.out.println("Data da Ída (DD/MM/AAAA): ");
                    inputString4 = entrada.nextLine();
                    viagem2.setData_ida(inputString4);
                    
                    System.out.println("Data da Volta (DD/MM/AAAA): ");
                    inputString4 = entrada.nextLine();
                    viagem2.setData_volta(inputString4);
                    
                    System.out.println("Descrição: ");
                    inputString4 = entrada.nextLine();
                    viagem2.setDescricao(inputString4);
                    
                    System.out.println("Adicional: ");
                    inputString4 = entrada.nextLine();
                    viagem2.setAdicional(inputString4);
                    
                    System.out.println("Tipo do Pacote: ");
                    System.out.println("1. Convencional / 2. Promocional");
                    escolha4=entrada.nextInt();
                    
                    switch(escolha4) {
                    case 1: 
                    	inputString4 = "convencional";
                    	viagem2.setTipo_pacote(inputString4);
                    	break;
                    case 2: 
                    	inputString4 = "promocional";
                    	viagem2.setTipo_pacote(inputString4);
                    	break;
                    default:
                    	System.out.println("Opção Inválida");
                    }                                        
                 
                    
                    System.out.println("");
                    System.out.println("Confirme os dados: ");
                    System.out.println("");
                    System.out.println("Destino: " + viagem2.getDestino());
                    System.out.println("Preço: R$" + viagem2.getPreco());
                    System.out.println("Data da Ída: " + viagem2.getData_ida());
                    System.out.println("Data da Volta: " + viagem2.getData_volta());
                    System.out.println("Descrição: " + viagem2.getDescricao());
                    System.out.println("Adicional: " + viagem2.getAdicional());
                    System.out.println("Tipo do Pacote: " + viagem2.getTipo_pacote());                
                    
                    System.out.println("");
                    System.out.println("Salvar? 1. Sim / 2. Não");
                    escolha3 = entrada.nextInt();
                    switch(escolha3) {
                    case 1: 
                    	try {
                    		viagemDao2.salvarViagem(viagem2);
                    		System.out.println("Viagem salva com sucesso!");
                    		System.out.println("");
                    		menuClientes();
                    	}catch(Exception e) {
                    		System.out.println("Houve algum problema");
                    	}
                    	break;
                    case 2:
                    	menuViagens();
                    	break;
                    default:
                    	System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
            case 3:
            	System.out.println("**** ATUALIZAR CADASTRO DO CLIENTE ***");
	    	    System.out.println("Caso algum dado não mudou, basta digita-lo novamente.");
		    	   try {
		    		   Cliente c1 = new Cliente();
		    		   
		    		   System.out.println("Insira o ID do usuário a atualizar: ");
		    		   int inputInt = entrada.nextInt();
		    		   System.out.println("");
		    		   
		    		   String inputString2 = entrada.nextLine();
		    		   
		    		   System.out.println("Insira o nome a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setNome(inputString2);
		    		   
		    		   System.out.println("Insira o email a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setEmail(inputString2);
		    		   
		    		   System.out.println("Insira a senha a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setSenha(inputString2);
		    		   
		    		   System.out.println("Insira o logradouro a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setLogradouro(inputString2);
		    		   
		    		   System.out.println("Insira o CEP a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setCep(inputString2);
		    		   
		    		   System.out.println("Insira a cidade a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setCidade(inputString2);
		    		   
		    		   System.out.println("Insira o estado (UF) a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setUf(inputString2);
		    		   
		    		   System.out.println("Insira um telefone a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setTelefone(inputString2);
		    		   
		    		   System.out.println("Insira um Documento (CPF) a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setDocumento(inputString2);
		    		   
		    		   System.out.println("Insira uma data de nascimento (DD/MM/AAAA) a modificar: ");
		    		   inputString2 = entrada.nextLine();
		    		   c1.setData_nasc(inputString2);
		    		   
		    		   c1.setId(inputInt);
		    		   
		    		   System.out.println("");
	                    System.out.println("Confirme os dados: ");
	                    System.out.println("");
	                    System.out.println("Nome: " + c1.getNome());
	                    System.out.println("Email: " + c1.getEmail());
	                    System.out.println("Senha: " + c1.getSenha());
	                    System.out.println("Endereço: " + c1.getLogradouro() + ", CEP: " + c1.getCep());
	                    System.out.println("Cidade: " + c1.getCidade() + "/ " + c1.getUf());
	                    //telefone = c1.getTelefone();
	                    //System.out.println("Telefone: " + telefone);
	                    System.out.println("Documento: " + c1.getDocumento());
	                    System.out.println("Data de Nasc: " + c1.getData_nasc());
	                    
	                    System.out.println("");
	                    System.out.println("Salvar? 1. Sim / 2. Não");
	                    escolha3 = entrada.nextInt();
	                    switch(escolha3) {
	                    case 1: 
	                    	try {
	                    		//clienteDao.atualizarPorId(c1);
	                    		System.out.println("Cliente atualizado com sucesso!");
	                    		System.out.println("");
	                    		menuClientes();
	                    	}catch(Exception e) {
	                    		System.out.println("Houve algum problema");
	                    	}
	                    	break;
	                    case 2:
	                    	menuClientes();
	                    	break;
	                    default:
	                    	System.out.println("Opção inválida. Tente novamente.");
	                    }
	                    break;
	   
		    	   } catch (Exception e) {
		    		   System.out.println("Algum dado com erro.");
		    	   }
                break;
            case 4:
            	System.out.println("**** EXCLUIR CADASTRO DA VIAGEM ***");
	    	    System.out.println("Lembre-se, não há volta na exclusão");
	    	    System.out.println("");
	    	    System.out.println("Informe o ID da viagem a excluir");
	    	    int inputInt = entrada.nextInt();
	    	    System.out.println("");
	    	    System.out.println("DADOS DA VIAGEM");
	    	    
	    	    for(Viagem v:viagemDao.getViagensById(inputInt)) {
                	System.out.println("ID: " + v.getId());
		        	System.out.println("Destino: " + v.getDestino());
		        	System.out.println("Preço: R$" + v.getPreco());
		        	System.out.println("Data da Ida: " + v.getData_ida());
		        	System.out.println("Data da Volta: " + v.getData_volta());
		        	System.out.println("Descrição: " + v.getDescricao());
		        	System.out.println("Adicional: " + v.getAdicional());
		        	System.out.println("Tipo do Pacote: " + v.getTipo_pacote());
		        	System.out.println("---------");
                }
	    	    
	    	    System.out.println("Excluir viagem? 1. Sim / 2. Não");
	    	    escolha3 = entrada.nextInt();
                switch(escolha3) {
                case 1: 
                	try {
                		viagemDao.deletarPorId(inputInt);
                		System.out.println("Viagem excluído com sucesso!");
                		System.out.println("");
                		menuClientes();
                	}catch(Exception e) {
                		System.out.println("Houve algum problema");
                	}
                	break;
                case 2:
                	menuClientes();
                	break;
                default:
                	System.out.println("Opção inválida. Tente novamente.");
                }
                break;
            case 0:
                exibirMenu();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        
	}
	
	public static void menuReservas() {
		Scanner entrada = new Scanner(System.in);
        int escolha;
        int escolha2 = 0;
        int escolha3 = 0;
        int escolha4=0;
        int idPctEscolhido = 0;
        int idClienteEscolhido=0;
        String nomeClienteEscolhido="";
		String destPctEsc="";
		String destTipoPct="";
		Double prcPctEsc=0.0;
        ViagemDAO viagemDao = new ViagemDAO();
        ClienteDAO clienteDao = new ClienteDAO();
        Reserva reserva= new Reserva();
        ReservaDAO reservaDao = new ReservaDAO();


    	System.out.println("************************");
    	System.out.println("** AGÊNCIA DE VIAGENS **");
    	System.out.println("***  ADMINISTRADOR  ***");
    	System.out.println("************************");
        System.out.println("Selecione uma opção:");
        System.out.println("1. VER RESERVAS");
        System.out.println("2. CADASTRAR RESERVA");
        System.out.println("3. DELETAR RESERVA");
        System.out.println("0. SAIR");
        System.out.println("");
        
        escolha = entrada.nextInt();
        
        switch (escolha) {
            case 1:
            	System.out.println("RESERVAS CADASTRADOS NO SISTEMA");
            	System.out.println("");
                for(Reserva r:reservaDao.getReserva()) {
                	System.out.println("ID: " + r.getId());
		        	System.out.println("Destino: " + r.getDestino());
		        	System.out.println("Número de Passageiros: " + r.getNum_passageiros());
		        	System.out.println("Preço: R$" + r.getPreco());
		        	System.out.println("Data da Reserva: " + r.getData_reserva());
		        	System.out.println("Tipo do Pacote: " + r.getTipoPacote());
		        	System.out.println("Id do Cliente: " + r.getIdCliente().toString());		        	
		        	System.out.println("Id da Viagem: " + r.getIdViagem().toString());
		        	System.out.println("---------");
                }
                System.out.println("1. Voltar / 2. Voltar ao Menu Principal");
	        	escolha2 = entrada.nextInt();
	        	switch(escolha2) {
	        	case 1:
	        		menuViagens();
	        		break;
	        	case 2:
	        		exibirMenu();
	        		break;
	        	default:
	        		System.out.println("Opção Inválida");
	        	}
                break;
            case 2:
            		System.out.println("CADASTRAR NOVA RESERVA");
                	System.out.println("");
                	String inputString4 = entrada.nextLine();
                    
                    System.out.println("Informe o ID da VIAGEM: ");
                    int inputInt = entrada.nextInt();
                    
                    System.out.println("Informe o ID do CLIENTE: ");
                    int inputInt2 = entrada.nextInt();
                    
                    System.out.println("PACOTE ESCOLHIDO: ");
		        	for(Viagem v:viagemDao.getViagensById(inputInt)) {
			        	System.out.println("Id: " + v.getId());
			        	idPctEscolhido = v.getId();
			        	System.out.println("Destino: " + v.getDestino());
			        	destPctEsc =v.getDestino();
			        	System.out.println("Valor: R$" + v.getPreco());
			        	prcPctEsc = v.getPreco();
			        	System.out.println("Data da Ida: " + v.getData_ida());
			        	System.out.println("Data da Volta: " + v.getData_volta());
			        	System.out.println("Descrição: " + v.getDescricao());
			        	System.out.println("Adicionais: " + v.getAdicional());
			        	destTipoPct = v.getTipo_pacote();
			        	System.out.println("");
			        } 
		        	System.out.println("");
		        	
		        	System.out.println("CLIENTE ESCOLHIDO: ");
		        	for(Cliente c:clienteDao.getClienteById(inputInt2)) {
			        	System.out.println("Id: " + c.getId());
			        	idClienteEscolhido = c.getId();
			        	System.out.println("Nome do Cliente: " + c.getNome());
			        	nomeClienteEscolhido =c.getNome();
			        	System.out.println("Email: " + c.getEmail());
			        	System.out.println("");
			        } 
		        	System.out.println("");
		        	
		        	System.out.println("Informe o número de passageiros: ");
        			int inputIntRes = entrada.nextInt();
                    
        			java.util.Date dataUtil = new java.util.Date();
        			
                    
                    System.out.println("");
                    System.out.println("Confirme os dados: ");
                    System.out.println("");
                    System.out.println("Destino: " + destPctEsc);
                    double precoFinal = prcPctEsc * inputIntRes;
                    System.out.println("Valor Final: R$" + precoFinal);
                    System.out.println("Tipo do Pacote: " + destTipoPct);
                    System.out.println("Cliente: " + nomeClienteEscolhido);
                    
                    System.out.println("");
                    System.out.println("Confirmar Reserva? 1. Sim / 2. Não");
                    escolha3 = entrada.nextInt();
                    switch(escolha3) {
                    case 1: 
                    	try {		        			
		        			reserva.setNum_passageiros(inputIntRes);
		        			
		        			Cliente cliente = new Cliente();
		        			cliente.setId(idClienteEscolhido);
		        			reserva.setIdCliente(cliente);
		        			
		        			Viagem viagem = new Viagem();
		        			viagem.setId(idPctEscolhido);
		        			
		        			reserva.setIdViagem(viagem);
		        			reserva.setData_reserva(dataUtil);
		        			
		        			precoFinal = prcPctEsc * inputIntRes;
		        			reserva.setPreco(precoFinal);
		        			
		        			reserva.setDestino(destPctEsc);
		        			reserva.setTipoPacote(destTipoPct);
		        			
		        			reservaDao.saveReserva(reserva);
                    		System.out.println("Reserva salva com sucesso!");
                    		System.out.println("");
                    		menuClientes();
                    		
                    	}catch(Exception e) {
                    		System.out.println("Houve algum problema");
                    	}
                    	break;
                    case 2:
                    	menuViagens();
                    	break;
                    default:
                    	System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
                    // Não adicionei ATUALIZAR RESERVAS pois são dados majoritariamente automáticos e dinâmicos
            case 3:
            	System.out.println("**** EXCLUIR CADASTRO DA RESERVA ***");
	    	    System.out.println("Lembre-se, não há volta na exclusão");
	    	    System.out.println("");
	    	    System.out.println("Informe o ID da reserva a excluir");
	    	    inputInt = entrada.nextInt();
	    	    System.out.println("");
	    	    System.out.println("DADOS DA RESERVA");
	    	    
	    	    for(Reserva r:reservaDao.getReservaPorIdR(inputInt)) {
		        	System.out.println("ID: " + r.getId());
		        	System.out.println("Destino: " + r.getDestino());
		        	System.out.println("Data da Reserva: " + r.getData_reserva());
		        	System.out.println("Valor Final: R$" + r.getPreco());
		        	System.out.println("Número de Passageiros: " + r.getNum_passageiros());
		        	
		        	Viagem idViagem = r.getIdViagem();
		        	int id = idViagem.getId();
		        	for(Viagem v:viagemDao.getViagensById(id)) {
		        		System.out.println("Data da Ida: " + v.getData_ida());
		        		System.out.println("Data da Volta: " + v.getData_volta());
		        	}
		        	System.out.println("Tipo do pacote: " + r.getTipoPacote());
		        	System.out.println("Id do Cliente: " + r.getIdCliente().toString());		        	
		        	System.out.println("Id da Viagem: " + r.getIdViagem().toString());
		        	System.out.println("");
		        }
	    	    
	    	    System.out.println("Excluir reserva? 1. Sim / 2. Não");
	    	    escolha3 = entrada.nextInt();
                switch(escolha3) {
                case 1: 
                	try {
                		reservaDao.deleteById(inputInt);
                		System.out.println("Reserva excluída com sucesso!");
                		System.out.println("");
                		menuClientes();
                	}catch(Exception e) {
                		System.out.println("Houve algum problema");
                	}
                	break;
                case 2:
                	menuClientes();
                	break;
                default:
                	System.out.println("Opção inválida. Tente novamente.");
                }
                break;
            case 0:
                exibirMenu();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        
	}
	
	
	
	
	public static void exibirMenuLogado() {
        Scanner entrada = new Scanner(System.in);
        int escolha;
        String emailCliente = "";
        String nomeCliente="";
        ClienteDAO clienteDao = new ClienteDAO();
        
        if (SessaoUsuario.estaLogado()) {
            Cliente clienteLogado = SessaoUsuario.getClienteLogado();
            emailCliente = clienteLogado.getEmail();
            for(Cliente c:clienteDao.getClienteByEmail(emailCliente)) {
            	nomeCliente = c.getNome();
            }
        } else {
            System.out.println("Nenhum cliente logado.");
        }
        
        
    	System.out.println("************************");
    	System.out.println("** AGÊNCIA DE VIAGENS **");
    	System.out.println("************************");
    	System.out.println("");
    	System.out.println("Cliente Logado: " + nomeCliente);
        System.out.println("Selecione uma opção:");
        System.out.println("1. VER PERFIL");
        System.out.println("2. VER RESERVAS");
        System.out.println("3. VER PACOTES");
        System.out.println("4. VER PROMOÇÕES");
        System.out.println("0. SAIR");

        escolha = entrada.nextInt();

        switch (escolha) {
            case 1:
                perfilUsuario();
                break;
            case 2:
            	verReservasLogado();
                break;
            case 3:
                menuPacotes();
                break;
            case 4:
            	menuPromocoes();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
	
	
	public static void perfilUsuario() {
		Scanner entrada = new Scanner(System.in);
		boolean entradaValida = false;
		int escolha;
		String emailCliente = "";
        int idCliente=0;
        ClienteDAO clienteDao = new ClienteDAO();
        
        
        if (SessaoUsuario.estaLogado()) {
            Cliente clienteLogado = SessaoUsuario.getClienteLogado();
            emailCliente = clienteLogado.getEmail();
            for(Cliente c:clienteDao.getClienteByEmail(emailCliente)) {
            	idCliente = c.getId();
            }
        } else {
            System.out.println("Nenhum cliente logado.");
        }
		
		while(!entradaValida) {
		    try {
		        System.out.println("");
		        System.out.println("************************");
		        System.out.println("** AGÊNCIA DE VIAGENS **");
		        System.out.println("**       PERFIL    **");
		        System.out.println("************************");
		        System.out.println("Você escolheu a opção de PERFIL");
		        System.out.println("Dados do cliente:");
		        
		        for(Cliente c:clienteDao.getClienteById(idCliente)) {
		        	System.out.println("ID: " + c.getId());
		        	System.out.println("Nome: " + c.getNome());
		        	System.out.println("Data Nasc: " + c.getData_nasc());
		        	System.out.println("Documento: " + c.getDocumento());
		        	System.out.println("Email: " + c.getEmail());
		        	System.out.println("Endereço: " + c.getLogradouro() + ", " + "CEP: " + c.getCep());
		        	System.out.println("Cidade: " + c.getCidade() + "/ " + c.getUf());
		        	String telefone = c.getTelefone();
		        	String telefoneFormatado = formatarTelefone(telefone);
		        	System.out.println("Telefone: " + telefoneFormatado);
		        }
		        
		       System.out.println("");
		       System.out.println("1. ATUALIZAR CADASTRO / 2. VOLTAR PARA O MENU ANTERIOR");
		       escolha = entrada.nextInt();
		       switch(escolha) {
		       case 1:
		    	   System.out.println("**** ATUALIZAÇÃO DE DADOS ***");
		    	   System.out.println("Caso algum dado não mudou, basta digita-lo novamente.");
		    	   try {
		    		   Cliente c1 = new Cliente();
		    		   String inputString ="";
		    		   entrada.nextLine();
		    		   
		    		   System.out.println("Insira o nome a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setNome(inputString);
		    		   
		    		   System.out.println("Insira o email a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setEmail(inputString);
		    		   
		    		   System.out.println("Insira a senha a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setSenha(inputString);
		    		   
		    		   System.out.println("Insira o logradouro a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setLogradouro(inputString);
		    		   
		    		   System.out.println("Insira o CEP a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setCep(inputString);
		    		   
		    		   System.out.println("Insira a cidade a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setCidade(inputString);
		    		   
		    		   System.out.println("Insira o estado (UF) a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setUf(inputString);
		    		   
		    		   System.out.println("Insira um telefone a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setTelefone(inputString);
		    		   
		    		   System.out.println("Insira um Documento (CPF) a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setDocumento(inputString);
		    		   
		    		   System.out.println("Insira uma data de nascimento (DD/MM/AAAA) a modificar: ");
		    		   inputString = entrada.nextLine();
		    		   c1.setData_nasc(inputString);
		    		   
		    		   c1.setId(idCliente);
		    		   
		    		   	System.out.println("");
	                    System.out.println("Confirme os dados: ");
	                    System.out.println("");
	                    System.out.println("Nome: " + c1.getNome());
	                    System.out.println("Email: " + c1.getEmail());
	                    System.out.println("Senha: " + c1.getSenha());
	                    System.out.println("Endereço: " + c1.getLogradouro() + ", CEP: " + c1.getCep());
	                    System.out.println("Cidade: " + c1.getCidade() + "/ " + c1.getUf());
	                    String telefone = c1.getTelefone();
	                    System.out.println("Telefone: " + telefone);
	                    System.out.println("Documento: " + c1.getDocumento());
	                    System.out.println("Data de Nasc: " + c1.getData_nasc());
	                    
	                    System.out.println("");
	                    System.out.println("Salvar? 1. Sim / 2. Não");
	                    int escolha3 = entrada.nextInt();
	                    switch(escolha3) {
	                    case 1: 
	                    	try {
	                    		clienteDao.atualizarPorId(c1);
	                    		System.out.println("Cliente atualizado com sucesso!");
	                    		System.out.println("");
	                    		menuClientes();
	                    	}catch(Exception e) {
	                    		System.out.println("Houve algum problema");
	                    	}
	                    	break;
	                    case 2:
	                    	menuClientes();
	                    	break;
	                    default:
	                    	System.out.println("Opção inválida. Tente novamente.");
	                    }
	                    break;
	   
		    	   }catch(Exception e) {
		    		   System.out.println("Algum dado com erro");
		    	   }
		    	   break;
		       case 2: 
		    	   exibirMenuLogado();
		    	   break;
		       }   
		    } catch(Exception e) {
		    	e.printStackTrace();
		        System.out.println("Algum dado com erro");
		        entrada.nextLine(); 
		    }
		}
	}
	
	public static void verReservasLogado() {
		Scanner entrada = new Scanner(System.in);
		boolean entradaValida = false;
		int escolha;
		String emailCliente = "";
		String nomeCliente = "";
        int idCliente=0;
        ClienteDAO clienteDao = new ClienteDAO();
        ReservaDAO reservaDao = new ReservaDAO();
        ViagemDAO viagemDao = new ViagemDAO();
        
        
        if (SessaoUsuario.estaLogado()) {
            Cliente clienteLogado = SessaoUsuario.getClienteLogado();
            emailCliente = clienteLogado.getEmail();
            for(Cliente c:clienteDao.getClienteByEmail(emailCliente)) {
            	idCliente = c.getId();
            	nomeCliente = c.getNome();
            }
        } else {
            System.out.println("Nenhum cliente logado.");
        }
        
        while(!entradaValida) {
		    try {
		        System.out.println("");
		        System.out.println("************************");
		        System.out.println("** AGÊNCIA DE VIAGENS **");
		        System.out.println("**       RESERVAS    **");
		        System.out.println("************************");
		        System.out.println("Você escolheu a opção de RESERVAS");
		        System.out.println("");
		        System.out.println("Reservas de: " + nomeCliente);
		        System.out.println("");
		        System.out.println("DADOS DAS RESERVAS");
		        
		        for(Reserva r:reservaDao.getReservaPorId(idCliente)) {
		        	System.out.println("ID: " + r.getId());
		        	System.out.println("Destino: " + r.getDestino());
		        	System.out.println("Data da Reserva: " + r.getData_reserva());
		        	System.out.println("Valor Final: R$" + r.getPreco());
		        	System.out.println("Número de Passageiros: " + r.getNum_passageiros());
		        	
		        	Viagem idViagem = r.getIdViagem();
		        	int id = idViagem.getId();
		        	for(Viagem v:viagemDao.getViagensById(id)) {
		        		System.out.println("Data da Ida: " + v.getData_ida());
		        		System.out.println("Data da Volta: " + v.getData_volta());
		        	}
		        	System.out.println("Tipo do pacote: " + r.getTipoPacote());
		        	System.out.println("");
		        }
		        
		        entradaValida = true;
		    } catch(Exception e) {
		    	e.printStackTrace();
		        System.out.println("Algum dado com erro");
		        entrada.nextLine(); 
		    }
		}
        
        
	}
	
	public static void menuCadastro() {
		Scanner entrada = new Scanner(System.in);
		boolean entradaValida = false;
		
		// fazer a chamada a essas variáveis usando os dados do BD
		while(!entradaValida) {
		    try {
		        System.out.println("");
		        System.out.println("************************");
		        System.out.println("** AGÊNCIA DE VIAGENS **");
		        System.out.println("************************");
		        System.out.println("Você escolheu a opção de CADASTRO");
		        System.out.println("");
		        System.out.println("Outros dados poderão ser adicionados depois, "
		        		+ "na aba de atualização, tudo bem?");
		        System.out.println("");
		        System.out.println("Insira seu nome: ");
		        String nome = entrada.nextLine(); // Usando nextLine() para ler a linha inteira
		        System.out.println("Insira seu e-mail: ");
		        String email = entrada.nextLine(); // Usando nextLine() para ler a linha inteira
		        System.out.println("Insira uma senha: ");
		        String senha = entrada.nextLine(); // Lendo a senha como uma string
		        
		        ClienteDAO clienteDao = new ClienteDAO();
		        Cliente cliente1 = new Cliente();
		        
		        cliente1.setEmail(email);
		        cliente1.setNome(nome);
		        cliente1.setSenha(senha);	       
		        
		        clienteDao.salvarUsuario(cliente1);
		        
		        // Faça o que for necessário com os dados lidos
		        entradaValida = true;
		        
		        //Mensagem de confirmação
		        System.out.println("Cadastro realizado com sucesso!");
		        System.out.println("");
		        exibirMenu();
		        
		    } catch(Exception e) {
		        System.out.println("Algum dado com erro");
		        entrada.nextLine(); // Limpa o buffer do scanner após um erro
		    }
		    entrada.close();
		}
	}
	
	public static void menuLogin() {
		Scanner entrada = new Scanner(System.in);
		boolean entradaValida = false;
		
		while(!entradaValida) {
		    try {
		        System.out.println("");
		        System.out.println("************************");
		        System.out.println("** AGÊNCIA DE VIAGENS **");
		        System.out.println("************************");
		        System.out.println("Você escolheu a opção de LOGIN");
		        System.out.println("");
		        System.out.println("Insira seu e-mail: ");
		        String email = entrada.nextLine(); // Usando nextLine() para ler a linha inteira
		        System.out.println("Insira uma senha: ");
		        String senha = entrada.nextLine(); // Lendo a senha como uma string
		        
		        AutenticacaoCliente autenticador = new AutenticacaoCliente();
		        boolean acessoPermitido = autenticador.autenticar(email, senha);
		        
		        if(acessoPermitido!=true) {
		        	System.out.println("Algum dado com erro");
		        	menuLogin();
			        entrada.nextLine(); // Limpa o buffer do scanner após um erro2
			      
		        } else {		        		
		        		System.out.println("Bem Vindo(a) " + email + "!");
				        System.out.println("");
				        exibirMenuLogado();
		        }
		        
		        // Faça o que for necessário com os dados lidos
		        entradaValida = true;
		        
		    } catch(Exception e) {
		        System.out.println("Algum dado com erro");
		        entrada.nextLine(); // Limpa o buffer do scanner após um erro
		    }
		    
		}
	}
	
	public static void menuPacotes() {
		Scanner entrada = new Scanner(System.in);
		boolean entradaValida = false;
		int escolha;
		int confirma=0;
		int idPctEscolhido = 0;
		String destPctEsc="";
		String destTipoPct="";
		Double prcPctEsc=0.0;
		
		int inputIntRes = 0;;
		
		
		String emailCliente = "";
        int idCliente=0;
        ClienteDAO clienteDao = new ClienteDAO();
        
        
        if (SessaoUsuario.estaLogado()) {
            Cliente clienteLogado = SessaoUsuario.getClienteLogado();
            emailCliente = clienteLogado.getEmail();
            for(Cliente c:clienteDao.getClienteByEmail(emailCliente)) {
            	idCliente = c.getId();
            }
        } else {
            System.out.println("Nenhum cliente logado.");
        }
		
		ViagemDAO viagemDao = new ViagemDAO();
		
		
		// fazer a chamada a essas variáveis usando os dados do BD
		while(!entradaValida) {
		    try {
		        System.out.println("");
		        System.out.println("************************");
		        System.out.println("** AGÊNCIA DE VIAGENS **");
		        System.out.println("**      PACOTES       **");
		        System.out.println("************************");
		        System.out.println("");
		        
		        for(Viagem v:viagemDao.separarPctConv()) {
		        	System.out.println("Id: " + v.getId());
		        	System.out.println("Destino: " + v.getDestino());
		        	System.out.println("Valor: R$" + v.getPreco());
		        	System.out.println("Data da Ida: " + v.getData_ida());
		        	System.out.println("Data da Volta: " + v.getData_volta());
		        	System.out.println("Descrição: " + v.getDescricao());
		        	System.out.println("Adicionais: " + v.getAdicional());
		        	System.out.println("");
		        }
		        
		        
		        System.out.println("Digite o número do pacote ou 0(zero) para voltar: ");
		        
		        escolha = entrada.nextInt();
		        
		        if(escolha==0) {
		        	if (SessaoUsuario.estaLogado()) {
			            @SuppressWarnings("unused")
						Cliente clienteLogado = SessaoUsuario.getClienteLogado();
			            exibirMenuLogado();
			        } else {
			        	exibirMenu();
			        }
		        } else {
		        	System.out.println("PACOTE ESCOLHIDO: ");
		        	for(Viagem v:viagemDao.getViagensById(escolha)) {
			        	System.out.println("Id: " + v.getId());
			        	idPctEscolhido = v.getId();
			        	System.out.println("Destino: " + v.getDestino());
			        	destPctEsc =v.getDestino();
			        	System.out.println("Valor: R$" + v.getPreco());
			        	prcPctEsc = v.getPreco();
			        	System.out.println("Data da Ida: " + v.getData_ida());
			        	System.out.println("Data da Volta: " + v.getData_volta());
			        	System.out.println("Descrição: " + v.getDescricao());
			        	System.out.println("Adicionais: " + v.getAdicional());
			        	destTipoPct = v.getTipo_pacote();
			        	System.out.println("");
			        } 
		        	System.out.println("");
        			
        			System.out.println("Informe o número de passageiros: ");
        			inputIntRes = entrada.nextInt();
        			
        			java.util.Date dataUtil = new java.util.Date();
        			
		        	System.out.println("Confirmar Reserva? ");
		        	System.out.println("1. Sim - 2. Não");

		        	confirma = entrada.nextInt();
		        	switch(confirma) {
		        		case 1:
		        			ReservaDAO reservaDao = new ReservaDAO();
		        			Reserva reserva = new Reserva();
		        			
		        			reserva.setNum_passageiros(inputIntRes);
		        			
		        			Cliente cliente = new Cliente();
		        			cliente.setId(idCliente);
		        			reserva.setIdCliente(cliente);
		        			
		        			Viagem viagem = new Viagem();
		        			viagem.setId(idPctEscolhido);
		        			
		        			reserva.setIdViagem(viagem);
		        			reserva.setData_reserva(dataUtil);
		        			
		        			double precoFinal = prcPctEsc * inputIntRes;
		        			reserva.setPreco(precoFinal);
		        			
		        			reserva.setDestino(destPctEsc);
		        			reserva.setTipoPacote(destTipoPct);
		        			
		        			reservaDao.saveReserva(reserva);
		        			
		        			System.out.println("Reserva confirmada com sucesso");
		        			System.out.println("1- VOLTAR / 2- MENU PRINCIPAL");
		        			escolha = entrada.nextInt();
		        			if (escolha==1) {
		        				menuPacotes();
		        			} else {
		        				exibirMenuLogado();
		        			}
		        			break;
		        			
		        		case 2:
		        			menuPacotes();
	        			break;
		        	}
		        }
				
		        // Faça o que for necessário com os dados lidos
		        entradaValida = true;
		        
		        
		    } catch(Exception e) {
		    	e.printStackTrace();
		        entrada.nextLine(); // Limpa o buffer do scanner após um erro
		    }
		}
	}
	
	public static void menuPromocoes() {
		Scanner entrada = new Scanner(System.in);
		boolean entradaValida = false;
		int escolha;
		int confirma=0;
		int idPctEscolhido = 0;
		String destPctEsc="";
		String destTipoPct="";
		Double prcPctEsc=0.0;
		
		int inputIntRes = 0;;
		
		
		String emailCliente = "";
        int idCliente=0;
        ClienteDAO clienteDao = new ClienteDAO();
        
        
        if (SessaoUsuario.estaLogado()) {
            Cliente clienteLogado = SessaoUsuario.getClienteLogado();
            emailCliente = clienteLogado.getEmail();
            for(Cliente c:clienteDao.getClienteByEmail(emailCliente)) {
            	idCliente = c.getId();
            }
        } else {
            System.out.println("Nenhum cliente logado.");
        }
		
		ViagemDAO viagemDao = new ViagemDAO();
		
		// fazer a chamada a essas variáveis usando os dados do BD
		while(!entradaValida) {
		    try {
		        System.out.println("");
		        System.out.println("************************");
		        System.out.println("** AGÊNCIA DE VIAGENS **");
		        System.out.println("**     PROMOÇÕES      **");
		        System.out.println("************************");
		        System.out.println("");
		        
		        for(Viagem v:viagemDao.separarPctProm()) {
		        	System.out.println("Id: " + v.getId());
		        	System.out.println("Destino: " + v.getDestino());
		        	System.out.println("Valor: R$" + v.getPreco());
		        	System.out.println("Data da Ida: " + v.getData_ida());
		        	System.out.println("Data da Volta: " + v.getData_volta());
		        	System.out.println("Descrição: " + v.getDescricao());
		        	System.out.println("Adicionais: " + v.getAdicional());
		        	System.out.println("");
		        }
		        
		        
		        System.out.println("Digite o número do pacote ou 0(zero) para voltar: ");
		        
		        escolha = entrada.nextInt();
		        
		        if(escolha==0) {
		        	if (SessaoUsuario.estaLogado()) {
			            @SuppressWarnings("unused")
						Cliente clienteLogado = SessaoUsuario.getClienteLogado();
			            exibirMenuLogado();
			        } else {
			        	exibirMenu();
			        }
		        } else {
		        	System.out.println("PACOTE ESCOLHIDO: ");
		        	for(Viagem v:viagemDao.getViagensById(escolha)) {
			        	System.out.println("Id: " + v.getId());
			        	idPctEscolhido = v.getId();
			        	System.out.println("Destino: " + v.getDestino());
			        	destPctEsc =v.getDestino();
			        	System.out.println("Valor: R$" + v.getPreco());
			        	prcPctEsc = v.getPreco();
			        	System.out.println("Data da Ida: " + v.getData_ida());
			        	System.out.println("Data da Volta: " + v.getData_volta());
			        	System.out.println("Descrição: " + v.getDescricao());
			        	System.out.println("Adicionais: " + v.getAdicional());
			        	destTipoPct = v.getTipo_pacote();
			        	System.out.println("");
			        } 
		        	System.out.println("");
        			
        			System.out.println("Informe o número de passageiros: ");
        			inputIntRes = entrada.nextInt();
        			
        			java.util.Date dataUtil = new java.util.Date();
        			
		        	System.out.println("Confirmar Reserva? ");
		        	System.out.println("1. Sim - 2. Não");

		        	confirma = entrada.nextInt();
		        	switch(confirma) {
		        		case 1:
		        			ReservaDAO reservaDao = new ReservaDAO();
		        			Reserva reserva = new Reserva();
		        			
		        			reserva.setNum_passageiros(inputIntRes);
		        			
		        			Cliente cliente = new Cliente();
		        			cliente.setId(idCliente);
		        			reserva.setIdCliente(cliente);
		        			
		        			Viagem viagem = new Viagem();
		        			viagem.setId(idPctEscolhido);
		        			
		        			reserva.setIdViagem(viagem);
		        			reserva.setData_reserva(dataUtil);
		        			
		        			double precoFinal = prcPctEsc * inputIntRes;
		        			reserva.setPreco(precoFinal);
		        			
		        			reserva.setDestino(destPctEsc);
		        			reserva.setTipoPacote(destTipoPct);
		        			
		        			reservaDao.saveReserva(reserva);
		        			
		        			System.out.println("Reserva confirmada com sucesso");
		        			System.out.println("1- VOLTAR / 2- MENU PRINCIPAL");
		        			escolha = entrada.nextInt();
		        			if (escolha==1) {
		        				menuPacotes();
		        			} else {
		        				exibirMenuLogado();
		        			}
		        			break;
		        			
		        		case 2:
		        			menuPacotes();
	        			break;
		        	}
		        }
		        
		     // Faça o que for necessário com os dados lidos
		        entradaValida = true;
		        
		    } catch(Exception e) {
		        System.out.println("Algum dado com erro");
		        entrada.nextLine(); // Limpa o buffer do scanner após um erro
		    }
		}
	}
	
	public static String formatarTelefone(String telefone) {
		if (telefone!=null) {
			String regex = "(\\d{2})(\\d{0,8})"; // Captura os primeiros dois dígitos e até os próximos 8 dígitos

	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(telefone);

	        if (matcher.matches()) {
	            String parte1 = matcher.group(1);
	            String parte2 = matcher.group(2);
	            return String.format("(%s)%s", parte1, parte2);
	        }
		} else {
			telefone = "";
		}
        

        // Se o telefone não corresponder ao padrão, retorna o original
        return telefone;
    }

	public static void main(String[] args) {		

		
		exibirMenu();

		
	}
}
