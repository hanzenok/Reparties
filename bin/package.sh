rm *.jar

jar cvf matrix.jar m2geii/reparties/matrix/*.class
jar cfm papp.jar manifest_papp.txt m2geii/reparties/papp/server/*.class
jar cvf papp_inter.jar m2geii/reparties/papp/inter/*.class
jar cfm mapp.jar manifest_mapp.txt m2geii/reparties/mapp/*.class
