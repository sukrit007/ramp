#!/bin/sh
# javadocs cannot use classpath variables in Eclipse. Provide workaround so that a team can share common .classpath and .project files.
# change the default location with grails create-eclipse-files --cpvars-dir=/some/other/dir
mkdir -p "/home/sukrit/.gvm/grails/2.2.4/eclipse-cpvars"
cd "/home/sukrit/.gvm/grails/2.2.4/eclipse-cpvars"
ln -s "/home/sukrit/.grails/ivy-cache" "GRAILS_IVYCACHE"
ln -s "/home/sukrit/.grails/2.2.4" "GRAILS_WORKDIR"
echo "Run grails create-eclipse-files again to create common paths to javadocs in .classpath (team members can share .classpath files and they can be in versioned in the source code repository)"
