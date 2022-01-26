package main;

import java.util.Scanner;

import entities.Archer;
import entities.CombatClass;
import entities.Enemy;
import entities.Gender;
import entities.Knight;
import entities.Mage;
import entities.Motivations;
import entities.OrcAlchemist;
import entities.OrcArmorer;
import entities.OrcLeader;
import entities.Trap;
import entities.Warrior;
import entities.Weapons;

public class FinalBattle {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int option = 0;
		String difficultyLevel = null;
		String characterName = null;
		Gender characterGender = null;
		CombatClass player = null;

		int flagDif = 0;

		while (flagDif == 0) {

			try {

				System.out.println("Seja bem vindo(a) � BATALHA FINAL!");
				System.out.println("Escolha o n�vel de dificuldade:");
				System.out.println("1 - F�cil,");
				System.out.println("2 - Normal,");
				System.out.println("3 - Dif�cil,");

				option = chooseOption(3, in);

				switch (option) {
				case 1: {
					difficultyLevel = "Easy";
					System.out.println("Modo f�cil: Os inimigos causar�o 20% a menos de dano!");
					flagDif = 1;
					break;
				}
				case 2: {
					difficultyLevel = "Normal";
					System.out.println("Modo normal: O dano ser� calculado normalmente!");
					flagDif = 1;
					break;
				}
				case 3: {
					difficultyLevel = "Hard";
					System.out.println("Modo dif�cil: Voc� causar� 10% a menos de dano!");
					flagDif = 1;
					break;
				}
				}
			} catch (Exception exception) {
				System.err.println("Digite apenas 1, 2 ou 3");
			}
		}

		int flagName = 0;

		while (flagName == 0) {
			System.out.println("Digite o nome do seu personagem:");
			characterName = in.nextLine();
			if (characterName.isBlank() || characterName.isEmpty()) {
				System.err.println("O nome n�o pode ser deixado em branco!");
			} else {
				flagName = 1;
			}
		}

		int flagGender = 0;

		while (flagGender == 0) {
			try {

				System.out.println("Digite o g�nero do seu personagem: 1 - Masculino ou 2 - Feminino");
				option = chooseOption(2, in);

				switch (option) {
					case 1: {
						characterGender = Gender.MALE;
						flagGender = 1;
						break;
					}
					case 2: {
						characterGender = Gender.FEMALE;
						flagGender = 1;
						break;
					}
				}

			} catch (Exception exception) {
				System.err.println("Digite apenas 1 ou 2");
			}
		}

		int flagClassandWeapon = 0;

		while (flagClassandWeapon == 0) {

			try {
				System.out.println("Selecione a classe do seu personagem:");
				System.out.println("1 - Warrior,");
				System.out.println("2 - Knight,");
				System.out.println("3 - Archer,");
				System.out.println("4 - Mage");

				option = chooseOption(4, in);

				System.out.println("Escolha a sua arma: ");
				switch (option) {
				case 1:
					System.out.println("1 - " + Weapons.HAMMER.getName());
					System.out.println("2 - " + Weapons.AXE.getName());
					break;
				case 2:
					System.out.println("1 - " + Weapons.SWORD.getName());
					System.out.println("2 - " + Weapons.CLUB.getName());
					break;
				case 3:
					System.out.println("1 - " + Weapons.BOW_AND_ARROW.getName());
					System.out.println("2 - " + Weapons.CROSSBOW.getName());
					break;
				case 4:
					System.out.println("1 - " + Weapons.STAFF.getName());
					System.out.println("2 - " + Weapons.GRIMOIRE.getName());
					break;
				}

				int weaponOption = chooseOption(2, in);

				Weapons chosenWeapon;
				switch (option) {
				case 1:
					chosenWeapon = weaponOption == 1 ? Weapons.HAMMER : Weapons.AXE;
					player = new Warrior(characterName, characterGender, chosenWeapon);
					break;
				case 2:
					chosenWeapon = weaponOption == 1 ? Weapons.SWORD : Weapons.CLUB;
					player = new Knight(characterName, characterGender, chosenWeapon);
					break;
				case 3:
					chosenWeapon = weaponOption == 1 ? Weapons.BOW_AND_ARROW : Weapons.CROSSBOW;
					player = new Archer(characterName, characterGender, chosenWeapon);
					break;
				case 4:
					chosenWeapon = weaponOption == 1 ? Weapons.STAFF : Weapons.GRIMOIRE;
					player = new Mage(characterName, characterGender, chosenWeapon);
					break;
				}
				flagClassandWeapon = 1;
			} catch (Exception exception) {
				System.err.println("Para escolher a classe digite n�meros de 1 a 4 e para escolher a arma digite 1 ou 2.");
			}
		}

