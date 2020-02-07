import java.util.ArrayList;

public class PreSubj{

	public static ArrayList<String> PreSubjConjugation(String v){
		StringBuilder c1, c2, c3, c4, c5, c6;
		String d1, d2, d3, d4, d5, d6;
		ArrayList<String> retVal = new ArrayList<String>();
		//IRREGULAR VERBS IN THE SUBJUNCTIVE MOOD
		String w = v.substring(v.length()-2).toLowerCase();
		//				System.out.println(w);

		if(w.equals("ar") || w.equals("er") || w.equals("ir")){
			if(v.equals("hacer")){
				String root = "hag";
				c1= new StringBuilder(root);
				d1 =c1.append("a").toString();
				c2= new StringBuilder(root);
				d2 =c2.append("as").toString();
				c3= new StringBuilder(root);
				d3 = c3.append("a").toString();
				c4= new StringBuilder(root);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("decir")){
				String root = "dig";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);

			}
			else if(v.equals("llegar")){
				String root = "llegu";
				c1= new StringBuilder(root);
				d1= c1.append("e").toString();
				c2= new StringBuilder(root);
				d2= c2.append("es").toString();
				c3= new StringBuilder(root);
				d3= c3.append("e").toString();
				c4= new StringBuilder(root);
				d4= c4.append("emos").toString();
				c5= new StringBuilder(root);
				d5= c5.append("éis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("en").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("comenzar")){
				String root = "comienc";
				String root2 = "comenc";
				c1= new StringBuilder(root);
				d1= c1.append("e").toString();
				c2= new StringBuilder(root);
				d2= c2.append("es").toString();
				c3= new StringBuilder(root);
				d3= c3.append("e").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("emos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("éis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("en").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("conocer")){
				String root = "conozc";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);

			}
			else if(v.equals("obtener")){
				String root = "obteng";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("pagar")){
				String root = "pagu";
				c1= new StringBuilder(root);
				d1= c1.append("e").toString();
				c2= new StringBuilder(root);
				d2= c2.append("es").toString();
				c3= new StringBuilder(root);
				d3= c3.append("e").toString();
				c4= new StringBuilder(root);
				d4= c4.append("emos").toString();
				c5= new StringBuilder(root);
				d5= c5.append("éis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("en").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);

			}
			else if(v.equals("mover")){
				String root = "muev";
				String root2 = "mov";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);

			}
			else if(v.equals("tener")){
				String root = "teng";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);

			}
			else if(v.equals("salir")){
				String root = "salg";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("venir")){
				String root = "veng";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			//For -ar and -er stem-changing verbs, the formula applies except that there is no stem change in the nosotros and vosotros forms. 
			else if(v.equals("pensar")){
				String root = "piens";
				String root2 = "pens";
				c1= new StringBuilder(root);
				d1= c1.append("e").toString();
				c2= new StringBuilder(root);
				d2= c2.append("es").toString();
				c3= new StringBuilder(root);
				d3= c3.append("e").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("emos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("éis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("en").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}

			else if(v.equals("perder")){
				String root = "pierd";
				String root2 = "perd";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("contar")){
				String root = "cuent";
				String root2 = "cont";
				c1= new StringBuilder(root);
				d1= c1.append("e").toString();
				c2= new StringBuilder(root);
				d2= c2.append("es").toString();
				c3= new StringBuilder(root);
				d3= c3.append("e").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("emos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("éis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("en").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			//For -ir stem-changing verbs, the formula applies except that the stem change in the nosotros and vosotros forms follows these patterns: o:ue verbs change o to u; e:ie verbs change e to i; e:i verbs change e to i. 
			else if(v.equals("volver")){
				String root = "vuelv";
				String root2 = "volv";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("dormir")){
				String root = "duerm";
				String root2 = "durm";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("sentir")){
				String root = "sient";
				String root2 = "sint";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("pedir")){
				String root = "pid";
				String root2 = "pid";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			//For verbs that end in -zar, the z changes to c when it comes before the letter e.
			else if(v.equals("empezar")){
				String root = "emp";
				String root2 = "emp";
				c1= new StringBuilder(root);
				d1= c1.append("iece").toString();
				c2= new StringBuilder(root);
				d2= c2.append("ieces").toString();
				c3= new StringBuilder(root);
				d3= c3.append("iece").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("ecemos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("ecéis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("iecen").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("jugar")){
				String root = "juegu";
				String root2="jugu";
				c1= new StringBuilder(root);
				d1= c1.append("e").toString();
				c2= new StringBuilder(root);
				d2= c2.append("es").toString();
				c3= new StringBuilder(root);
				d3= c3.append("e").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("emos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("éis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("en").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			//For verbs that end in -ger or -gir, the g changes to j when it comes before the letter a.
			else if(v.equals("escoger")){
				String root = "esco";
				String root2 = "esco";
				c1= new StringBuilder(root);
				d1= c1.append("ja").toString();
				c2= new StringBuilder(root);
				d2= c2.append("jas").toString();
				c3= new StringBuilder(root);
				d3= c3.append("ja").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("jamos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("jáis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("jan").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("elegir")){
				String root = "elij";
				String root2 = "elij";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			//For verbs that end in -guir, the gu changes to g when it comes before the letter a.
			else if(v.equals("seguir")){
				String root = "sig";
				String root2 = "sig";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}

			//For verbs that end in -car, the c changes to qu when it comes before the letter e.
			else if(v.equals("buscar")){
				String root = "busq";
				String root2 = "busq";
				c1= new StringBuilder(root);
				d1= c1.append("ue").toString();
				c2= new StringBuilder(root);
				d2= c2.append("ues").toString();
				c3= new StringBuilder(root);
				d3= c3.append("ue").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("uemos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("uéis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("uen").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}

			//For verbs that end in uir, add the letter y before the letter a.
			else if(v.equals("huir")){
				String root = "huy";
				String root2 = "huy";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			//Here are the six verbs that are irregular in the present subjunctive:
			else if(v.equals("dar")){
				String root = "d";
				String root2 = "d";
				c1= new StringBuilder(root);
				d1= c1.append("é").toString();
				c2= new StringBuilder(root);
				d2= c2.append("es").toString();
				c3= new StringBuilder(root);
				d3= c3.append("é").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("emos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("eis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("en").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("estar")){
				String root = "est";
				String root2 = "est";
				c1= new StringBuilder(root);
				d1= c1.append("é").toString();
				c2= new StringBuilder(root);
				d2= c2.append("és").toString();
				c3= new StringBuilder(root);
				d3= c3.append("é").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("emos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("éis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("en").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);

			}

			else if(v.equals("haber")){
				String root = "hay";
				String root2 = "hay";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("ir")){
				String root = "vay";
				String root2 = "vay";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("saber")){
				String root = "sep";
				String root2 = "sep";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			else if(v.equals("ser")){
				String root = "se";
				String root2 = "se";
				c1= new StringBuilder(root);
				d1= c1.append("a").toString();
				c2= new StringBuilder(root);
				d2= c2.append("as").toString();
				c3= new StringBuilder(root);
				d3= c3.append("a").toString();
				c4= new StringBuilder(root2);
				d4= c4.append("amos").toString();
				c5= new StringBuilder(root2);
				d5= c5.append("áis").toString();
				c6= new StringBuilder(root);
				d6= c6.append("an").toString();
				retVal.add(d1);
				retVal.add(d2);
				retVal.add(d3);
				retVal.add(d4);
				retVal.add(d5);
				retVal.add(d6);
			}
			//Non-Irregular Verbs
			else{
				String l = v.substring(v.length()-2);
				String root = v.substring(0,v.length()-2);

				//				System.out.println("The root is: " + root);
				//				System.out.println("The ending is: " + l);
				if(l.equals("ar")){

					c1= new StringBuilder(root);
					d1= c1.append("e").toString();
					c2= new StringBuilder(root);
					d2= c2.append("es").toString();
					c3= new StringBuilder(root);
					d3= c3.append("e").toString();
					c4= new StringBuilder(root);
					d4= c4.append("emos").toString();
					c5= new StringBuilder(root);
					d5= c5.append("éis").toString();
					c6= new StringBuilder(root);
					d6= c6.append("en").toString();
					retVal.add(d1);
					retVal.add(d2);
					retVal.add(d3);
					retVal.add(d4);
					retVal.add(d5);
					retVal.add(d6);

				}
				else if(l.equals("er") || l.equals("ir")){
					c1= new StringBuilder(root);
					d1= c1.append("a").toString();
					c2= new StringBuilder(root);
					d2= c2.append("as").toString();
					c3= new StringBuilder(root);
					d3= c3.append("a").toString();
					c4= new StringBuilder(root);
					d4= c4.append("amos").toString();
					c5= new StringBuilder(root);
					d5= c5.append("áis").toString();
					c6= new StringBuilder(root);
					d6= c6.append("an").toString();
					retVal.add(d1);
					retVal.add(d2);
					retVal.add(d3);
					retVal.add(d4);
					retVal.add(d5);
					retVal.add(d6);
				}


				else{
					System.out.println("THIS IS NOT A VERB OR THE VERB IS NOT IN ITS INFINITIVE FORM!!!!!");
				}

			}
		}
		return retVal;
	}
}
