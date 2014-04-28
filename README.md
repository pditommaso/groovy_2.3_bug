
In order to reproduce the issue, enter: 

    ./gradlew compileGroovy 
    
    

It reports: 

    FAILURE: Build failed with an exception.

    * What went wrong:
    Execution failed for task ':modulex:compileGroovy'.
    > BUG! exception in phase 'class generation' in source unit '/Users/pditommaso/Downloads/groovy_2.3_bug/subprojects/modulex/src/main/Main.groovy' Type is null. Most probably you let a transform reuse existing ClassNodes with generics information, that is now used in a wrong context.