		System.out.println("A noite se aproxima, a lua j� surge no c�u, estrelas v�o se acendendo,\n"
				+ "e sob a luz do crep�sculo voc� est� prestes a entrar na fase final da sua miss�o.\n"
				+ "Voc� olha para o portal � sua frente, e sabe que a partir desse ponto, sua vida mudar� para sempre.");

		System.out.println("Mem�rias do caminho percorrido para chegar at� aqui invadem sua mente.\n"
				+ "Voc� se lembra de todos os inimigos j� derrotados para alcan�ar o covil do l�der maligno.\n"
				+ "Olha para seu equipamento de combate, j� danificado e desgastado depois de tantas lutas.\n"
				+ "Voc� est� a um passo de encerrar para sempre esse mal.");

		System.out.println("Buscando uma inje��o de �nimo, voc� se for�a a lembrar o que te trouxe at� aqui.");

		System.out.println("Escolha uma motiva��o para a sua jornada: ");
		System.out.println("1 - Vingan�a");
		System.out.println("2 - Gl�ria");

		option = decision(2, in);

		if (option == 1) {
			player.setMotivation(Motivations.VENGEANCE);
		} else if (option == 2) {
			player.setMotivation(Motivations.GLORY);
		} else {
			System.err.println("Digite apenas 1 ou 2");
		}

		if (player.getMotivation() == Motivations.VENGEANCE) {
			System.out.println("Imagens daquela noite tr�gica invadem sua mente.\n"
					+ "Voc� nem precisa se esfor�ar para lembrar, pois essas mem�rias est�o sempre presentes,\n"
					+ "mesmo que de pano de fundo, quando voc� tem outros pensamentos em foco, elas nunca o deixaram.\n"
					+ "Elas s�o o combust�vel que te fizeram chegar at� aqui.\n"
					+ "E voc� sabe que n�o ir� desistir at� ter vingado a morte\n"
					+ "daqueles que foram - e pra sempre ser�o - sua fonte de amor e desejo de continuar vivo.\n"
					+ "O maldito l�der finalmente pagar� por tanto mal causado na vida de tantos\n"
					+ "(e principalmente na sua).");
		} else {
			System.out.println(
					"Voc� j� consegue visualizar na sua mente o povo da cidade te recebendo de bra�os abertos,\n"
							+ "bardos criando can��es sobre seus feitos her�icos, nobres te presenteando com j�ias e diversas riquezas,\n"
							+ "taberneiros se recusando a cobrar por suas bebedeiras e comilan�as.\n"
							+ "Desde j�, voc� sente o amor do p�blico, te louvando a cada passo que d� pelas ruas,\n"
							+ "depois de destruir o vil�o que tanto assombrou a paz de todos.\n"
							+ "Por�m, voc� sabe que ainda falta o �ltimo ato dessa hist�ria.\n"
							+ "Voc� se concentra na miss�o.\n"
							+ "A gl�ria o aguarda, mas n�o antes da �ltima batalha.");
		}

		System.out.println("Inspirado pelo motivo que te trouxe at� aqui, voc� sente seu cora��o ardendo em chamas,\n"
				+ "suas m�os formigarem em volta da sua arma. Voc� a segura com firmeza. Seu foco est� renovado.\n"
				+ "Voc� avan�a pelo portal.");

