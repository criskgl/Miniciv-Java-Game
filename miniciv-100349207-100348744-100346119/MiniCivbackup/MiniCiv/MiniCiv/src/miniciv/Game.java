/*
 * Universidad Carlos III de Madrid (UC3M)
 * Programacion 2015-2016
 */
package miniciv;

/**
 * Un juego de MiniCiv.
 * @author Planning and Learning Group (PLG)
 */
public class Game {
    // NOTA: Pueden crearse nuevas variables globales y metodos.
	
    //*********MIS VARIABLES*********//
	//Variable que guarda el numero de turno
	int turno = 0; 
	//Matriz que guardara cada objeto Square con sus caracteristicas.
	Square [][] mapa = new Square[10][10];
	//Guarda el valor randomico entre 1 y 4 para escoger esquina de inicio para pintar la primera fila o columna de mar.
	int esquina;
	//Se crea un Jugador
	Player p1;
	//******************************//
	
    /**
     * Constructor que inicializa el juego y el mapa.
     */
	public Game(){  
        System.out.println("El programa empieza en el constructor de Game");
        //Se llama al metodo creador de LLANURAS
        InitLLanura();
      //Se llama al metodo creador de MAR
        InitMar();
      //Se llama al metodo creador de SELVAS
        InitSelva();
      //Se llama al metodo creador de LAGO
        InitLago();
      //Se llama al metodo creador de BOSQUES
        InitBosque();
      //Se llama al metodo creador de MONTANAS
        InitMontana();
      //AQUI SE HA TERMINADO DE LLAMAR A LOS METODOS QUE CREAN EL MAPA.
    }
    //Se llena el mapa de LLANURA	
    protected void InitLLanura(){
    	//Se llena el tablero de llanura:
        for(int i = 0; i < 10; i++){
        	for(int j = 0; j < 10; j++){
        		mapa[i][j] = new Square(0);
        	}
        }
    }
    //El 10% del mapa se hace MAR(se llena una fila o columna lateral)
    protected void InitMar(){
        //Se elige una esquina de forma randomica(25% de probabilidad para cada una de las 4 esquinas) para comenzar a pintar el mar.*^¨Ç*^¨Ç*^¨Ç*^¨Ç*^Ç*^Ç¨*^Ç¨*^¨Ç*^Ç*^¨Ç*^¨Ç*^¨Ç
        esquina = (int)(Math.random()*4+1);
        switch(esquina){
        case 1: 
        	for(int i = 0; i < 10; i++){
        		mapa[i][0].type=2;
        	}
        	break;
        	
        case 2:
        	for(int j = 0; j < 10; j++){
        		mapa[9][j].type=2;
        	}
        	break;
        	
        case 3: 
        	for(int i = 9; i > -1; i--){
        		mapa[i][9].type=2;
        	}
        	break;
        	
        case 4:
        	for(int j = 9; j > -1; j--){
        		mapa[0][j].type=2;
        	}
        	break;
        }
        
        MarNext(esquina,(int)(Math.random()*2));
    }
    /*El otro 10% que hay que rellenar de MAR se rellena  de forma aleatoria a 
    partir de la primera fila creada para que todas las casillas MAR permanezcan adyacentes*/
    protected void MarNext(int esq, int dir){
    	//numero randomico entre 4 y 6
    	int MarSegundo = getRndVal(4, 6);
    	//numero randomico entre 2 y 4
    	int MarTercero = getRndVal(2, 4);
    	//mares restantes para el ultimo mar, si asi se permite para cumplir el 20% de mar requerido.
    	int MarCuarto = 20-(10+MarSegundo+MarTercero);
    	switch(esq){
    	case 1:
    		if(dir == 0){
    			for(int i = 0; i < MarSegundo; i++){
    				mapa[i][1].type = 2;
    			}
    			for(int i = 0; i < MarTercero; i++){
    				mapa[i][2].type = 2;
    			}
    			if(MarCuarto > 0){
    				for(int i = 0; i < MarCuarto; i++){
        				mapa[i][3].type = 2;
        			}
    			}
    		}
    		else{
    			for(int i = 9; i > 9-MarSegundo; i--){
    				mapa[i][1].type = 2;
    			}
    			for(int i = 9; i > 9-MarTercero; i--){
    				mapa[i][2].type = 2;
    			}
    			if(MarCuarto > 0){
    				for(int i = 9; i > 9-MarCuarto; i--){
        				mapa[i][3].type = 2;
        			}
    			}
    		}
    		break;
   
    	case 2:
    		if(dir == 0){
    			for(int j = 0; j < MarSegundo; j++){
    				mapa[8][j].type = 2;
    			}
    			for(int j = 0; j < MarTercero; j++){
    				mapa[7][j].type = 2;
    			}
    			if(MarCuarto > 0){
    				for(int j = 0; j < MarCuarto; j++){
        				mapa[6][j].type = 2;
        			}
    			}
    		}
    		else{
    			for(int j = 9; j > 9-MarSegundo; j--){
    				mapa[8][j].type = 2;
    			}
    			for(int j = 9; j > 9-MarTercero; j--){
    				mapa[7][j].type = 2;
    			}
    			if(MarCuarto > 0){
    				for(int j = 9; j > 9-MarCuarto; j--){
        				mapa[6][j].type = 2;
        			}
    			}
    		}
    		break;
    		
    	case 3: 
    		if(dir == 0){
    			for(int i = 9; i > 9-MarSegundo; i--){
    				mapa[i][8].type = 2;
    			}
    			for(int i = 9; i > 9-MarTercero; i--){
    				mapa[i][7].type = 2;
    			}
    			if(MarCuarto > 0){
    				for(int i = 9; i > 9-MarCuarto; i--){
        				mapa[i][6].type = 2;
        			}
    			}
    		}
    		else{
    			for(int i = 0; i < MarSegundo; i++){
    				mapa[i][8].type = 2;
    			}
    			for(int i = 0; i < MarTercero; i++){
    				mapa[i][7].type = 2;
    			}
    			if(MarCuarto > 0){
    				for(int i = 0; i < MarCuarto; i++){
        				mapa[i][6].type = 2;
        			}
    			}
    		}
    		break;
    		
    	case 4:
    		if(dir == 0){
    			for(int j = 9; j > 9-MarSegundo; j--){
    				mapa[1][j].type = 2;
    			}
    			for(int j = 9; j > 9-MarTercero; j--){
    				mapa[2][j].type = 2;
    			}
    			if(MarCuarto > 0){
    				for(int j = 9; j > 9-MarCuarto; j--){
        				mapa[3][j].type = 2;
        			}
    			}
    		}
    		if(dir == 1){
    			for(int j = 0; j < MarSegundo; j++){
    				mapa[1][j].type = 2;
    			}
    			for(int j = 0; j < MarTercero; j++){
    				mapa[2][j].type = 2;
    			}
    			if(MarCuarto > 0){
    				for(int j = 0; j < MarCuarto; j++){
        				mapa[3][j].type = 2;
        			}
    			}
    		}
    		break;
    	}
    }
    /*Esto es un metodo auxiliar que devuelve valores randomicos entre un valor minimo y otro maximo(ambos inclusive)*/
    protected int getRndVal(int min,int max){
    	return (int)(Math.random()*(max-min+1)+min); 
    }
    /*Ahora se coloca el Lago aletoriamente en una casilla del mapa teniendo siempre un 50% de probabilidades de existir*/
    protected void InitLago(){
    //decisonLago sera 0 o 1, es decir 50% de probabilidades de existir lago.
    int decisionLago = (int)(Math.random()*2);
    if(decisionLago == 1){
		    for(int k = 0; k < 100; k++){
		    	int i = getRndVal(0,9);
		    	int j = getRndVal(0,9);
		    	if(mapa[i][j].type == 0){
		    	mapa[i][j].type = 2;
		    	break;
		    	}
		    }
    }
    }
    /*Se construira entonces la selva, para ello se barre todo el mapa casilla a casilla comprobando primero si es mar o no,
     * despues, si no es mar la comprobacion continua hasta encontrar una casilla tipo mar. Cuando se encuentra una casilla tipo mar 
     * se comprueban todas sus casillas adyacentes (arriba, abajo, derecha e izquierda), tambien para librarnos del error "Out of bounds" que podria
     * aparecer si se trata de una casilla de alguno de los bordes se usa un try-catch que hara que continue el programa sin lanzar error. El proceso
     * se repite hasta haber CONVERTIDO finalmente TODAS LAS CASILLAS ADYACENTES AL MAR*/
    protected void InitSelva(){
    	for(int j = 0;j < 10; j++){
    		for(int i = 0; i < 10; i++){
    			if (mapa[j][i].type == 2){
    				//CASILLA SUPERIOR A UNA CASILLA MAR
    				try{
	    				if(mapa[j-1][i].type == 0){
	    					mapa[j-1][i].type = 4;
	    				}
    				}catch(Exception e){}
    				//CASILLA DERECHA A UNA CASILLA MAR
    				try{
	    				if(mapa[j][i+1].type == 0){
	    					mapa[j][i+1].type = 4;
	    				}
    				}catch(Exception b){}
    				//CASILLA ABAJO A UNA CASILLA MAR
    				try{
	    				if(mapa[j+1][i].type == 0){
	    					mapa[j+1][i].type = 4;
	    				}
    				}catch(Exception p){}
    				//CASILLA IZQUIERDA A UNA CASILLA MAR
    				try{
	    				if(mapa[j][i-1].type == 0){
	    					mapa[j][i-1].type = 4;
	    				}
    				}catch(Exception m){}
    			}
    		}
    	}
    }
    /*Se eligen casillas al azar del mapa, si son tipo llanura se cambian a tipo bosque, si no lo son, el bucle While continua hasta que se 
     * satisface el 15% de Bosque requerido*/
    protected void InitBosque(){
    	int fila, columna;
    	int contador = 0;
    	//El bucle se repite 15 veces para satisfacer el 15%.
    	while(contador<15){
    		fila = getRndVal(0, 9);
    		columna = getRndVal(0, 9);
    		if(mapa[columna][fila].type == 0){
    			mapa[columna][fila].type = 1;
    			contador++;
    		}
		}
    }
    /*Se eligen casillas al azar del mapa, si son tipo llanura se cambian a tipo Montana, si no lo son, el bucle While continua hasta que se 
     * satisface el 10% de Bosque requerido*/
    protected void InitMontana(){
    	int fila, columna;
    	int contador = 0;
    	//El bucle se repite 10 veces para satisfacer el 10% de montanias.
    	while(contador<10){
    		fila = getRndVal(0, 9);
    		columna = getRndVal(0, 9);
    		if(mapa[columna][fila].type == 0){
    			mapa[columna][fila].type = 3;
    			contador++;
    		}
		}
    }
    
