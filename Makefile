JAVAC = javac
JAVA = java
SRC_DIR = src
CLASS_DIR = src

all: clean compile run

compile:
	@mkdir -p $(CLASS_DIR)
	@$(JAVAC) -d $(CLASS_DIR) $(SRC_DIR)/*.java

run:
	@$(JAVA) -cp $(CLASS_DIR) Main

clean:
	@rm -f $(CLASS_DIR)/*.class