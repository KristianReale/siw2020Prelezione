function Studente(matricola, nome, cognome, dataNascita){
	this.matricola = matricola;
	this.nome = nome;
	this.cognome = cognome;
	this.dataNascita = dataNascita;
}

function maschera(studente){
	svuota();
	document.getElementById("selStudente").innerHTML =
		"<h4>" + studente.matricola + " : "
		+ studente.nome + " : "
		+ studente.cognome + " </h4> ";
	var numComponenti = document.getElementById("numComponenti");
	numComponenti.addEventListener("blur", aggiungiCaselle);
	var butCalcola = document.getElementById("calcolaISEE");
	butCalcola.addEventListener("click", calcolaISEE);
	
}

function aggiungiCaselle(){
	var numComponenti = document.getElementById("numComponenti");
	var nComp = numComponenti.value;
	
	var tagValori = document.getElementById("valori");
	
	svuota();
	
	for (var i = 0; i < nComp; i++){
		var redd = document.createElement("div");
		redd.setAttribute("class", "form-group");
		redd.innerHTML = "<label>REDDITO del componente:</label>" +
				"<input class='redditoComponente' type='text' " +
				"class='form-control' />";
		
		var patr = document.createElement("div");
		patr.setAttribute("class", "form-group");
		patr.innerHTML = "<label>PATRIMONIO del componente:</label>" +
				"<input class='patrimonioComponente' type='text' " +
				"class='form-control' />";
		
		tagValori.appendChild(redd);
		tagValori.insertBefore(patr, redd.nextSibling);
		//tagValori.appendChild(patr);
	}
}

function svuota(){
	var tagValori = document.getElementById("valori");
	while (tagValori.firstChild){
		tagValori.removeChild(tagValori.firstChild);
	}
}

//var stud = new Studente("103123", "Mario", "Rossi", new Date(1/7/2018));
//var stud2 = new Studente("123", "Giorgio", "Bianchi", new Date(1/7/2018));

//alert(stud.nome);


function calcolaISEE(studente){
	//alert("Inizio procedura calcolo ISEE per lo studente "
		//	+ studente.nome + " " + studente.cognome);
	
	var tagNumComponenti = document.getElementById("numComponenti");	
	//var numeroComponenti = prompt("Inserisci il numero dei componenti");
	var numeroComponenti = parseInt(tagNumComponenti.value);
	
	var redditi = document.getElementsByClassName("redditoComponente");
	var patrimoni = document.getElementsByClassName("patrimonioComponente");
//	var i;
//	for (i = 0; i < numeroComponenti; i++){
//		componentiReddito[i] = prompt("Inserici il reddito del componente " 
//														+ (i + 1));
//		componentiPatrimonio[i] = prompt("Inserici il patrimonio del componente " 
//														+ (i + 1));
//	}
	
	//componentiReddito = new Array();
	//componentiPatrimonio = new Array();
	
	var redditoComplessivo = 0;
	var patrimonioComplessivo = 0;
	
//	for (i = 0; i < numeroComponenti; i++){
//		redditoComplessivo += parseInt(componentiReddito[i]);
//		patrimonioComplessivo += parseInt(componentiPatrimonio[i]);
//	}
	for (var i = 0; i < redditi.length; i++){
		redditoComplessivo += parseInt(redditi[i].value);
		patrimonioComplessivo += parseInt(patrimoni[i].value);
	}
	
	ISR = redditoComplessivo;
	ISP = patrimonioComplessivo;
	
	ISE = ISR + ISP * 20/100;
	
	scaleEquivalenza =
	{
			"1" : 1,
			"2" : 1.57,
			"3" : 2.04,
			"4" : 2.46,
			"5" : 2.85,
			
	};
	
	var SE;
	//switch (numeroComponenti){
	//case "1":
	//	SE = scaleEquivalenza["1"];
	//	break;
	//case "2":
	//	SE = scaleEquivalenza["2"];
	//	break;
	//case "3":
	//	SE = scaleEquivalenza["3"];
	//	break;
	//case "4":
	//	SE = scaleEquivalenza["4"];
	//	break;
	//case "5":
	//	SE = scaleEquivalenza["5"];
	//	break;
	//}
	
	var calcolaSe = function(numeroComponenti, scaleEquivalenza){
		if (numeroComponenti < 5){
			SE = scaleEquivalenza[numeroComponenti];
		}else{
			SE = scaleEquivalenza["5"];
		}
		return SE;
	}
	
	SE = calcolaSe(numeroComponenti, scaleEquivalenza);
	
	
	
	ISEE = ISE / SE;
	
//	report = "Report ISEE Calcolato:\n";
//	report += "Numero componenti nucleo familiare:" + numeroComponenti + "\n";
//	report += "Reddito complessivo nucleo familiare:" + redditoComplessivo + "\n";
//	report += "Patrimonio complessivo nucleo familiare:" + patrimonioComplessivo + "\n";
//	report += "Valore ISE:" + ISE + "\n";
//	report += "Scala di equivalenza applicata:" + SE + "\n";
//	report += "Valore ISEE:" + ISEE + "\n";
//	
//	alert(report);
	
	document.getElementById("ISR").innerHTML = ISR;
	document.getElementById("ISP").innerHTML = ISP;
	document.getElementById("ISE").innerHTML = ISE;
	document.getElementById("scalaEquivalenza").innerHTML = SE;
	document.getElementById("ISEE").innerHTML = ISEE;
}