    /************HASTA AQUI LLEGA LA ENTREGA DEL MAPA**************/
    /**
     * Devuelve el número del turno actual.
     * @return El número de turno actual.
     */
    public int getTurnNumberCurrent(){
        turno++;//System.out.println("NO IMPLEMENTADO Game: int getTurnNumberCurrent()");
        return turno;
        
    }
    
    /**
     * Devuelve una casilla del mapa.
     * @param x Coordenada X de la casilla a devolver.
     * @param y Coordenada Y de la casilla a devolver.
     * @return La casilla pedida.
     */
    public Square getSquare(int x, int y) {
    	//System.out.println(mapa[x][y].nameIcon);//Esta linea se uso en un inicio para ver la ruta que se usaba para llegar al fichero donde se encontraba la imagen.
        return mapa[x][y];
    }  
    /**
     * Devuelve el jugador con el identificador indicado.
     * @param idPlayer Identificador unívoco para el jugador.
     * @return El jugador con el identificador indicado.
     */
    public Player getPlayer(int idPlayer) {
        p1 = new Player(idPlayer);
    	return p1;
    }    
    
    /**
     * Funda una nueva ciudad desbloqueando la casilla seleccionada y las 8 casillas alrededor de ésta (si existen).
     * @param idPlayer El identificador del jugador que quiere fundar una nueva ciudad.
     * @param nameCity El nombre de la nueva ciudad.
     * @param x Coordenada X de la casilla sobre la que se quiere fundar la ciudad.
     * @param y Coordenada Y de la casilla sobre la que se quiere fundar la ciudad.
     */
    
