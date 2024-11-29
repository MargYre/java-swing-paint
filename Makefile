JAVAC = javac
JAVA = java
SRC_DIR = src
CLASS_DIR = src

all: compile run

compile:
	@mkdir -p $(CLASS_DIR)
	@$(JAVAC) -d $(CLASS_DIR) $(SRC_DIR)/*.java $(SRC_DIR)/gui/*.java

run: compile
	@$(JAVA) -cp $(CLASS_DIR) Main

clean:
	@rm -f $(CLASS_DIR)/*.class
	@rm -f $(CLASS_DIR)/gui/*.class