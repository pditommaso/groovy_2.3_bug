In order to reproduce the issue, enter: 

    ./gradlew compileGroovy 
    
    

It reports: 

    FAILURE: Build failed with an exception.

    * What went wrong:
    Execution failed for task ':modulex:compileGroovy'.
    > BUG! exception in phase 'class generation' in source unit '/Users/pditommaso/Downloads/groovy_2.3_bug/subprojects/modulex/src/main/Main.groovy' Type is null. Most probably you let a transform reuse existing ClassNodes with generics information, that is now used in a wrong context.


Building with IntelliJ it reports the following stack trace: 

    Error:Groovyc: BUG! exception in phase 'class generation' in source unit '/Users/pditommaso/workspace/groovy_2.3_bug/subprojects/modulex/src/main/Main.groovy' Type is null. Most probably you let a transform reuse existing ClassNodes with generics information, that is now used in a wrong context.
        at org.codehaus.groovy.vmplugin.v5.Java5.configureType(Java5.java:125)
        at org.codehaus.groovy.vmplugin.v5.Java5.configureTypeArguments(Java5.java:186)
        at org.codehaus.groovy.vmplugin.v5.Java5.configureParameterizedType(Java5.java:166)
        at org.codehaus.groovy.vmplugin.v5.Java5.configureType(Java5.java:117)
        at org.codehaus.groovy.vmplugin.v5.Java5.configureTypeArguments(Java5.java:186)
        at org.codehaus.groovy.vmplugin.v5.Java5.configureParameterizedType(Java5.java:166)
        at org.codehaus.groovy.vmplugin.v5.Java5.configureType(Java5.java:117)
        at org.codehaus.groovy.vmplugin.v5.Java5.makeClassNode(Java5.java:431)
        at org.codehaus.groovy.vmplugin.v5.Java5.configureClassNode(Java5.java:364)
        at org.codehaus.groovy.ast.ClassNode.lazyClassInit(ClassNode.java:261)
        at org.codehaus.groovy.ast.ClassNode.getUnresolvedSuperClass(ClassNode.java:981)
        at org.codehaus.groovy.ast.ClassNode.getUnresolvedSuperClass(ClassNode.java:976)
        at org.codehaus.groovy.ast.ClassNode.getSuperClass(ClassNode.java:970)
        at org.codehaus.groovy.ast.ClassNode.isDerivedFrom(ClassNode.java:913)
        at org.codehaus.groovy.classgen.asm.InvocationWriter.castToNonPrimitiveIfNecessary(InvocationWriter.java:794)
        at org.codehaus.groovy.classgen.asm.OperandStack.doConvertAndCast(OperandStack.java:344)
        at org.codehaus.groovy.classgen.asm.OperandStack.doGroovyCast(OperandStack.java:279)
        at org.codehaus.groovy.classgen.asm.BinaryExpressionHelper.evaluateEqual(BinaryExpressionHelper.java:397)
        at org.codehaus.groovy.classgen.asm.BinaryExpressionHelper.eval(BinaryExpressionHelper.java:81)
        at org.codehaus.groovy.classgen.AsmClassGenerator.visitBinaryExpression(AsmClassGenerator.java:565)
        at org.codehaus.groovy.ast.expr.BinaryExpression.visit(BinaryExpression.java:49)
        at org.codehaus.groovy.classgen.asm.StatementWriter.writeExpressionStatement(StatementWriter.java:604)
        at org.codehaus.groovy.classgen.asm.OptimizingStatementWriter.writeExpressionStatement(OptimizingStatementWriter.java:354)
        at org.codehaus.groovy.classgen.AsmClassGenerator.visitExpressionStatement(AsmClassGenerator.java:547)
        at org.codehaus.groovy.ast.stmt.ExpressionStatement.visit(ExpressionStatement.java:40)
        at org.codehaus.groovy.classgen.asm.StatementWriter.writeBlockStatement(StatementWriter.java:81)
        at org.codehaus.groovy.classgen.asm.OptimizingStatementWriter.writeBlockStatement(OptimizingStatementWriter.java:155)
        at org.codehaus.groovy.classgen.AsmClassGenerator.visitBlockStatement(AsmClassGenerator.java:493)
        at org.codehaus.groovy.ast.stmt.BlockStatement.visit(BlockStatement.java:69)
        at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitClassCodeContainer(ClassCodeVisitorSupport.java:101)
        at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitConstructorOrMethod(ClassCodeVisitorSupport.java:112)
        at org.codehaus.groovy.classgen.AsmClassGenerator.visitStdMethod(AsmClassGenerator.java:357)
        at org.codehaus.groovy.classgen.AsmClassGenerator.visitConstructorOrMethod(AsmClassGenerator.java:314)
        at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitConstructor(ClassCodeVisitorSupport.java:119)
        at org.codehaus.groovy.classgen.AsmClassGenerator.visitConstructor(AsmClassGenerator.java:429)
        at org.codehaus.groovy.ast.ClassNode.visitContents(ClassNode.java:1059)
        at org.codehaus.groovy.ast.ClassCodeVisitorSupport.visitClass(ClassCodeVisitorSupport.java:50)
        at org.codehaus.groovy.classgen.AsmClassGenerator.visitClass(AsmClassGenerator.java:177)
        at org.codehaus.groovy.control.CompilationUnit$16.call(CompilationUnit.java:805)
        at org.codehaus.groovy.control.CompilationUnit.applyToPrimaryClassNodes(CompilationUnit.java:1047)
        at org.codehaus.groovy.control.CompilationUnit.doPhaseOperation(CompilationUnit.java:583)
        at org.codehaus.groovy.control.CompilationUnit.processPhaseOperations(CompilationUnit.java:561)
        at org.codehaus.groovy.control.CompilationUnit.compile(CompilationUnit.java:538)
        at org.jetbrains.groovy.compiler.rt.GroovyCompilerWrapper.compile(GroovyCompilerWrapper.java:54)
        at org.jetbrains.groovy.compiler.rt.DependentGroovycRunner.runGroovyc(DependentGroovycRunner.java:87)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:606)
        at org.jetbrains.groovy.compiler.rt.GroovycRunner.main(GroovycRunner.java:100)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:606)
        at com.intellij.rt.execution.CommandLineWrapper.main(CommandLineWrapper.java:121)