    public void foundCity(int idPlayer, String nameCity, int x, int y) {
    	/*SE DESBLOQUEAN TODAS LAS CASILLAS ALREDEDOR DE UNA SELECCIONADA*/
    	
    	//PRIMERA FILA SUPERIOR A LA CASILLA SELECCIONADA
    	try{
    		mapa[x-1][y-1].locked = false;
    	}catch(Exception e){}
    	try{
    		mapa[x][y-1].locked = false;
    	}catch(Exception e){}
    	try{
    		mapa[x+1][y-1].locked = false;
    	}catch(Exception e){}
    	//FILA DE LA CASILLA SELECCIONADA
    	try{
    		mapa[x-1][y].locked = false;
    	}catch(Exception e){}
    	try{
    		mapa[x][y].locked = false;
    	}catch(Exception e){}
    	try{
    		mapa[x+1][y].locked = false;
    	}catch(Exception e){}
    	//FILA INFERIOR A LA CASILLA SELECCIONADA
    	try{
    		mapa[x-1][y+1].locked = false;
    	}catch(Exception e){}
    	try{
    		mapa[x][y+1].locked = false;
    	}catch(Exception e){}
    	try{
    		mapa[x+1][y+1].locked = false;
    	}catch(Exception e){}
    }    
    
    /**
     * Determina si un jugador puede construir algo en una casilla determinada si tiene recursos suficientes.
     * @param player El jugador que quiere construir.
     * @param square La casilla en la que se quiere construir la construcción.
     * @param idConstruction El tipo de construcción que se quiere construir.
     * @return True en caso de que pueda y false en caso contrario.
     */
    public boolean canBuild(Player player, Square square, int idConstruction) {
       // System.out.println("NO IMPLEMENTADO Game: boolean canBuild(Player player, Square square, int idConstruction)");
    	player = p1;
    	int terreno = square.type;
    	int [] recursos = player.getResources();
    	switch(terreno){
    	case 0: //LLANURA
    		switch(idConstruction){
    		case 10://cuartel
    			if(recursos[player.ORO] >= 3000 && recursos[player.MADERA] >= 3000 ){return true;}else{return false;}
    		case 11://colegio
    			if(recursos[player.ORO] >= 1500 && recursos[player.MADERA] >= 1500){return true;}else{return false;}
    		case 12://granja
    			if(recursos[player.ORO] >= 150 && recursos[player.MADERA] >= 300){return true;}else{return false;}
    		case 16://casa
    			if(recursos[player.ORO] >= 100 && recursos[player.MADERA] >= 300){return true;}else{return false;}
    		case 17://mercado
    			if(recursos[player.ORO] >= 100 && recursos[player.MADERA] >= 200){return true;}else{return false;}
    		default: return false;
    		}
    		
    	case 1: //BOSQUE
    		switch(idConstruction){
    		case 10://cuartel
    			if(recursos[player.ORO] >= 3000 && recursos[player.MADERA] >= 3000 ){return true;}else{return false;}
    		case 11://colegio
    			if(recursos[player.ORO] >= 1500 && recursos[player.MADERA] >= 1500){return true;}else{return false;}
    		case 12://granja
    			if(recursos[player.ORO] >= 150 && recursos[player.MADERA] >= 300){return true;}else{return false;}
    		case 16://casa
    			if(recursos[player.ORO] >= 100 && recursos[player.MADERA] >= 300){return true;}else{return false;}
    		case 17://mercado
    			if(recursos[player.ORO] >= 100 && recursos[player.MADERA] >= 200){return true;}else{return false;}
    		case 14://aserradero
    			if(recursos[player.ORO] >= 100 && recursos[player.MADERA] >= 200){return true;}else{return false;}
    		default: return false;
    		}
    		
    	case 2: //MAR
    		switch(idConstruction){
    		case 15://barco
    			if(recursos[player.ORO] >= 200 && recursos[player.MADERA] >= 400){return true;}else{return false;}
    		default: return false;
    		}
    		
    	case 3: //MONTANA
    		switch(idConstruction){
    		case 13://mina
    			if(recursos[player.ORO] >= 100 && recursos[player.MADERA] >= 200){return true;}else{return false;}
    		default: return false;
    		}
    	//se considerara SELVA cuando no haya sido ninguna de las anteriores, y no se podra construir nada--return False
    	default: return true;
    	}
    }
    
