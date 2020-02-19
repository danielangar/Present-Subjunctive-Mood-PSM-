/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.google.api.GoogleAPI;
import com.google.api.GoogleAPIException;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.language.v1beta1.CloudNaturalLanguageAPI;
import com.google.api.services.language.v1beta1.CloudNaturalLanguageAPIScopes;
import com.google.api.services.language.v1beta1.model.AnalyzeEntitiesRequest;
import com.google.api.services.language.v1beta1.model.AnalyzeEntitiesResponse;
import com.google.api.services.language.v1beta1.model.AnalyzeSentimentRequest;
import com.google.api.services.language.v1beta1.model.AnalyzeSentimentResponse;
import com.google.api.services.language.v1beta1.model.AnnotateTextRequest;
import com.google.api.services.language.v1beta1.model.AnnotateTextResponse;
import com.google.api.services.language.v1beta1.model.Document;
import com.google.api.services.language.v1beta1.model.Entity;
import com.google.api.services.language.v1beta1.model.Features;
import com.google.api.services.language.v1beta1.model.Sentiment;
import com.google.api.services.language.v1beta1.model.TextSpan;
import com.google.api.services.language.v1beta1.model.Token;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.IOException;
import java.io.PrintStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
/**
 * A sample application that uses the Natural Language API to perform
 * entity, sentiment and syntax analysis.
 */
public class Subjunctive {
	/**
	 * Be sure to specify the name of your application. If the application name is {@code null} or
	 * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
	 */
	private static final String APPLICATION_NAME = "";

	private static final int MAX_RESULTS = 4;
	/**
	 * Detects entities,sentiment and syntax in a document using the Natural Language API.
	 * @throws GoogleAPIException 
	 */
	public static void main(String[] args) throws IOException, GeneralSecurityException, GoogleAPIException {
		Scanner in = new Scanner(System.in);
//		Scanner in2 = new Scanner(System.in);
//		Scanner in3 = new Scanner(System.in);

		System.out.println("Enter the sentence in English: ");
		String text = in.nextLine();
//		System.out.println("Enter the verb in spanish: ");
//		String tvb = in2.nextLine();
//
//		System.out.println("Enter the sentence in spanish: ");
//		String esp = in3.nextLine();
		System.out.println("__________________________________________________________________________________________________");

		//Google Translate API
		 // Replace link with the HTTP referrer to your website address 
	    GoogleAPI.setHttpReferrer("google.com"); 
	 
	    // Replace key with the Google Translate API key 
	    GoogleAPI.setKey("AIzaSyD7XhQZLBeXVCkK-c6FtDfAwgnBZl_GhPs"); 
	 
	   
	    //Do the translation for the Spanish sentnece
	    
	    String esp = Translate.DEFAULT.execute(text, Language.ENGLISH, Language.SPANISH); 
		 System.out.println("GOOGLE TRANSLATION:" + esp);
		
		//Google NL API
		Subjunctive app = new Subjunctive(getLanguageService());
		app.analyzeSyntax(text);
		app.analyzeSyntax(esp);

		//Standford Natural Language API to tag Noun of the sentence
		// Initialize the tagger
		MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");

		// The tagged string
		String tagged = tagger.tagString(text);
		String[] arr = tagged.split(" ");
		getTagVerb(app.analyzeSyntax(text),app.analyzeSyntax(esp), arr);
	}