		System.out.println("A escurid�o te envolve. Uma ilumina��o muito fraca entra pelo portal �s suas costas.\n"
				+ "� sua frente, s� � poss�vel perceber que voc� se encontra em um corredor extenso.\n"
				+ "Voc� s� pode ir � frente, ou desistir.");

		System.out.println("O que voc� faz?");
		System.out.println("1 - Segue em frente");
		System.out.println("2 - Desiste");

		option = decision(2, in);

		if (option == 2) {
			System.out.println("O medo invade o seu cora��o e voc� sente que ainda n�o est� � altura do desafio.\n"
					+ "Voc� se volta para a noite l� fora, e corre em dire��o � seguran�a.");
			System.exit(0);
		}

		System.out.println("Voc� caminha, atento a todos os seus sentidos, por v�rios metros,\n"
				+ "at� visualizar a frente uma fonte de luz, que voc� imagina ser a chama de uma tocha,\n"
				+ "vindo de dentro de uma porta aberta.");

		System.out.println("Voc� se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
				+ "e pondera sobre como passar pela porta.");
		System.out.println("Como voc� decide passar pela porta?");
		System.out.println("1 - Andando cuidadosamente");
		System.out.println("2 - Correndo");
		System.out.println("3 - Saltando");

		option = decision(3, in);
		if (option == 1) {
			System.out.println("Voc� toma cuidado e vai caminhando vagarosamente em dire��o � luz.\n"
					+ "Quando voc� pisa exatamente embaixo da porta, voc� sente o ch�o ceder levemente, como se tivesse pisado em uma pedra solta.\n"
					+ "Voc� ouve um ru�do de mecanismos se movimentando, e uma escotilha se abre no teto atr�s de voc�, no corredor.\n"
					+ "Flechas voam da escotilha em sua dire��o, e voc� salta para dentro da sala, por�m uma delas te acerta na perna.");
			Trap trap = new Trap();
			trap.rollToAttack(player, difficultyLevel);

		} else if (option == 2) {

			System.out.println("Voc� respira fundo e desata a correr em dire��o � sala.\n"
					+ "Quando passa pela porta, sente que pisou em uma pedra solta,\n"
					+ "mas n�o d� muita import�ncia e segue para dentro da sala, olhando ao redor � procura de inimigos.\n"
					+ "N�o tem ningu�m, mas voc� ouve sons de flechas batendo na pedra atr�s de voc�,\n"
					+ "e quando se vira, v� v�rias flechas no ch�o.\n"
					+ "Espiando pela porta, voc� entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,\n"
					+ "mas por sorte voc� entrou correndo e conseguiu escapar desse ataque surpresa.");
		} else {
			System.out.println(
					"Voc� se concentra e pula em dire��o � luz, saltando de antes da porta at� o interior da sala.");
		}

		System.out.println("Voc� se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
				+ "Uma delas foi aquela pela qual voc� entrou, que estava aberta, e as outras tr�s est�o fechadas.\n"
				+ "A porta � sua frente � a maior das quatro, com inscri��es em seu entorno em uma l�ngua que voc� n�o sabe ler,\n"
				+ "mas reconhece como sendo a l�ngua antiga utilizada pelo inimigo.\n"
				+ "Voc� se aproxima da porta e percebe que ela est� trancada por duas fechaduras douradas,\n"
				+ "e voc� entende que precisar� primeiro derrotar o que estiver nas outras duas portas laterais,\n"
				+ "antes de conseguir enfrentar o l�der.");

		System.out.println("Voc� se dirige para a porta � direita.");