    /**
     * Construye una construcción en una casilla determinada para un jugador.
     * @param player El jugador que quiere construir.
     * @param square La casilla en la que se quiere construir la construcción.
     * @param idConstruction El tipo de construcción que se quiere construir.
     */
    public void build(Player player, Square square, int idConstruction) {
        System.out.println("NO IMPLEMENTADO Game: void build(Player player, Square square, int idConstruction)");
        
    }            
    
    /**
     * Destruye la construcción previa, devolviendo la casilla al terreno original previo a la construcción.
     * @param x Coordenada X de la casilla que se quiere demoler.
     * @param y Coordenada Y de la casilla que se quiere demoler.
     */
    public void destroyConstruction(int x, int y){
        System.out.println("NO IMPLEMENTADO Game: void destroyConstruction(int x, int y)");
    }    

    /**
     * Determina si una ciudad puede ampliar su frontera en una cierta casilla.
     * @param player El jugador que quiere ampliar la frontera.
     * @param nameCity La ciudad a la que se quiere anexionar la nueva casilla.
     * @param x Coordenada X de la casilla que se quiere anexionar.
     * @param y Coordenada y de la casilla que se quiere anexionar. 
     * @return True en caso de que pueda y false en caso contrario.
     */
    public boolean canExpandBorder(Player player, String nameCity, int x, int y) {        
        System.out.println("NO IMPLEMENTADO Game: boolean canExpandBorder(Player player, String nameCity, int x, int y)");        
        // Comprobar si el jugador tiene recursos suficientes para ampliar la frontera.
        // Comprobar si la casilla que se quiere ampliar es adyacente a otra de la ciudad "nameCity". No valen casillas en diagonal.
        return false;
    }