	public static void printSyntax(PrintStream out, List<Token> tokens) {
		if (tokens == null || tokens.size() == 0) {
			out.println("No syntax found");
			return;
		}
		out.printf("Found %d token%s.\n", tokens.size(), tokens.size() == 1 ? "" : "s");
		out.println("_____________________________");
		for (Token token : tokens) {
			out.println("TextSpan");
			out.printf("\tText: %s\n", token.getText().getContent());
			out.printf("\tBeginOffset: %d\n", token.getText().getBeginOffset());
			out.printf("Lemma: %s\n", token.getLemma());
			out.printf("PartOfSpeechTag: %s\n", token.getPartOfSpeech().getTag());
			out.println("DependencyEdge");
			out.printf("\tHeadTokenIndex: %d\n", token.getDependencyEdge().getHeadTokenIndex());
			out.printf("\tLabel: %s\n", token.getDependencyEdge().getLabel());
			out.println("____________________________");
		}
	}
	/**
	 * Connects to the Natural Language API using Application Default Credentials.
	 */
	public static CloudNaturalLanguageAPI getLanguageService() throws IOException, GeneralSecurityException {
		GoogleCredential credential = GoogleCredential.getApplicationDefault().createScoped(CloudNaturalLanguageAPIScopes.all());
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		return new CloudNaturalLanguageAPI.Builder(GoogleNetHttpTransport.newTrustedTransport(),jsonFactory, new HttpRequestInitializer() {
			public void initialize(HttpRequest request) throws IOException {
				credential.initialize(request);
			}
		}).setApplicationName(APPLICATION_NAME).build();
	}
	private final CloudNaturalLanguageAPI languageApi;

	/**
	 * Constructs a {@link Analyze} which connects to the Cloud Natural Language API.
	 */
	public Subjunctive(CloudNaturalLanguageAPI languageApi) {
		this.languageApi = languageApi;
	}

