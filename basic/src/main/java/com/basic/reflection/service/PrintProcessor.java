package com.basic.reflection.service;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

public class PrintProcessor extends AbstractProcessor {
	
	private Messager messager;
	
	
	@Override
	public synchronized void init(ProcessingEnvironment processingEnvironment) {
		super.init(processingEnvironment);
		messager = processingEnvironment.getMessager();
	}
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for(TypeElement type : annotations) {
			for(javax.lang.model.element.Element element : roundEnv.getElementsAnnotatedWith(type)) {
				print(element.toString());
			}
		}
		return true;
	}
	
	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}
	
	public Set<String> getSupporedAnnotationTypes(){
		LinkedHashSet<String> annotations = new LinkedHashSet<String>();
		annotations.add(Print.class.getCanonicalName());
		return super.getSupportedAnnotationTypes();
	}
	
	private void print(String msg) {
		messager.printMessage(Diagnostic.Kind.NOTE, msg);
	}
}
	
	