		System.out.println("Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada.\n"
				+ "Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra.\n"
				+ "Ao entrar, voc� se depara com uma sala espa�osa,\n"
				+ "com v�rios equipamentos de batalha pendurados nas paredes e dispostos em arm�rios e mesas.\n"
				+ "Voc� imagina que este seja o arsenal do inimigo, onde est�o guardados os equipamentos que seus soldados\n"
				+ "utilizam quando saem para espalhar o terror nas cidades e vilas da regi�o.\n"
				+ "Enquanto seu olhar percorre a sala, voc� ouve a porta se fechando e gira rapidamente para olhar para tr�s.\n"
				+ "Ali, de p� entre voc� e a porta fechada, bloqueando o caminho do seu destino, est� um dos capit�es do inimigo.\n"
				+ "Um orque horrendo, de armadura, capacete e espada em punho, em posi��o de combate.\n"
				+ "Ele avan�a em sua dire��o.");

		OrcArmorer armorer = new OrcArmorer();
		combat(player, armorer, false, in, difficultyLevel);

		System.out.println("Ap�s derrotar o Armeiro, voc� percebe que seus equipamentos est�o muito danificados.\n"
				+ "Olha em volta, encarando todas aquelas pe�as de armaduras resistentes e em �timo estado.");

		System.out.println("Voc� deseja pegar e usar as armaduras do inimigo? 1- Sim, 2- N�o");

		option = decision(2, in);
		if (option == 1) {
			System.out.println("Voc� resolve usar os equipamentos do inimigo contra ele, e trocar algumas pe�as suas,\n"
					+ "que estavam danificadas, pelas pe�as de armaduras existentes na sala.\n"
					+ "De armadura nova, voc� se sente mais protegido para os desafios � sua frente.");

			player.increaseDef(5);
		} else {
			System.out.println("Voc� decide que n�o precisa utilizar nada que venha das m�os do inimigo.");
		}

		System.out.println(
				"Em uma mesa, voc� encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do l�der inimigo.\n"
						+ "Voc� pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

		System.out.println("Voc� retorna � sala anterior e se dirige � porta da esquerda.\n"
				+ "Voc� se aproxima, tentando ouvir o que acontece porta adentro, mas n�o escuta nada.\n"
				+ "Segura com mais for�a sua arma com uma m�o, enquanto empurra a porta com a outra.\n"
				+ "Ao entrar, voc� se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,\n"
				+ "existem v�rios potes e garrafas de vidro com conte�dos misteriosos e de cores diversas,\n"
				+ "e voc� entende que o capit�o que vive ali, realiza experimentos com diversos ingredientes,\n"
				+ "criando po��es utilizadas pelos soldados para aterrorizar a regi�o.");
		System.out.println("No fundo da sala, olhando em sua dire��o, est� outro dos capit�es do inimigo.\n"
				+ "Um orque horrendo, de armadura, cajado em punho, em posi��o de combate. Ele avan�a em sua dire��o.");

		OrcAlchemist alchemist = new OrcAlchemist();

		combat(player, alchemist, false, in, difficultyLevel);

		System.out.println(
				"Ap�s derrotar o Alquimista, voc� olha em volta, tentando reconhecer alguma po��o do estoque do inimigo.\n"
						+ "Em uma mesa, voc� reconhece uma pequena garrafa de vidro contendo um l�quido levemente rosado,\n"
						+ "pega a garrafa e pondera se deve beber um gole.");

		System.out.println("Voc� deseja beber da po��o do inimigo? 1- Sim, 2- N�o");

		option = decision(2, in);

		if (option == 1) {
			System.out.println("Voc� se sente revigorado para seguir adiante!");

			player.heal(CombatClass.MAX_HEALTH);
		} else {
			System.out.println("Voc� fica receoso de beber algo produzido pelo inimigo.");
		}

		System.out.println("Ao lado da porta, voc� v� uma chave dourada em cima de uma mesa,\n"
				+ "e sabe que aquela chave abre a outra fechadura da porta do l�der inimigo.\n"
				+ "Voc� pega a chave e guarda na pequena bolsa que leva presa ao cinto.");

		System.out.println("De volta � sala das portas, voc� se dirige � porta final.\n"
				+ "Coloca as chaves nas fechaduras, e a porta se abre.\n"
				+ "Seu cora��o acelera, mem�rias de toda a sua vida passam pela sua mente,\n"
				+ "e voc� percebe que est� muito pr�ximo do seu objetivo final.\n"
				+ "Segura sua arma com mais firmeza, foca no combate que voc� sabe que ir� se seguir, e adentra a porta.");

		System.out.println(
				"L� dentro, voc� v� o l�der sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados �s paredes.");

		System.out.println(
				"Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de l�mina dupla.");

		System.out.println("Voc� ataca ou aguarda o inimigo atacar primeiro? 1- Atacar, 2- Aguardar");

		option = decision(2, in);

		OrcLeader leader = new OrcLeader();
		combat(player, leader, option == 1, in, difficultyLevel);

		System.out.println("Voc� conseguiu!");

		if (player.getMotivation() == Motivations.VENGEANCE) {
			System.out.println("Voc� obteve sua vingan�a.\n"
					+ "Voc� se ajoelha e cai no choro, invadido por uma sensa��o de al�vio e felicidade.\n"
					+ "Voc� se vingou, tudo que sempre quis, est� feito.\n" + "Agora voc� pode seguir sua vida.");
		} else {
			System.out.println("O �xtase em que voc� se encontra n�o cabe dentro de si.\n"
					+ "Voc� se ajoelha e grita de alegria.\n" + "A gl�ria o aguarda, voc� a conquistou.");
		}

		System.out.println("Voc� se levanta, olha para os prisioneiros, vai de um em um e os liberta,\n"
				+ "e todos voc�s saem em dire��o � noite, retornando � cidade.\n" + "Seu dever est� cumprido.");
	}

