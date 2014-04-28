package acme

import groovy.util.logging.Slf4j

@Slf4j
class TaskConfig implements Map {

    @Delegate
    protected final Map configProperties

    TaskConfig( Map delegate ) {
        configProperties = delegate
    }

}