package com.basic.reflection.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

public class CodeProcessor extends AbstractProcessor {
	
	private final String SUFFIX = "$WrmRequestInfo";
	
	private Messager messager;
	
	private Filer filer;
	
	private Types mTypeUtils;
	
	@Override
	public synchronized void init(ProcessingEnvironment processingEnvironment) {
		super.init(processingEnvironment);
		messager = processingEnvironment.getMessager();
		filer = processingEnvironment.getFiler();
		mTypeUtils = processingEnvironment.getTypeUtils();
	}
	
	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public Set<String> getSupportedAnnotationTypes(){
		LinkedHashSet<String> annotations = new LinkedHashSet<String>();
		annotations.add(Code.class.getCanonicalName());
		return annotations;
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for(javax.lang.model.element.Element element : roundEnv.getElementsAnnotatedWith(Code.class)) {
			Code code = element.getAnnotation(Code.class);
			TypeElement clazz = (TypeElement) element.getEnclosingElement();
			try {
				generateCode(element, code, clazz);
			} catch (IOException e) {
				processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.toString());
				return false;
			}
		}
		
		return true;
	}

	
	private void generateCode(javax.lang.model.element.Element element, Code code, TypeElement clazz) throws IOException{
		JavaFileObject file = filer.createSourceFile(clazz.getQualifiedName() + SUFFIX);
		messager.printMessage(Diagnostic.Kind.NOTE, "Creating " + file.toUri());
		Writer writer = file.openWriter();
		try {
			String pack = clazz.getQualifiedName().toString();
			PrintWriter pw = new PrintWriter(writer);
			pw.println("package " + pack.substring(0, pack.lastIndexOf(".")) + ";");
			pw.println("\n class " + clazz.getSimpleName() + "Autogenerate {");
			pw.println("\n protected " + clazz.getSimpleName() + "Autogeneratr() {}");
			 pw.println("    protected final void message() {");//create method
           pw.println("\n//" + element);
           pw.println("//" + code);
           pw.println("\n        System.out.println(\"author:" + code.author() + "\");");
           pw.println("\n        System.out.println(\"date:" + code.date() + "\");");
           pw.println("    }");
           pw.println("}");
           pw.flush();
		}finally {
			
		}
		
		
	}
	
}