	private static int chooseOption(int numberOfOptions, Scanner in) throws Exception {
		String optionString = in.nextLine();
		int option = Integer.parseInt(optionString);
		if (option < 1 || option > numberOfOptions) {
			throw new Exception("Insira um n�mero v�lido entre 1-" + numberOfOptions + ".");
		}
		return option;
	}

	private static int decision(int numberOfOptions, Scanner in) {
		boolean repeat = true;
		int option = 0;
		do {
			try {
				option = chooseOption(numberOfOptions, in);
				repeat = false;
			} catch (Exception exception) {
				System.err.println("Para escolher, insira um n�mero v�lido entre 1-" + numberOfOptions + ".");
			}
		} while (repeat);

		return option;
	}

	private static void combat(CombatClass player, Enemy enemy, boolean playerAttacks, Scanner in,
			String difficultyLevel) {
		do {
			if (playerAttacks) {
				System.out.println("� a sua vez de atacar! Digite 1 para atacar ou 2 para fugir:");
				int option = decision(2, in);

				if (option == 2) {
					System.exit(0);
				}

				player.rollToAttack(enemy, difficultyLevel);
			} else {
				enemy.rollToAttack(player, difficultyLevel);
			}

			playerAttacks = !playerAttacks;
		} while (!player.dead() && !enemy.dead());

		if (player.dead()) {
			System.out.println("Voc� n�o estava preparado para a for�a do inimigo.");
			switch (player.getMotivation()) {
			case VENGEANCE:
				System.out.println(
						"N�o foi poss�vel concluir sua vingan�a, e agora resta saber se algu�m se vingar� por voc�.");
				break;
			case GLORY:
				if (player.getGender() == Gender.MALE) {
					System.out.println("A gl�ria que buscavas n�o ser� sua, e a cidade aguarda por seu pr�ximo her�i.");
				} else {
					System.out
							.println("A gl�ria que buscavas n�o ser� sua, e a cidade aguarda por sua pr�xima hero�na.");
				}
				break;
			}
			System.exit(0);
		}

		if (enemy.dead()) {
			System.out.println("O inimigo n�o � p�reo para o seu hero�smo, e jaz im�vel aos seus p�s.");
		}
	}
}