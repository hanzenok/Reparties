rm *.jar

jar cvf matrix.jar bin/m2geii/reparties/matrix/*.class
jar cvf server.jar bin/m2geii/reparties/papp/server/*.class
jar cvf interface.jar bin/m2geii/reparties/papp/inter/*.class
jar cvf client.jar bin/m2geii/reparties/mapp/*.class