    /**
     * Amplia la frontera de una ciudad anexionando una casilla.
     * @param player El jugador que quiere ampliar la frontera.
     * @param nameCity La ciudad a la que se quiere anexionar la nueva casilla.
     * @param x Coordenada X de la casilla que se quiere anexionar.
     * @param y Coordenada y de la casilla que se quiere anexionar. 
     */
    
    public void expandBorder(Player player, String nameCity, int x, int y) {
        System.out.println("NO IMPLEMENTADO Game: void expandBorder(Player player, String nameCity, int x, int y)");
    }    
    
    /**
     * Determina si un jugador puede subir el nivel de una construcción en una casilla determinada si tiene recursos suficientes.
     * @param player El jugador que quiere subir el nivel de una construcción.
     * @param square La casilla en la que se quiere subir de nivel la construcción.
     * @return True en caso de que pueda y false en caso contrario.
     */
    public boolean canUpgradeLevel(Player player, Square square){
        System.out.println("NO IMPLEMENTADO Game: boolean canUpgradeLevel(Player player, Square square)");
        // Comprobar si la construcción puede subir más de nivel.
        // Comprobar si el jugador tiene suficientes recursos y población disponible para subir de nivel la construcción.    
        return false;
    }

    /**
     * Sube el nivel de una construcción en una casilla determinada si el jugador tiene recursos suficientes.
     * @param player El jugador que quiere subir el nivel de una construcción.
     * @param square La casilla en la que se quiere subir de nivel la construcción.
     */
    public void upgradeLevel(Player player, Square square){
        System.out.println("NO IMPLEMENTADO Game: void upgradeLevel(Player player, Square square)");    
    }    

    /**
     * Determina si un jugador puede reparar una construcción en una casilla determinada si tiene recursos suficientes.
     * @param player El jugador que quiere reparar.
     * @param square La casilla en la que se quiere reparar la construcción.
     * @return True en caso de que pueda y false en caso contrario.
     */
    public boolean canRepair(Player player, Square square) {
        System.out.println("NO IMPLEMENTADO Game: boolean canRepair(Player player, Square square)");
        // Comprobar si la construcción puede ser reparada.
        // Comprobar si el jugador tiene suficientes recursos y población disponible para reparar la construcción.
        return false;
    }
    
    /**
     * Reparar una construcción en una casilla determinada si tiene recursos suficientes.
     * @param player El jugador que quiere reparar.
     * @param square La casilla en la que se quiere reparar la construcción.
     */
    public void repair(Player player, Square square) {
        System.out.println("NO IMPLEMENTADO Game: void repair(Player player, Square square)");
    }
    
    /**
     * Determina si el jugador tiene una construcción de nivel máximo en todas las casillas que permiten construir algo.
     * @param player El jugador para el que se comprueba la dominación global.
     * @return True en caso de que el jugador haya conseguido la dominación global y false en caso contrario.
     */
    public boolean isGlobalDomination(Player player){
        System.out.println("NO IMPLEMENTADO Game: boolean isGlobalDomination(Player player)");
        return false;
    }    
    
    /**
     * Ejecuta el turno actual.
     * @return Identificador de la situación que indica que el juego continúa o el tipo de victoria o derrota.
     */
    public int executeTurn(){
        System.out.println("NO IMPLEMENTADO Game: int executeTurn()");
        // Comprobar condiciones de victoria.
        // Determinar daños construcciones.
        // Recontar población después de atacar las construcciones.        
        // Sumar ganancias y restar mantenimiento
        
        /*
        NOTA:El valor de retorno de este método indica a la interfaz si la partida continúa o si se ha cumplido alguna de las condiciones de fin de partida.
        Estos son los valores que debe retornar este método, según sea el caso:
            Se continúa la partida = 0;
            Se pierde por población disponible baja = 1;
            Se pierde por tener el oro muy bajo = 11;
            Se pierde por tener la madera muy baja = 12;
            Se pierde por tener la comida muy baja = 13;
            Se gana la partida por dominación global = 14;
        */
        
        return 0;
    }
    
}
