# Change java home location
export JAVA_HOME=JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home

# java program
javac -d packages -cp packages src/Logger/*.java
javac -d packages -cp packages src/ConnectX/ConnectXBoard.java
javac -d packages -cp packages src/RulesStrategies/Rules.java
javac -d packages -cp packages src/MCTS/MCTsNode.java
javac -d packages -cp packages src/RulesStrategies/Strategies.java
javac -d packages -cp packages src/MCTS/*.java
javac -d packages -cp packages src/ConnectX/ConnectX.java
javac -d packages -cp packages src/ConnectX/*.java
javac -d packages -cp packages src/GA/*.java
javac -d packages -cp packages src/*.java


java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX RAND RAND 1000 4 1 0 
java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX RAND RAND 2000 4 1 0 
java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX RAND RAND 3000 4 1 0 
java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX RAND NAIVE 1000 4 1 0 
java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE RAND 1000 4 1 0 
java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE NAIVE 1000 4 1 0 
java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE NAIVE 2000 4 1 0 

















































# TESTING ********************************************



# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE NAIVE 3000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{5} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{10} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{20} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{30} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{40} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{50} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{60} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{70} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{80} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{90} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{100} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{150} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{200} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{250} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{300} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{350} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{400} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{450} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{500} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{650} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{700} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{750} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{800} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{900} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{1000} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{2000} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{3000} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{4000} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{5000} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{6000} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{7000} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{8000} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{9000} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX NAIVE MCTS{10000} 1000 4 1 0 


# TEST MCTS AGAINST MCTS WITH RULES IN TREE SEARCH AND SIMULATION
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{5:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{10:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{15:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{20:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{30:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{40:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{50:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{60:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{70:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{80:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{90:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{100:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{150:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{200:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{300:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{350:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{400:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{450:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{500:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{650:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{700:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{750:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{800:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{850:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{900:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{1000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{2000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{3000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{4000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{5000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{6000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{7000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{8000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{9000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{10000:1:1} 1000 4 1 0 


# # TEST MCTS AGAINST MCTS WITH RULES IN TREE SEARCH
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{7:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{10:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{20:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{30:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{40:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{50:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{60:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{70:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{80:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{90:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{100:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{150:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{200:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{300:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{350:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{400:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{450:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{500:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{650:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{700:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{750:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{800:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{850:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{900:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{1000:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{2000:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{3000:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{4000:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{5000:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{6000:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{7000:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{8000:1:0} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{9000:1:0} 1000 4 1 0 

# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{10000:1:0} 1000 4 1 0 


# TEST MCTS AGAINST MCTS 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{5} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{10} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{20} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{30} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{40} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{50} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{60} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{70} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{80} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{90} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{100} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{150} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{200} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{300} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{350} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{400} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{450} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{500} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{650} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{700} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{750} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{800} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{850} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{900} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{1000} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{2000} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{3000} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{4000} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{5000} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{6000} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{7000} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{8000} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{9000} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{10000} 1000 4 1 0






# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{7:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{10:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{20:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{30:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{40:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{50:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{60:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{70:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{80:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{90:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{100:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{150:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{200:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{300:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{350:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{400:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{450:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{500:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{650:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{700:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{750:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{800:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{850:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{900:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{1000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{2000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{3000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{4000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{5000:1:1} 1000 4 1 0 


# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{6000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{7000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{8000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{9000:1:1} 1000 4 1 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{10000:1:1} 1000 4 1 0 

# PLAYER1ALGORITHM PLAYER2ALGORITHM ITERATIONS GAMEMODE LOG DEBUG
# java -cp packages src/Main ConnectX MCTS{1000} MCTS{1000} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{255:255:255:255:255} NAIVE{255:255:255:255:255} 1 4 1 1
# java -cp packages src/Main ConnectX NAIVE{72:45396:10050:25133:44314:2589} NAIVE{65536:65536:65536:65536:65536:1} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{65536:65536:65536:65536:65536:1} NAIVE{72:45396:10050:25133:44314:2589} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{3000:65536:30000:3000:10000:1} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{30000:30000:30000:30000:30000:30000:1} NAIVE{10000:10000:30000:10000:10000:10000:1} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{500:500:500} NAIVE{500:500:500} 10000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{220:220:220:220:220} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{100:100:100:100:100} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{256:256:256:256:256} NAIVE{173:123:176:246:224} 10000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{80:238:72:225} NAIVE 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE MCTs{20} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE MCTs{20} 1000 4 1 0

# GENETIC ALGORITHM 
# GA ALOGIRTHM POPULATIONSIZE ITERTATIONS NUMPLAYS NUMBEROFSTRATEGIES GAMEMODE LOG DEBUG

# java -cp packages src/Main GA NAIVE 200 500 20 6 4 4 0 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main GA NAIVE 200 20 20 6 4 4 0 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main GA NAIVE 200 40 20 6 4 4 0 0 
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main GA NAIVE 200 500 20 6 4 4 0 0 
# java -cp packages src/Main GA NAIVE 10 10 2 6 4 4 0 0 
# cat log/*Import.log > all.txt
# 8, 123, 101, 58, 16, -110
# java -cp packages src/Main ConnectX MCTs{1000} MCTs{2:1:0} 1000 4 1 0
# java -cp packages src/Main ConnectX MCTs{1000} MCTs{3:1:0} 1000 4 1 0
# java -cp packages src/Main ConnectX MCTs{1000} MCTs{4:1:0} 1000 4 1 0
# java -cp packages src/Main ConnectX MCTs{1000} MCTs{5:1:0} 1000 4 1 0
# java -cp packages src/Main ConnectX MCTs{1000} MCTs{6:1:0} 1000 4 1 0
# java -cp packages src/Main ConnectX MCTs{1000} MCTs{7:1:0} 1000 4 1 0
# java -cp packages src/Main ConnectX MCTs{1000:1:0} MCTs{10:1:0} 1000 4 1 0
# java -cp packages src/Main ConnectX MCTs{1000:1:0} MCTs{1000:1:0} 100 4 1 0
# java -cp packages src/Main ConnectX MCTs{1000:1:0} MCTs{1000:1:0:8:123:101:58:16:-110}} 100 4 1 0
# java -cp packages src/Main ConnectX MCTs{1000:1:0:8:123:101:58:16:-110}} MCTs{1000:1:0} 100 4 1 0
# java -cp packages src/Main ConnectX NAIVE MCTs{1000:1:0} 100 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{8:123:101:58:16:-110} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{8:123:101:58:16:-110} NAIVE 1000 4 1 0



# java -cp packages src/Main ConnectX NAIVE{11:92:95:113:70:0} NAIVE{15:88:80:122:41:9} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:88:80:122:41:9} NAIVE{11:92:95:113:70:0} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{33:56:108:124:31:-83} NAIVE{15:88:80:122:41:9} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:88:80:122:41:9} NAIVE{33:56:108:124:31:-83} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{14:67:120:122:-29:-6} NAIVE{15:88:80:122:41:9} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:88:80:122:41:9} NAIVE{14:67:120:122:-29:-6} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{26:120:127:75:90:74} NAIVE{15:88:80:122:41:9} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:88:80:122:41:9} NAIVE{26:120:127:75:90:74} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{26:65:79:72:110:-120} NAIVE{15:88:80:122:41:9} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:88:80:122:41:9} NAIVE{26:65:79:72:110:-120} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{-8:52:87:101:-101:-12} NAIVE{15:88:80:122:41:9} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:88:80:122:41:9} NAIVE{-8:52:87:101:-101:-12} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{87:1:50:107:-118:-72} NAIVE{15:88:80:122:41:9} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:88:80:122:41:9} NAIVE{87:1:50:107:-118:-72} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{76:74:65:73:-4:1} NAIVE{15:88:80:122:41:9} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:88:80:122:41:9} NAIVE{76:74:65:73:-4:1} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{18:84:93:53:125:-30} NAIVE{15:88:80:122:41:9} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:88:80:122:41:9} NAIVE{18:84:93:53:125:-30} 1000 4 1 0





# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:33:-11} NAIVE{8:33:72:110:-26:-2} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{8:33:72:110:-26:-2} NAIVE{22:112:78:124:33:-11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:33:-11} NAIVE{8:104:113:122:50:3} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{8:104:113:122:50:3} NAIVE{22:112:78:124:33:-11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:33:-11} NAIVE{20:97:61:114:116:-6} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{20:97:61:114:116:-6} NAIVE{22:112:78:124:33:-11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:33:-11} NAIVE{12:120:113:126:-37:-3} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{12:120:113:126:-37:-3} NAIVE{22:112:78:124:33:-11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:33:-11} NAIVE{12:75:113:126:-103:-2} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{12:75:113:126:-103:-2} NAIVE{22:112:78:124:33:-11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:33:-11} NAIVE{15:122:90:108:53:-7} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{15:122:90:108:53:-7} NAIVE{22:112:78:124:33:-11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:33:-11} NAIVE{2:98:122:127:71:-20} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{2:98:122:127:71:-20} NAIVE{22:112:78:124:33:-11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:33:-11} NAIVE{14:104:75:126:97:2} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{14:104:75:126:97:2} NAIVE{22:112:78:124:33:-11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:33:-11} NAIVE{12:106:77:124:105:-2} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{12:106:77:124:105:-2} NAIVE{22:112:78:124:33:-11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{54:120:99:19:-107} NAIVE 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{54:120:99:19:-107} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:-11} NAIVE 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{22:112:78:124:-11} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{22:112:78:124:-11} NAIVE{52:123:14:112:13} 1 4 1 1
# java -cp packages src/Main ConnectX NAIVE{52:123:14:112:13} NAIVE{22:112:78:124:-11} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{18:127:104:104:-3} NAIVE{27:112:85:103:-3} 1000 4 1 0

# cat log/*Import.log > all.txt

# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main GA NAIVE 200 500 20 6 4 4 0 0 

# java -cp packages src/Main ConnectX NAIVE{10:10:10:10:10:-15} NAIVE{10:10:10:10:10:-15} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{-10:-10:-10:-10:-10:-15} NAIVE{10:100:150:10:60:-15} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{54:127:124:42:92:-113} NAIVE{39:125:33:56:-20:119} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{54:127:124:42:92:-113} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{120:120:120:120:120:-120} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE{120:120:120:120:120:-120} NAIVE{39:125:33:56:-20:119} 1000 4 1 0

# java -cp packages src/Main GA NAIVE 100 500 20 6 4 4 0 0 




# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{29:126:100:88:112:-96} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{29:126:100:88:112:-96} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{29:71:110:45:-29:17} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{29:71:110:45:-29:17} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{38:125:91:45:1:-44} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{38:125:91:45:1:-44} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{5:123:73:99:14:-5} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{5:123:73:99:14:-5} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{44:120:111:109:9:39} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{44:120:111:109:9:39} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{3:112:127:62:-18:11} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{3:112:127:62:-18:11} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{22:112:101:121:16:87} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{22:112:101:121:16:87} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{55:108:44:60:54:103} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{55:108:44:60:54:103} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{23:104:100:44:70:103} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{23:104:100:44:70:103} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{54:125:104:58:28:113} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{54:125:104:58:28:113} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{39:125:33:56:-20:119} NAIVE{39:125:33:56:-20:119} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{39:125:33:56:-20:119} 1000 4 1 0

# cat log/*Import.log > all.txt


# java -cp packages src/Main ConnectX NAIVE{59:11:114:99:99:-79} NAIVE{10:-9:120:71:68:-12} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{10:-9:120:71:68:-12} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{59:11:114:99:99:-79} NAIVE{64:0:84:112:86:85} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{64:0:84:112:86:85} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{59:11:114:99:99:-79} NAIVE{42:-14:90:70:111:-14} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{42:-14:90:70:111:-14} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{59:11:114:99:99:-79} NAIVE{43:-17:120:87:64:-86} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{43:-17:120:87:64:-86} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{59:11:114:99:99:-79}  NAIVE{42:8:121:103:96:-36} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{42:8:121:103:96:-36} 1000 4 1 0

# java -cp packages src/Main ConnectX NAIVE{59:11:114:99:99:-79} NAIVE{59:11:114:99:99:-79} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{59:11:114:99:99:-79} 1000 4 1 0

# cat log/*Import.log > all.txt


# java -cp packages src/Main ConnectX NAIVE{59:11:114:99:99:-79} NAIVE{10:120:120:71:68:-12} 1000 4 1 0
# java -cp packages src/Main ConnectX NAIVE NAIVE{10:120:120:71:68:-12} 1000 4 1 0
# java -cp packages src/Main ConnectX MCTS{1000} MCTS{250:1:0} 100 4 1 0
# java -cp packages src/Main ConnectX MCTS{1000} MCTS{250:1:0:116:42:82:49:111:111} 100 4 1 0
# java -cp packages src/Main ConnectX MCTS{1000} MCTS{250:1:0:-105:72:21:86:33:32} 100 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main GA MCTS{250:1:0} 35 60 20 5 4 4 0 0 



# 113, 63, 45, 50, -37, -67

# -81, 38, 43, 44, -21, -72

# -113, 53, 44, 34, -37, -64



# GA WITH 6 STRATEGIES 

# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:55:-113.0:-6:90:93:13} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:7:-33:-99:-105:11:-60} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:44:-113:-55:104:59:-68} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:32:-80:-119:108:19:-126} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:46:-81:-117:116:51:-118} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:100:-58:-116:100:35:-126} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:102:-82:20:100:3:-108} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:123:-67:-50:108:74:-77} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:77:-144:-85:76:13:-5} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:-110:-76:5:128:85:76} 1000 4 1 0


# GA WITH 5 STRATEGIES

# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:-113:53:44:34:-37.0 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:113:63:45:50:-37} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:-101:36:94:93:-13} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:97:100:108:90:41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:35:99:77:122:33} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:43:96:105:57:-1} 1000 4 1 0





# java -cp packages src/Main ConnectX MCTS{1000} MCTS{250:1:0:-81:38:43:44:-21:-72} 1000 4 1 0
# java -cp packages src/Main ConnectX MCTS{1000} MCTS{250:1:0:113:63:45:50:-37:-67} 1000 4 1 0

# java -cp packages src/Main ConnectX MCTS{1000} MCTS{250:1:0:-101:36:94:93:-13:-13} 100 4 1 0




# java -cp packages src/Main ConnectX NAIVE NAIVE 1 4 1 1




java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{7:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{10:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{20:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{30:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{40:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{50:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{60:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{70:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{80:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{90:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{100:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{150:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{200:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{300:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{350:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{400:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{450:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{500:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{650:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{700:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{750:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{800:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{850:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{900:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{1000:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{2000:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{3000:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{4000:1:0:97:37:126:78:-41} 1000 4 1 0
# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{5000:1:0:97:37:126:78:-41} 1000 4 1 0











# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main GA NAIVE 200 500 20 6 4 0 0

# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main ConnectX MCTS{1000} MCTS{250:1:0:-113:53:44:34:-37.0 1000 4 1 0


# java -cp packages -javaagent:joularjx/target/joularjx-2.8.2.jar src.Main GA MCTS{250:1:0} 35 60 20 5 4 4 0 0 



# java -cp packages src/Main ConnectX NAIVE NAIVE 1 4 1 1
