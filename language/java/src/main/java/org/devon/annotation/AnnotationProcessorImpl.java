package org.devon.annotation;


import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

public class AnnotationProcessorImpl extends AbstractProcessor {
   private static final Logger LOG = LoggerFactory.getLogger(AnnotationProcessorImpl.class);
   private static final String ANNOTATION_CONFIG_FILE = "META-INF/annotation-config";
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        final Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        final JavacElements javacElements = (JavacElements) processingEnv.getElementUtils();
        final TreeMaker treeMaker = TreeMaker.instance(context);
        Set<? extends Element> elements = roundEnv.getRootElements();

        Set<? extends Element> myAnnotationElements = roundEnv.getElementsAnnotatedWith(MyAnnotation.class);

        if (myAnnotationElements == null|| myAnnotationElements.size()== 0) {
            return false;
        }

        LOG.info("annotations size:{} elements:{}",elements.size(),elements);
        Writer writer = null;

        try {
            FileObject resource = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", ANNOTATION_CONFIG_FILE);
            writer = resource.openWriter();

        for (Element element : myAnnotationElements) {
            if(ElementKind.METHOD==element.getKind()){
                //get append info by element
                writer.append("append info");
                writer.append("\n");
            }

            JCTree.JCMethodDecl  jcMethodDecl = (JCTree.JCMethodDecl)javacElements.getTree(element);
            treeMaker.pos= jcMethodDecl.pos;
           // treeMaker.Block(0, List.of(treeMaker.Exec(treeMaker.Apply(null))));
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}
