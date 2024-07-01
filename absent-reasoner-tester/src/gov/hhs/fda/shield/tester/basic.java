package gov.hhs.fda.shield.tester;

import java.io.File;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

import gov.hhs.fda.shield.ElkReasonerFactorySHIELD;
import gov.hhs.fda.shield.OntologyExplorer;

public class basic {

	public static void main(String[] args) throws OWLOntologyStorageException, OWLOntologyCreationException {
		// TODO Auto-generated method stub
		
		OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
		OWLOntologyManager outputOntologyManager = OWLManager.createOWLOntologyManager();
		OWLOntologyManager statementOntologyManager = OWLManager.createOWLOntologyManager();

		// Load ontology.
		OWLOntology originalOnt = ontologyManager.loadOntologyFromOntologyDocument(
		new File("C:/Users/wsuja/Documents/ConsultingEngagements/FDA/Research/SWEC-Classification/SWEC-Ontology-Example-9.owx"));
		
		/***** CREATE ElkReasonerSHIELD ******/
		ElkReasonerFactorySHIELD reasonerFactory = new ElkReasonerFactorySHIELD();
		OWLReasoner reasonerSHIELD = reasonerFactory.createBufferingReasoner(originalOnt);  // Only buffering reasoners will be allowed

		System.out.println("POST-INSTANTIATION ElkReasonerSHIELD OWL TAXONOMY");
		OntologyExplorer.printOwlTaxonomy(reasonerSHIELD.getTopClassNode(), 0, reasonerSHIELD);
		System.out.println();
		System.out.println("Disposing...");
		reasonerSHIELD.dispose();


	}

}
