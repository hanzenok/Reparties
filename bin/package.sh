rm *.jar

jar cvf matrix.jar m2geii/reparties/matrix/*.class
jar cvf server.jar m2geii/reparties/papp/server/*.class
jar cvf interface.jar m2geii/reparties/papp/inter/*.class
jar cvf client.jar m2geii/reparties/mapp/*.class