	public List<Token> analyzeSyntax(String text) throws IOException {
		AnnotateTextRequest request =
				new AnnotateTextRequest()
		.setDocument(new Document().setContent(text).setType("PLAIN_TEXT"))
		.setFeatures(new Features().setExtractSyntax(true))
		.setEncodingType("UTF16");
		CloudNaturalLanguageAPI.Documents.AnnotateText analyze = languageApi.documents().annotateText(request);

		AnnotateTextResponse response = analyze.execute();
		return response.getTokens();
	}
	public static void getTagVerb(List<Token> tokens, List<Token> tokens2, String[] arr) throws GoogleAPIException{

		String n1, n2, n3, n4, n5;
		String prp1 = "";
		ArrayList<String> q;
		String t = "";
		String e = "";
		String w1 = "";
		String w2="";
		String w3="";
		String w1a="";
		String tvb3= "";
		String[] pro = new String[t.length()];
		ArrayList<String> words = new ArrayList<String>(); //ArrayList for words of the sentence through google api(getText())
		ArrayList<String> noun = new ArrayList<String>(Arrays.asList(arr));//ArrayList for tagged words through Standford NLP api
		ArrayList<String> espanol = new ArrayList<String>();//ArrayList for Spanish words
		ArrayList<String> espanol2 = new ArrayList<String>();//ArrayLlist for Spanish tagging
		System.out.println("Standford NL API: " +noun);
//		System.out.println("__________________________________________________________________________________________________");
		//Getting the verb and its respective noun subject
		if (tokens == null || tokens.size() == 0) {
			System.out.println("No syntax found");
			return;
		}

		for (Token token : tokens) {

			t = token.getText().getContent();
			//			System.out.println(t);
			words.add(t);

			//			System.out.println(token.getDependencyEdge().getLabel());
			if(token.getDependencyEdge().getLabel().equals("CCOMP")){
				w1 = token.getLemma();
				System.out.println("This is the infinitive form of the verb: " + w1);
				w1a = "to" + " " + w1;
				System.out.println(w1a);
				w2 = token.getText().getContent();
			}
		}
//		System.out.println("Array enlish words:" + words);
//		System.out.println("This is the Present subjunctive verb: " +w2);

		//Translate the English sentence to Spanish and put it in an ArrayList

		for (Token token2 : tokens2) {
			e = token2.getText().getContent();
			espanol.add(e);
			espanol2.add(token2.getDependencyEdge().getLabel());
		}
		System.out.println("Arrray spanish words:" +espanol);
		System.out.println("Array spanish tagging:"+espanol2);

		PreSubj preV = new PreSubj();
		//Translate verb from English to Spanish
		 String tvb2 = Translate.DEFAULT.execute(w1a, Language.ENGLISH, Language.SPANISH); 
		 System.out.println("this is tvb2: " + tvb2);
		 //Checking if the translated verb to Spanish 
		 if (tvb2.regionMatches(true, 0, "para", 0, 4)){
			 tvb3= tvb2.substring(5);
			 q = preV.PreSubjConjugation(tvb3);//Sending the Spanish verb to be conjugated in the subjunctive mood
		 }
		 else{
			 q = preV.PreSubjConjugation(tvb2);
		 }
		 System.out.println("this is q:" + q);

		for(int i=0; i < noun.size(); i++){

			//Getting Personal Pronouns: _PRP
			String s = noun.get(i);
			
			////For VB tagging
			if(s.regionMatches(true, s.length()-3, "_VB", 0, 3) && s.substring(0, s.length()-3).equals(w1)){
				String posesive = noun.get(i-2);//Possessive for affirmative
				String posesive2 = noun.get(i-3);//Possessive for affirmative
				String p=noun.get(i-1);//Noun for affirmative
				String p2=noun.get(i-2);//Noun for negative
				//sentences in negation
				if(p.equals("not_RB")){
					
					if(posesive2.regionMatches(true, posesive2.length()-5, "_PRP$", 0, 5) && p2.regionMatches(true, p2.length()-3, "_NN", 0, 3)){
						String s1 = words.get(i);
						prp1=q.get(2);
					}

					else if(p2.regionMatches(true, p2.length()-4, "_PRP", 0, 4)){
						n1 = p2.substring(0, p2.length()-4);

						if(n1.equals("I")){
							prp1 = q.get(0);
						}
						else if(n1.equals("you")){
							prp1 = q.get(1);
						}
						else if(n1.equals("she")||n1.equals("he")||n1.equals("it")){
							prp1 = q.get(2);
						}

						else if(n1.equals("we")){
							prp1 = q.get(3);
						}
						else if(n1.equals("you")){
							prp1 = q.get(4);
						}
						else if(n1.equals("they")){
							prp1 = q.get(5);
						}
					}
					//Getting Noun, singular, mass: _NN
					else if(p2.regionMatches(true, p2.length()-3, "_NN", 0, 3)){
						n2 = p2.substring(0, p2.length()-3);
						prp1 = q.get(2);
					}
					//Getting Proper Noun, singular: _NNP
					else if(p2.regionMatches(true, p2.length()-4, "_NNP", 0, 4)){
						n3 = p2.substring(0, p2.length()-4);
						prp1 = q.get(2);
					}
					//Getting Noun Plural: _NNS
					else if(p2.regionMatches(true, p2.length()-4, "_NNS", 0, 4)){
						n4 = p2.substring(0, p2.length()-4);
						prp1 = q.get(5);
					}
				}
				//Affirmative Sentences
				else{
					
					if(posesive.regionMatches(true, posesive.length()-5, "_PRP$", 0, 5) && p.regionMatches(true, p.length()-3, "_NN", 0, 3)){
						prp1=q.get(2);
					}

					if(p.regionMatches(true, p.length()-4, "_PRP", 0, 4)){
						n1 = p.substring(0, p.length()-4);

						if(n1.equals("I")){
							prp1 = q.get(0);
						}
						else if(n1.equals("you")){
							prp1 = q.get(1);
						}
						else if(n1.equals("she")||n1.equals("he")||n1.equals("it")){
							prp1 = q.get(2);
						}

						else if(n1.equals("we")){
							prp1 = q.get(3);
						}
						else if(n1.equals("you")){
							prp1 = q.get(4);
						}
						else if(n1.equals("they")){
							prp1 = q.get(5);
						}
					}
					//Getting Noun, singular, mass: _NN
					else if(p.regionMatches(true, p.length()-3, "_NN", 0, 3)){
						n2 = p.substring(0, p.length()-3);
						prp1 = q.get(2);
					}
					//Getting Proper Noun, singular: _NNP
					else if(p.regionMatches(true, p.length()-4, "_NNP", 0, 4)){
						n3 = p.substring(0, p.length()-4);
						prp1 = q.get(2);
					}
					//Getting Noun Plural: _NNS
					else if(p.regionMatches(true, p.length()-4, "_NNS", 0, 4)){
						n4 = p.substring(0, p.length()-4);
						prp1 = q.get(5);
					}
				}
			}
			
			//For VBP tagging
			else if(s.regionMatches(true, s.length()-4, "_VBP", 0, 4) && s.substring(0, s.length()-4).equals(w1)){
				String p=noun.get(i-1);
				String posesive = noun.get(i-2);
				//sentences in negation
				if(p.equals("not_RB")){
					String p2=noun.get(i-2);//For negative noun
					String posesive3 = noun.get(i-3); //For negative possessive
					if(posesive3.regionMatches(true, posesive3.length()-5, "_PRP$", 0, 5) && p2.regionMatches(true, p2.length()-3, "_NN", 0, 3)){
						String s1 = words.get(i);
						String sp = s1.substring(0, s.length()-3);
						prp1=q.get(2);
					}
					else if(p2.regionMatches(true, p2.length()-4, "_PRP", 0, 4)){
						n1 = p2.substring(0, p2.length()-4);
						if(n1.equals("I")){
							prp1 = q.get(0);
						}
						else if(n1.equals("you")){
							prp1 = q.get(1);
						}
						else if(n1.equals("she")||n1.equals("he")||n1.equals("it")){
							prp1 = q.get(2);
						}

						else if(n1.equals("we")){
							prp1 = q.get(3);
						}
						else if(n1.equals("you")){
							prp1 = q.get(4);
						}
						else if(n1.equals("they")){
							prp1 = q.get(5);
						}
					}
					//Getting Noun, singular, mass: _NN
					else if(p2.regionMatches(true, p2.length()-3, "_NN", 0, 3)){
						n2 = p2.substring(0, p2.length()-3);
						prp1 = q.get(2);
					}
					//Getting Proper Noun, singular: _NNP
					else if(p2.regionMatches(true, p2.length()-4, "_NNP", 0, 4)){
						n3 = p2.substring(0, p2.length()-4);
						prp1 = q.get(2);
					}
					//Getting Noun Plural: _NNS
					else if(p2.regionMatches(true, p2.length()-4, "_NNS", 0, 4)){
						n4 = p2.substring(0, p.length()-4);
						prp1 = q.get(5);
					}
				}
				//Affirmative Sentences
				else{
					if(posesive.regionMatches(true, posesive.length()-5, "_PRP$", 0, 5) && p.regionMatches(true, p.length()-4, "_NNS", 0, 4)){
						prp1=q.get(5);
					}
					else if(p.regionMatches(true, p.length()-4, "_PRP", 0, 4)){
						n1 = p.substring(0, p.length()-4);

						if(n1.equals("I")){
							prp1 = q.get(0);
						}
						else if(n1.equals("you")){
							prp1 = q.get(1);
						}
						else if(n1.equals("she")||n1.equals("he")||n1.equals("it")){
							prp1 = q.get(2);
						}

						else if(n1.equals("we")){
							prp1 = q.get(3);
						}
						else if(n1.equals("you")){
							prp1 = q.get(4);
						}
						else if(n1.equals("they")){
							prp1 = q.get(5);
						}
					}
					//Getting Noun, singular, mass: _NN
					else if(p.regionMatches(true, p.length()-3, "_NN", 0, 3)){
						n2 = p.substring(0, p.length()-3);
						prp1 = q.get(2);
					}
					//Getting Proper Noun, singular: _NNP
					else if(p.regionMatches(true, p.length()-4, "_NNP", 0, 4)){
						System.out.println("Todo bien papi");
						n3 = p.substring(0, p.length()-4);
						System.out.println("este es n3:" + n3);
						prp1 = q.get(2);
						System.out.println("prnom:" +prp1);
					}
					//Getting Noun Plural: _NNS
					else if(p.regionMatches(true, p.length()-4, "_NNS", 0, 4)){
						n4 = p.substring(0, p.length()-4);
						prp1 = q.get(5);
						System.out.println("This is the verb in the subjuntive mood: " +prp1);

					}
				}
			}
		}
		//For matching and replacing the wrong verb
		System.out.println("__________________________________________________________________________________________________");
		if(espanol2.contains("ROOT") && espanol2.contains("CSUBJ")){
			
			if(espanol2.contains("AUX")){
//				System.out.println("here1");
				int i = espanol2.indexOf("AUX");
//				System.out.println("index:" + i);
				espanol.set(i, prp1);
				String result = String.join(" ", espanol);
				System.out.println("Correct Translation: " + result);
			}
			else{
//				System.out.println("here3");
				int i = espanol2.indexOf("CSUBJ");
//				System.out.println("index:" + i);
				espanol.set(i, prp1);
				String result = String.join(" ", espanol);
				System.out.println("Correct Translation: " + result);
			}
			
		}
		else if(espanol2.contains("AUX") && espanol2.contains("MWE") && espanol2.contains("CCOMP")){
			if(espanol2.contains("AUX")){
//				System.out.println("here2");
				int i = espanol2.indexOf("AUX");
//				System.out.println("index:" + i);
				espanol.set(i, prp1);
				String result = String.join(" ", espanol);
				System.out.println("Correct Translation: " + result);
			}
			else{
				System.out.println("Oops!!!. Possible incorrect tagging");
			}
			
		}
//		else if( espanol2.contains("ROOT") && espanol2.contains("CSUBJ")){
//			System.out.println("here3");
//			int i = espanol2.indexOf("CSUBJ");
////			System.out.println("index:" + i);
//			espanol.set(i, prp1);
//			String result = String.join(" ", espanol);
//			System.out.println("Correct Translation: " + result);
//		}
		else if(espanol2.contains("ROOT") && espanol2.contains("CCOMP")){
			if(espanol2.contains("CCOMP")){
//				System.out.println("here4");
				int i = espanol2.indexOf("CCOMP");
//				System.out.println("index:" + i);
				espanol.set(i, prp1);
				String result = String.join(" ", espanol);
				System.out.println("Correct Translation: " + result);
			}
			else{
				System.out.println("Oops!!!. Possible incorrect tagging");
			}
			
		}
		else if(espanol2.contains("ROOT") && espanol2.contains("PCOMP")){
			if(espanol2.contains("PCOMP")){
//				System.out.println("here5");
				int i = espanol2.indexOf("PCOMP");
//				System.out.println("index:" + i);
				espanol.set(i, prp1);
				String result = String.join(" ", espanol);
				System.out.println("Correct Translation: " + result);
			}
			else{
				System.out.println("Oops!!!. Possible incorrect tagging");
			}
		}
		else if(espanol2.contains("CSUBJPASS")){
			if(espanol2.contains("CSUBJPASS")){
//				System.out.println("here6");
				int i = espanol2.indexOf("CSUBJPASS");
//				System.out.println("index:" + i);
				espanol.set(i, prp1);
				String result = String.join(" ", espanol);
				System.out.println("Correct Translation: " + result);
			}
			else{
				System.out.println("Oops!!!. Possible incorrect tagging");
			}
			
		}

		else if(espanol2.contains("DOBJ")){
			if(espanol2.contains("DOBJ")){
//				System.out.println("here7");
				int i = espanol2.indexOf("DOBJ");
//				System.out.println("index:" + i);
				espanol.set(i, prp1);
				String result = String.join(" ", espanol);
				System.out.println("Correct Translation: " + result);
			}
			else{
				System.out.println("Oops!!!. Possible incorrect tagging");
			}
		}
		else if(espanol2.contains("ROOT")){
			
			if(espanol2.contains("PCOMP")){
//				System.out.println("here8");
				int i = espanol2.indexOf("PCOMP");
//				System.out.println("index:" + i);
				espanol.set(i, prp1);
				String result = String.join(" ", espanol);
				System.out.println("Correct Translation: " + result);
			}
			else{
				System.out.println("Oops!!!. Possible incorrect tagging");
			}
			
		}
		System.out.println("__________________________________________________________________________________________________");
	}

}


